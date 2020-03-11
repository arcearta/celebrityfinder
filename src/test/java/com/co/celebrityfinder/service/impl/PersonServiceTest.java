package com.co.celebrityfinder.service.impl;


import static org.junit.Assert.assertEquals;

import com.co.celebrityfinder.service.dto.PeopleDto;
import com.co.celebrityfinder.service.impl.PersonService;

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
    PersonService personService;
    PersonService personServiceSpy;

    CsvReader csvReader;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        personServiceSpy = Mockito.spy(personService);
        csvReader = new CsvReader();
    }


    @Test
    public void celebrityFoundUsingRecursiveMethodTest() throws IOException {
        InputStream fis = CsvReaderTest.class.getClassLoader().getResourceAsStream("listOfPeople.csv");
        PeopleDto peopleDto = new PeopleDto(csvReader.readFile(fis));
        assertEquals(5, personService.findCelebrityRecursive(peopleDto) + 1);
    }

    @Test
    public void celebrityFoundIn_row_5_FromCsvTest() throws IOException {
         InputStream fis = CsvReaderTest.class.getClassLoader().getResourceAsStream("listOfPeople.csv");
         PeopleDto peopleDto = new PeopleDto(csvReader.readFile(fis));
         assertEquals(5, personService.findCelebrity(peopleDto) + 1);
    }

    @Test
    public void celebrityNotFoundFromCsvTest() throws IOException {
        InputStream fis = CsvReaderTest.class.getClassLoader().getResourceAsStream("listOfPeopleWithout_celebrity.csv");
        PeopleDto peopleDto = new PeopleDto(csvReader.readFile(fis));
        assertEquals(-1, personService.findCelebrity(peopleDto));
    }

    @Test
    public void celebrityFoundIn_row_0_FromCsvTest() throws IOException {
        InputStream fis = CsvReaderTest.class.getClassLoader().getResourceAsStream("listOfPeopleWith_celebrity_in_row_0.csv");
        PeopleDto peopleDto = new PeopleDto(csvReader.readFile(fis));
        assertEquals(0, personService.findCelebrity(peopleDto));
    }

}
