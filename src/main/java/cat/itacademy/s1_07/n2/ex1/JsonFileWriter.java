package cat.itacademy.s1_07.n2.ex1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonFileWriter {

    public void write(String filePath, String content) {
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
