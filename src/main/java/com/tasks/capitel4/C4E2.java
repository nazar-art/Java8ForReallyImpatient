package com.tasks.capitel4;

import com.tasks.Exercise;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Consider a class with many JavaFX properties, such as a chart or table.
 * Chances are that in a particular application, most properties never have listeners
 * attached to them. It is therefore wasteful to have a property object per
 * property. Show how the property can be set up on demand, first using a
 * regular field for storing the property value, and then using a property object
 * only when the xxxProperty() method is called for the first time.
 */
public class C4E2 implements Exercise {

    @Override
    @Test
    public void perform() {
        Name john = new Name("John", "White");
        assertNull(john.firstName);
        assertNull(john.lastName);
        john.setLastName("Black");
        assertNull(john.lastName);
        Name doug = new Name("Doug", "Green");
        doug.setLastName("Blue");
        assertNull(doug.lastName);
        john.lastNameProperty().bind(doug.lastNameProperty());
        assertNotNull(john.lastName);
        assertNotNull(doug.lastName);
        doug.setLastName("Red");
        assertEquals("Red", john.getLastName());
    }

    class Name {

        private String firstNameValue;
        private String lastNameValue;

        StringProperty firstName;
        StringProperty lastName;

        Name(String firstNameValue, String lastNameValue) {
            this.firstNameValue = firstNameValue;
            this.lastNameValue = lastNameValue;
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
                firstNameValue = newValue;
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
                lastNameValue = newValue;
            }
        }

        public final String getLastName() {
            return lastName != null ? lastName.getValue() : lastNameValue;
        }
    }
}
