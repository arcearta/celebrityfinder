package com.co.celebrityfinder.service.impl;

import com.co.celebrityfinder.service.api.ICelebrityService;
import com.co.celebrityfinder.service.dto.PeopleDto;
import com.co.celebrityfinder.service.dto.PersonDto;
import com.co.celebrityfinder.util.CsvReader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;
import java.util.logging.Logger;
import java.util.stream.IntStream;

@Service
public class CelebrityService implements ICelebrityService {

    static Logger log = Logger.getLogger(CelebrityService.class.getName());

    public static final int PERSONA_KNOW_THE_PERSONB = 1;

    private static PeopleDto intputStreamToPopleDto(InputStream fis){
        try {
            return new PeopleDto(CsvReader.readFile(fis));
        } catch (IOException e) {
            log.info("Error reading the csv File: " + e.getMessage());
        }
        return null;
    }

    @Override
    public PersonDto findCelebrityPerson(final InputStream fis) {
        PeopleDto peopleDto = intputStreamToPopleDto(fis);
        return this.findCelebrityPerson(peopleDto);
    }

    /**
     * This method check if a person A know other person B
     * @param personA
     * @param personB
     * @return true if personA know the personB else return false
     */
    private static boolean knows(PeopleDto peopleDto, PersonDto personA, PersonDto personB)
    {
        boolean res = (peopleDto.getArrayOfPerson()[personA.getPersonId()][personB.getPersonId()] == PERSONA_KNOW_THE_PERSONB) ?
                true :
                false;

        return res;
    }


    /**
     * This method find the celebrity using a stack
     * @return a celebrityPerson, if the celebrity is not present return null
     */
    private PersonDto findCelebrityPerson(PeopleDto peopleDto)
    {
        Stack<PersonDto> stackOfPeople = createAndFillStack(peopleDto);

        while (stackOfPeople.size() > 1)
        {
            PersonDto personA = stackOfPeople.pop();
            PersonDto personB = stackOfPeople.pop();

           if (knows(peopleDto, personA, personB)) {
                stackOfPeople.push(personB);
            } else {
                stackOfPeople.push(personA);
            }
        }

        PersonDto celebrityPerson = stackOfPeople.pop();

        return checkCelebrityPerson(peopleDto, celebrityPerson) ? celebrityPerson : null;
    }

    private static Stack<PersonDto> createAndFillStack(PeopleDto peopleDto) {
        Stack<PersonDto> stackOfPeople = new Stack<>();

        IntStream.range(0, peopleDto.getArrayOfPerson().length)
                .forEach(index -> stackOfPeople.push(new PersonDto(index)));

        return stackOfPeople;
    }

    private static boolean checkCelebrityPerson(PeopleDto peopleDto, PersonDto celebrityPerson) {

        for (int personId = 0; personId < peopleDto.getArrayOfPerson().length; personId ++)
         {
             PersonDto person = new PersonDto(personId);
             if (!person.equals(celebrityPerson) && (knows(peopleDto, celebrityPerson, person) || !knows(peopleDto, person, celebrityPerson)))
                 return false;
         }
        return true;
    }
}
