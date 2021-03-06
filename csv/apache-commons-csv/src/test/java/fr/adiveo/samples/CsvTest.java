package fr.adiveo.samples;
import fr.adiveo.samples.domain.User;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Test;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * : Akram - 25/05/2020.
 */
public class CsvTest {

    public static final String[] HEADERS = { "firstname", "lastname", "age" };


    @Test
    public void givenCSVFile_whenRead_thenContentsAsExpected() throws IOException {
        Reader in = new FileReader("src/test/resources/users.csv");

        List<User> users = new ArrayList<>();
        users.add(new User("John", "Nash", 12));
        users.add(new User("Marc", "Fish", 23));
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader(HEADERS).withFirstRecordAsHeader().withDelimiter(';').parse(in);
        int index = 0;
        for(CSVRecord record : records) {
            assertEquals(users.get(index).getFirstName(), record.get("firstname"));
            assertEquals(users.get(index).getLastName(), record.get("lastname"));
            assertEquals(users.get(index).getAge(), Integer.parseInt(record.get("age")));
            index++;

        }
    }

    @Test
    public void givenUsersList_whenWrittenToStream_thenOutputStreamAsExpected() throws IOException {
        String expectedFilestream = "firstname;lastname;age" + System.lineSeparator() +
                "John;Nash;12" + System.lineSeparator() +
                "Marc;Fish;23" + System.lineSeparator();
        List<User> users = new ArrayList<>();
        users.add(new User("John", "Nash", 12));
        users.add(new User("Marc", "Fish", 23));

        Path temp = Files.createTempFile("users_", "export");
        BufferedWriter bufferedWriter = Files.newBufferedWriter(temp, Charset.defaultCharset());

        try(final CSVPrinter printer = new CSVPrinter(bufferedWriter, CSVFormat.DEFAULT.withHeader(HEADERS).withDelimiter(';'))) {

            users.forEach(user -> {
                try {
                    printer.printRecord(user.getFirstName(), user.getLastName(), user.getAge());
                } catch(IOException e) {
                    e.printStackTrace();
                }
            });
            printer.flush();
        }
        String linesAsString = Files.readString(temp);

        assertEquals(expectedFilestream, linesAsString);
    }

}
