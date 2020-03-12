package com.co.celebrityfinder.service.api;

import com.co.celebrityfinder.service.dto.PersonDto;

import java.io.InputStream;


public interface ICelebrityService {

    /**
     * This Method find a celebrity person into an array of people using a stack.
     * @param fis InputStream with the csv file
     * @return the person that is a celebrity or null if the celebrity not exist.
     */
    PersonDto findCelebrityPerson(final InputStream fis);


}
