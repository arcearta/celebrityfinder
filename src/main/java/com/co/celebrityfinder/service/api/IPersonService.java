package com.co.celebrityfinder.service.api;

import com.co.celebrityfinder.service.dto.PeopleDto;

import java.io.InputStream;
import java.util.List;

/**
 * Api de usuarios
 */
public interface IPersonService {

    /**
     * This Method find a celebrity into an array of people using a stack.
     * @param peopleDto PeopleDto with the array of the people
     * @return int with the position in the array of the celebrity or null if the celebrity not exist.
     */
    int findCelebrity(final PeopleDto peopleDto);

    /**
     * This Method find a celebrity into an array of people using a recursive method.
     * @param peopleDto PeopleDto with the array of the people
     * @return int with the position in the array of the celebrity or null if the celebrity not exist.
     */
    int findCelebrityRecursive(final PeopleDto peopleDto);
}
