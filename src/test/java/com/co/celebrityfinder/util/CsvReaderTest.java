package com.co.celebrityfinder.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.io.InputStream;

public class CsvReaderTest {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findCelebrityInRow5FromCsvTest() {

        CsvReader csvReader = new CsvReader();
        int people[][] = null;
        try {
            people = csvReader.readFile("/book.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(6, people.length);
    }


    @Test
    public void readCsvFileWith6rowsTest() {

        CsvReader csvReader = new CsvReader();
        InputStream fis = CsvReaderTest.class.getClassLoader().getResourceAsStream("book_5_rows.csv");
        int people[][] = null;
        try {
            people = csvReader.readFile(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(6, people.length );
    }


}
