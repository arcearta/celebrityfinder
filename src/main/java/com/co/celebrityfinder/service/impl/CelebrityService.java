package com.co.celebrityfinder.service.impl;

import com.co.celebrityfinder.service.api.ICelebrityService;
import com.co.celebrityfinder.service.dto.PeopleDto;
import com.co.celebrityfinder.service.dto.PersonDto;
import com.co.celebrityfinder.util.CsvReader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Stack;


@Service
public class CelebrityService implements ICelebrityService {

    private int [][] arrayKnowPeople;
    private boolean isCelebrity = true;

    /**
     *
     * @param fis
     */
    private PeopleDto intputStreamToPopleDto(InputStream fis){
        try {
            return new PeopleDto(CsvReader.readFile(fis));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public PersonDto findCelebrity(final InputStream fis) {
        PeopleDto peopleDto = intputStreamToPopleDto(fis);
        this.arrayKnowPeople = peopleDto.getArrayOfPerson();
        return this.findCelebrity();
    }

    /**
     * This method check if a person know other person
     * @param personA
     * @param personB
     * @return true if personA know the personB else return false
     */
    private boolean knows(PersonDto personA, PersonDto personB)
    {
        boolean res = (this.arrayKnowPeople[personA.getPersonId()][personB.getPersonId()] == 1) ?
                true :
                false;

        return res;
    }


    /**
     * This method find the celebrity using a stack
     * @return the celebrityId or position in the array of people, if the celebrity is not present return -1
     */
    private PersonDto findCelebrity()
    {
        Stack<PersonDto> stackOfPeople = new Stack<>();

        for (int i = 0; i < this.arrayKnowPeople.length; i++)
        {
            stackOfPeople.push(new PersonDto(i));
        }

        while (stackOfPeople.size() > 1)
        {
            PersonDto personA = stackOfPeople.pop();
            PersonDto personB = stackOfPeople.pop();

           if (knows(personA, personB)) {
                stackOfPeople.push(personB);
            } else {
                stackOfPeople.push(personA);
            }
        }

        PersonDto celebrityPerson = stackOfPeople.pop();

        /*Arrays.stream(this.arrayKnowPeople[0]).forEach(personRowID -> { this.
            PersonDto person = new PersonDto(personRowID);
            if (personRowID != celebrityPerson.getPersonId() &&  (knows(celebrityPerson, person) || !knows(person, celebrityPerson)))
                isCelebrity = false;
        });*/

       for (int personId = 0; personId < this.arrayKnowPeople.length; personId++)
        {
            PersonDto person = new PersonDto(personId);
            if (!person.equals(celebrityPerson) && (knows(celebrityPerson, person) || !knows(person, celebrityPerson)))
                isCelebrity = false;
        }

        return isCelebrity == true ? celebrityPerson : null;

    }

}
