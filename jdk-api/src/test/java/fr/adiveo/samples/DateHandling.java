package fr.adiveo.samples;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DateHandling {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test_custom_datetime_formatter() {

        LocalDateTime localDateTime = LocalDateTime.of(2020, 05, 01, 12, 22, 20);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
        assertEquals("2020-05-01-12:22:20", formatter.format(localDateTime));

    }

    @Test
    public void test_iso_datetime_formatter() {

        LocalDateTime localDateTime = LocalDateTime.of(2020, 05, 01, 12, 22, 20);
        assertEquals("2020-05-01T12:22:20", DateTimeFormatter.ISO_DATE_TIME.format(localDateTime));

    }


    @Test
    public void test_parse_iso_datetime() {

        LocalDateTime localDateTime = LocalDateTime.of(2020, 05, 01, 12, 22, 20);
        assertEquals(localDateTime, LocalDateTime.parse("2020-05-01T12:22:20"));

    }

    @Test
    public void test_parse_custom_datetime() {

        LocalDateTime localDateTime = LocalDateTime.of(2020, 05, 01, 12, 22, 20);
        assertEquals(localDateTime, LocalDateTime.parse("2020-05-01-12:22:20", DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss")));

    }
}
