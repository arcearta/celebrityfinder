package com.co.celebrityfinder.service.dto;

/**
 * This class content the list of people in an array of int values
 * A row is equals to a person
 * A column said if the person know a person in the same row position.
 * O value said if the person not know the other person.
 * 1 value said if the person know the other person.
 */
public class PeopleDto {

    private int arrayOfPeople[][];

    public PeopleDto(int arrayPeople[][]) {
        this.arrayOfPeople = arrayPeople;
    }

    public int[][] getArrayOfPeople() {
        return arrayOfPeople;
    }

    public void setArrayOfPeople(int[][] arrayOfPeople) {
        this.arrayOfPeople = arrayOfPeople;
    }
}
