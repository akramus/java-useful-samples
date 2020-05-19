package fr.adiveo.samples;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * : LCR - 19/05/2020.
 */
public class FilesHandling {


    @Test
    public void test_create_temp_files() throws IOException {

        Path tmpFile = Files.createTempFile("export", "users_");
        BufferedWriter writer = Files.newBufferedWriter(tmpFile, Charset.defaultCharset());
        writer.write("This is a test");
        writer.flush();
        writer.close();

        assertEquals("This is a test",Files.readString(tmpFile));

    }

    @Test
    public void test_read_file() throws IOException {

        Path file1  = Paths.get("src/test/resources/test.txt");
        List<String> allLines  = Files.readAllLines(file1);
        assertEquals(4,allLines.size());
        assertEquals("This is a test",allLines.get(0));
        assertEquals("Second line",allLines.get(1));
        assertEquals("Third line",allLines.get(2));
        assertEquals("End",allLines.get(3));

    }




}
