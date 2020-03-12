package com.co.celebrityfinder.service.dto;

import java.util.Objects;

/**
 * This class content the row number in the csv file that represent a persona
 */
public class PersonDto {
    private Integer personId;

    public PersonDto(Integer personId){
     this.personId = personId;
    }

    public Integer getPersonId() {
        return personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDto personDto = (PersonDto) o;
        return Objects.equals(personId, personDto.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId);
    }
}
