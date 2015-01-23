package com.tasks.capitel4;

import com.tasks.Exercise;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Consider a class with many JavaFX properties, most of which are never
 * changed from a default. Show how the property can be set up on demand,
 * when it is set to a non default value or when the xxxProperty() method is called
 * for the first time.
 */
public class C4E3 implements Exercise {

    @Override
    @Test
    public void perform() {
        Name john = new Name();
        assertNull(john.firstName);
        assertNull(john.lastName);
        john.setFirstName("John");
        assertNull(john.firstName);
        john.setLastName("Black");
        assertNull(john.lastName);
        john.setFirstName("Johan");
        assertNotNull(john.firstName);
        john.setLastName("White");
        assertNotNull(john.lastName);
        Name doug = new Name("Doug", "Green");
        assertNotNull(doug.firstName);
        assertNotNull(doug.lastName);
    }

    class Name {

        public static final String FIRST_NAME_DEFAULT = "John";
        public static final String LAST_NAME_DEFAULT = "Black";

        private String firstNameValue = FIRST_NAME_DEFAULT;
        private String lastNameValue = LAST_NAME_DEFAULT;

        StringProperty firstName;
        StringProperty lastName;

        Name() {
        }

        Name(String firstNameValue, String lastNameValue) {
            if (!firstNameValue.equalsIgnoreCase(FIRST_NAME_DEFAULT)) {
                this.firstName = new SimpleStringProperty(firstNameValue);
            } else {
                this.firstNameValue = firstNameValue;
            }
            if (!lastNameValue.equalsIgnoreCase(LAST_NAME_DEFAULT)) {
                this.lastName = new SimpleStringProperty(lastNameValue);
            } else {
                this.lastNameValue = lastNameValue;
            }
        }

        public final StringProperty firstNameProperty() {
            if (firstName == null) {
                firstName = new SimpleStringProperty(firstNameValue);
            }
            return firstName;
        }

        public final void setFirstName(String newValue) {
            if (firstName != null) {
                firstName.setValue(newValue);
            } else {
                if (!newValue.equalsIgnoreCase(FIRST_NAME_DEFAULT)) {
                    this.firstName = new SimpleStringProperty(newValue);
                } else {
                    this.firstNameValue = newValue;
                }
            }
        }

        public final String getFirstName() {
            return firstName != null ? firstName.getValue() : firstNameValue;
        }

        public final StringProperty lastNameProperty() {
            if (lastName == null) {
                lastName = new SimpleStringProperty(lastNameValue);
            }
            return lastName;
        }

        public final void setLastName(String newValue) {
            if (lastName != null) {
                lastName.setValue(newValue);
            } else {
                if (!newValue.equalsIgnoreCase(LAST_NAME_DEFAULT)) {
                    this.lastName = new SimpleStringProperty(newValue);
                } else {
                    this.lastNameValue = newValue;
                }
            }
        }

        public final String getLastName() {
            return lastName != null ? lastName.getValue() : lastNameValue;
        }
    }


}
