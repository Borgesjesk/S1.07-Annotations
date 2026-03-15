package cat.itacademy.s1_07.n2.ex1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class JsonSerializer {

    public void serialize(Object object) {
        Class<?> clazz = object.getClass();

        if (!clazz.isAnnotationPresent(JsonSerializable.class)) {
            System.err.println("Class " + clazz.getSimpleName() + " is not annotated with @JsonSerializable");
            return;
        }

        JsonSerializable annotation = clazz.getAnnotation(JsonSerializable.class);
        String directory = annotation.directory();
        String fileName = clazz.getSimpleName().toLowerCase() + ".json";
        String filePath = System.getProperty("user.dir") + File.separator
                + directory.replace("/", File.separator) + File.separator + fileName;

        String json = buildJson(object, clazz);
        writeToFile(filePath, json);
    }

    private String buildJson(Object object, Class<?> clazz) {
        StringBuilder json = new StringBuilder("{\n");
        Field[] fields = clazz.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                String fieldName = fields[i].getName();
                Object fieldValue = fields[i].get(object);
                json.append("  \"").append(fieldName).append("\": ");

                if (fieldValue instanceof String) {
                    json.append("\"").append(fieldValue).append("\"");
                } else {
                    json.append(fieldValue);
                }

                if (i < fields.length - 1) json.append(",");
                json.append("\n");
            } catch (IllegalAccessException e) {
                System.err.println("Error accessing field: " + e.getMessage());
            }
        }
        json.append("}");
        return json.toString();
    }

    private void writeToFile(String filePath, String content) {
        File outputFile = new File(filePath);
        outputFile.getParentFile().mkdirs();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(content);
            System.out.println("JSON saved to: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error writing JSON file: " + e.getMessage());
        }
    }
}