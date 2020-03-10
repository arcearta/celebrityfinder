package com.co.celebrityfinder.service;


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
    public void findCelebrityInRow5FromCsvTest() throws IOException {
         InputStream fis = CsvReaderTest.class.getClassLoader().getResourceAsStream("book.csv");
         PeopleDto peopleDto = new PeopleDto(csvReader.readFile(fis));
         assertEquals(5, personService.findCelebrity(peopleDto) + 1);
    }

    @Test
    public void notCelebrityFoundTest() throws IOException {
        InputStream fis = CsvReaderTest.class.getClassLoader().getResourceAsStream("not_celebrity.csv");
        PeopleDto peopleDto = new PeopleDto(csvReader.readFile(fis));
        assertEquals(-1, personService.findCelebrity(peopleDto));
    }

    @Test
    public void celebrityFoundIn_0_row_Test() throws IOException {
        InputStream fis = CsvReaderTest.class.getClassLoader().getResourceAsStream("celebrity_0_rows.csv");
        PeopleDto peopleDto = new PeopleDto(csvReader.readFile(fis));
        assertEquals(0, personService.findCelebrity(peopleDto));
    }

}
