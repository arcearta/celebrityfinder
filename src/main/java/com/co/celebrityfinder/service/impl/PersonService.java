package com.co.celebrityfinder.service.impl;

import com.co.celebrityfinder.service.api.IPersonService;
import com.co.celebrityfinder.service.dto.PeopleDto;
import org.springframework.stereotype.Service;
import java.util.Stack;


@Service
public class PersonService implements IPersonService {

    private int [][] arrayPeople;

    public PersonService(){
    }

    @Override
    public int findCelebrity(final PeopleDto peopleDto) {
        this.arrayPeople = peopleDto.getArrayOfPeople();
        return this.findCelebrityByStack();
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
     * This method use a recursive algoritm to find the celebrity
     * @param personIdA
     * @param expectedCelebrityId
     * @return the position of the celebrityID if this is present
     */
     public int findCelebrityRecursive(int personIdA, int expectedCelebrityId) {
        if(expectedCelebrityId >= this.arrayPeople.length) {
            return personIdA;
        }
        //Check if personIdA know the personIdB
        if(knows(personIdA, expectedCelebrityId)) {
            personIdA = findCelebrityRecursive(expectedCelebrityId, 0); //
        }else {
            personIdA = findCelebrityRecursive(personIdA, expectedCelebrityId + 1);
        }
        return personIdA;
    }
    // Returns -1 if celebrity
    // is not present. If present,
    // returns id (value from 0 to n-1).

    /**
     * This method find the celebrity using a stack
     * @return the celebrityId or position in the array of people, if the celebrity is not present return -1
     */
    private int findCelebrityByStack()
    {
        Stack<Integer> stackOfPeople = new Stack<>();
        int celebrityId;

        //Push every person into the stack
        for (int i = 0; i < this.arrayPeople.length; i++)
        {
            stackOfPeople.push(i);
        }

        while (stackOfPeople.size() > 1)
        {
            // Pop two persons from the stack in order to compare if the first person know the second person
            int personIdA = stackOfPeople.pop();
            int expectedCelebrityId = stackOfPeople.pop();

            // if the personIdA know the expected Celebrity then push in the stack the celebrityId else push the personIdA
            if (knows(personIdA, expectedCelebrityId)) {
                stackOfPeople.push(expectedCelebrityId);
            } else {
                stackOfPeople.push(personIdA);
            }
        }
        //Extract the last PersonId this is the expected celebrity
        celebrityId = stackOfPeople.pop();

        //Check if the CelebrityPerson is correct
        for (int personId = 0; personId < this.arrayPeople.length; personId++)
        {
            // If someone person doesn't know the celebrityPerson then return -1
            if (personId != celebrityId && (knows(celebrityId, personId) || !knows(personId, celebrityId)))
                return -1;
        }
        return celebrityId;
    }

}
