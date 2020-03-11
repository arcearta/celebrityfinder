package com.co.celebrityfinder.service.impl;


import static org.junit.Assert.assertEquals;

import com.co.celebrityfinder.service.dto.PeopleDto;

import com.co.celebrityfinder.util.CsvReader;
import com.co.celebrityfinder.util.CsvReaderTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.io.InputStream;

public class PersonServiceTest {

    @InjectMocks
    CelebrityService personService;
    CelebrityService personServiceSpy;

    CsvReader csvReader;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        personServiceSpy = Mockito.spy(personService);
        csvReader = new CsvReader();
    }


    @Test
    public void celebrityFoundIn_row_5_FromCsvTest() throws IOException {
         InputStream fis = CsvReaderTest.class.getClassLoader().getResourceAsStream("listOfPeople.csv");
         assertEquals(5, personService.findCelebrity(fis) + 1);
    }

    @Test
    public void celebrityNotFoundFromCsvTest() throws IOException {
        InputStream fis = CsvReaderTest.class.getClassLoader().getResourceAsStream("listOfPeopleWithout_celebrity.csv");

        assertEquals(-1, personService.findCelebrity(fis));
    }

    @Test
    public void celebrityFoundIn_row_0_FromCsvTest() throws IOException {
        InputStream fis = CsvReaderTest.class.getClassLoader().getResourceAsStream("listOfPeopleWith_celebrity_in_row_0.csv");

        assertEquals(0, personService.findCelebrity(fis));
    }

}
