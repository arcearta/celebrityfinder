package com.co.celebrityfinder.service.dto;

import java.util.List;
import java.util.Objects;

/**
 * This class content the list of people in an array of int values
 * A row is equals to a person
 * A column said if the person know a person in the same row position.
 * O value said if the person not know the other person.
 * 1 value said if the person know the other person.
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
