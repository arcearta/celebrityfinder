package com.co.celebrityfinder.service.dto;

/**
 * This class content the list of know person
 * A row is equals to a person
 * A column said if the person know a person in the same row position.
 * O value said if the person not know the other person.
 * 1 value said if the person know the other person.
 */
public class PeopleDto {

    private int arrayOfPersonRelations[][];

    public PeopleDto(int arrayOfPersonRelations[][]) {
        this.arrayOfPersonRelations = arrayOfPersonRelations;
    }

    public int[][] getArrayOfPersonRelations() {
        return this.arrayOfPersonRelations;
    }

}
