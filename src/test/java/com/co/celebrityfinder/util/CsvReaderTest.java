package com.co.celebrityfinder.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CsvReaderTest {

    @Test
    public void readCsvFileWith6rowsTest() {

        InputStream fis = CsvReaderTest.class.getClassLoader().getResourceAsStream("listOfPeopleWith_celebrity_in_row_5.csv");
        int people[][] = null;
        try {
            people = CsvReader.readFile(fis);
        } catch (IOException e) {
            fail(e.getMessage());
        }

        assertEquals(6, people.length );
    }
}
