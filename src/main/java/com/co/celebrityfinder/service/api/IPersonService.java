package com.co.celebrityfinder.service.api;

import com.co.celebrityfinder.service.dto.PeopleDto;

import java.io.InputStream;
import java.util.List;

/**
 * Api de usuarios
 */
public interface IPersonService {

    /**
     * This Method read a inputstream file and return the celebrity position record in the csv file
     * the inputstream need be a csv file.
     * @param peopleDto PeopleDto with the array of the people
     * @return int with the position in the array of the celebrity or null if the celebrity not exist.
     */
    int findCelebrity(final PeopleDto peopleDto);
}
