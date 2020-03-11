package com.co.celebrityfinder.service.impl;

import com.co.celebrityfinder.service.api.ICelebrityService;
import com.co.celebrityfinder.service.dto.PeopleDto;
import com.co.celebrityfinder.util.CsvReader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;


@Service
public class CelebrityService implements ICelebrityService {

    private int [][] arrayPeople;

    private void intputStreamToPopleDto(InputStream fis){
        try {
            PeopleDto peopleDto = new PeopleDto(CsvReader.readFile(fis));
            this.arrayPeople = peopleDto.getArrayOfPeople();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public int findCelebrity(final InputStream fis) {
        intputStreamToPopleDto(fis);
        return this.findCelebrity();
    }

    /**
     * This method check if a person know other person
     * @param personIdA
     * @param personIdB
     * @return true if personIdA know the personIdB else return false
     */
    private boolean knows(int personIdA, int personIdB)
    {
        boolean res = (this.arrayPeople[personIdA][personIdB] == 1) ?
                true :
                false;

        return res;
    }


    /**
     * This method find the celebrity using a stack
     * @return the celebrityId or position in the array of people, if the celebrity is not present return -1
     */
    private int findCelebrity()
    {
        Stack<Integer> stackOfPeople = new Stack<>();
        int celebrityId;

        for (int i = 0; i < this.arrayPeople.length; i++)
        {
            stackOfPeople.push(i);
        }

        while (stackOfPeople.size() > 1)
        {
             int personIdA = stackOfPeople.pop();
            int expectedCelebrityId = stackOfPeople.pop();

           if (knows(personIdA, expectedCelebrityId)) {
                stackOfPeople.push(expectedCelebrityId);
            } else {
                stackOfPeople.push(personIdA);
            }
        }

        celebrityId = stackOfPeople.pop();



        for (int personId = 0; personId < this.arrayPeople.length; personId++)
        {
            if (personId != celebrityId && (knows(celebrityId, personId) || !knows(personId, celebrityId)))
                return -1;
        }
        return celebrityId;
    }

}
