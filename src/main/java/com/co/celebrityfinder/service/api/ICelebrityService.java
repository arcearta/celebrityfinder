package com.co.celebrityfinder.service.api;

import java.io.InputStream;


/**
 * Api de usuarios
 */
public interface ICelebrityService {

    /**
     * This Method find a celebrity into an array of people using a stack.
     * @param fis InputStream with the csv file
     * @return int with the position in the array of the celebrity or null if the celebrity not exist.
     */
    int findCelebrity(final InputStream fis);


}
