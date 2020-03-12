package com.co.celebrityfinder.service.impl;

import static org.junit.Assert.assertEquals;

import com.co.celebrityfinder.service.dto.PersonDto;
import com.co.celebrityfinder.util.CsvReaderTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.io.InputStream;

public class CelebrityServiceTest {

    @InjectMocks
    CelebrityService personService;
    CelebrityService personServiceSpy;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        personServiceSpy = Mockito.spy(personService);
    }

    @Test
    public void celebrityFoundIn_row_5_FromCsvTest()  {
         InputStream fis = CsvReaderTest.class.getClassLoader().getResourceAsStream("listOfPeople.csv");
         PersonDto celebrityPerson = new PersonDto(4);
         assertEquals(celebrityPerson.getPersonId(), personService.findCelebrity(fis).getPersonId());
    }

    @Test
    public void celebrityNotFoundFromCsvTest() {
        InputStream fis = CsvReaderTest.class.getClassLoader().getResourceAsStream("listOfPeopleWithout_celebrity.csv");
        assert(personService.findCelebrity(fis) == null);
    }

    @Test
    public void celebrityFoundIn_row_0_FromCsvTest()  {
        InputStream fis = CsvReaderTest.class.getClassLoader().getResourceAsStream("listOfPeopleWith_celebrity_in_row_0.csv");
        PersonDto celebrityPerson = new PersonDto(0);
        assertEquals(celebrityPerson.getPersonId(), personService.findCelebrity(fis).getPersonId());
    }

}
