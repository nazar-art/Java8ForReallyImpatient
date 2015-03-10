package com.demo.ch9.sec03;

import java.util.Objects;

/**
 * @author Nazar_Lelyak.
 */
public class Person {
    private String firstName;
    private String lastName;

    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Person other = (Person) otherObject;

        return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
    }

    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}