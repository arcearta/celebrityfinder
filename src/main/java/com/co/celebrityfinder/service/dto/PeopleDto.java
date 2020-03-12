package com.co.celebrityfinder.service.dto;

/**
 * This class content the list of people in an array of int values
 * A row is equals to a person
 * A column said if the person know a person in the same row position.
 * O value said if the person not know the other person.
 * 1 value said if the person know the other person.
 */
public class PeopleDto {

    private int arrayOfPerson[][];

    public PeopleDto(int arrayOfPerson[][]) {

        this.arrayOfPerson = arrayOfPerson;
    }

    public int[][] getArrayOfPerson() {
        return this.arrayOfPerson;
    }

    public void setArrayOfPeople(int[][] arrayOfPerson) {
        this.arrayOfPerson = arrayOfPerson;
    }
}
