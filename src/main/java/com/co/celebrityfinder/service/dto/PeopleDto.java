package com.co.celebrityfinder.service.dto;


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
