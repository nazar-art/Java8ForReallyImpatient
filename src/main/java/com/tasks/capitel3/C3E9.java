package com.tasks.capitel3;

import com.tasks.Exercise;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.*;

/**
 * Write a method lexicographicComparator(String... fieldNames) that yields a comparator
 * that compares the given fields in the given order. For example, a
 * lexicographicComparator("lastname", "firstname") takes two objects and, using
 * reflection, gets the values of the lastname field. If they are different, return the
 * difference, otherwise move on to the firstname field. If all fields match, return 0.
 */
public class C3E9 implements Exercise {

    class Person {
        private String firstname;
        private String lastname;

        Person(String firstname, String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }
    }

    @Test
    @Override
    public void perform() {
        Person[] persons = {
                new Person("John", "Green"),
                new Person(null, "Black"),
                new Person("Adam", "White")
        };
        Arrays.sort(persons, lexographicComparator("lastname", "firstname"));
        assertEquals("Black", persons[0].lastname);
        Arrays.sort(persons, lexographicComparator("firstname", "lastname"));
        assertEquals("White", persons[0].lastname);
    }

    public <T> Comparator<T> lexographicComparator(String... fieldNames) {
        return (x, y) -> {
            for (String fieldName : fieldNames) {
                try {
                    Field field = x.getClass().getDeclaredField(fieldName);
                    field.setAccessible(true);
                    Object valueX = field.get(x);
                    Object valueY = field.get(y);
                    if (valueX == null && valueY == null) continue;
                    if (valueX == null || valueY == null) return valueX == null ? 1 : -1;
                    int compareResult = field.get(x).toString().compareTo(field.get(y).toString());
                    if (compareResult != 0) {
                        return compareResult;
                    }
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            return 0;
        };
    }
}


