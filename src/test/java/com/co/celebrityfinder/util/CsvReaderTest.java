package com.co.celebrityfinder.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CsvReaderTest {

    @Test
    public void readCsvFileWith6rowsTest() {

        CsvReader csvReader = new CsvReader();
        InputStream fis = CsvReaderTest.class.getClassLoader().getResourceAsStream("listOfPeopleWith_celebrity_in_row_5.csv");
        int people[][] = null;
        try {
            people = csvReader.readFile(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(6, people.length );
    }
}
