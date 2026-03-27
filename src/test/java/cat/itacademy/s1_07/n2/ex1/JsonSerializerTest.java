package cat.itacademy.s1_07.n2.ex1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class JsonSerializerTest {

    private final JsonSerializer serializer = new JsonSerializer();

    // ── buildJson ──────────────────────────────────────────────────────────────

    @Test
    void buildJson_containsAllFieldNames() {
        Person person = new Person("Jessica", "Borges", 30);
        String json = serializer.buildJson(person, Person.class);

        assertTrue(json.contains("\"name\""));
        assertTrue(json.contains("\"surname\""));
        assertTrue(json.contains("\"age\""));
    }

    @Test
    void buildJson_containsStringFieldValues() {
        Person person = new Person("Jessica", "Borges", 30);
        String json = serializer.buildJson(person, Person.class);

        assertTrue(json.contains("\"Jessica\""));
        assertTrue(json.contains("\"Borges\""));
    }

    @Test
    void buildJson_containsIntFieldValue() {
        Person person = new Person("Jessica", "Borges", 30);
        String json = serializer.buildJson(person, Person.class);

        assertTrue(json.contains("30"));
    }

    @Test
    void buildJson_producesValidJsonStructure() {
        Person person = new Person("Jessica", "Borges", 30);
        String json = serializer.buildJson(person, Person.class);

        assertTrue(json.startsWith("{"));
        assertTrue(json.endsWith("}"));
    }

    // ── serialize() with annotated class ──────────────────────────────────────

    @Test
    void serialize_annotatedClass_writesFileWithCorrectContent(@TempDir File tempDir) throws Exception {
        // Use a local annotated class whose output we can intercept by
        // temporarily redirecting user.dir is not feasible, so we verify the
        // actual file written to the real output path instead.
        Person person = new Person("Ana", "Sousa", 25);

        // Capture the file path that will be written
        String directory = Person.class.getAnnotation(JsonSerializable.class).directory();
        String fileName = "person.json";
        File outputFile = new File(
                System.getProperty("user.dir") + File.separator
                + directory.replace("/", File.separator) + File.separator + fileName
        );

        serializer.serialize(person);

        assertTrue(outputFile.exists(), "Output file should be created");
        String content = Files.readString(outputFile.toPath());
        assertTrue(content.contains("\"name\""));
        assertTrue(content.contains("\"Ana\""));
        assertTrue(content.contains("\"surname\""));
        assertTrue(content.contains("\"Sousa\""));
        assertTrue(content.contains("\"age\""));
        assertTrue(content.contains("25"));

        // Clean up
        outputFile.delete();
    }

    @Test
    void serialize_annotatedClass_printsSavedMessage() {
        Person person = new Person("Ana", "Sousa", 25);
        PrintStream originalOut = System.out;
        ByteArrayOutputStream captured = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captured));

        try {
            serializer.serialize(person);
        } finally {
            System.setOut(originalOut);
            // Clean up written file
            String directory = Person.class.getAnnotation(JsonSerializable.class).directory();
            new File(System.getProperty("user.dir") + File.separator
                    + directory.replace("/", File.separator) + File.separator + "person.json").delete();
        }

        assertTrue(captured.toString().contains("JSON saved to:"));
    }

    // ── serialize() with non-annotated class ──────────────────────────────────

    @Test
    void serialize_nonAnnotatedClass_doesNotThrow() {
        Pet pet = new Pet("Cat", "Luna");
        assertDoesNotThrow(() -> serializer.serialize(pet));
    }

    @Test
    void serialize_nonAnnotatedClass_printsErrorToStderr() {
        Pet pet = new Pet("Cat", "Luna");
        PrintStream originalErr = System.err;
        ByteArrayOutputStream captured = new ByteArrayOutputStream();
        System.setErr(new PrintStream(captured));

        try {
            serializer.serialize(pet);
        } finally {
            System.setErr(originalErr);
        }

        assertTrue(captured.toString().contains("not annotated with @JsonSerializable"));
    }
}
