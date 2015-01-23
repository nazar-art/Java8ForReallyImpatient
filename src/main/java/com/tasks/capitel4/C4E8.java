package com.tasks.capitel4;

import com.tasks.Exercise;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

/**
 * Since there is no JavaFX-specific knowledge in parsing FXML files, come up
 * with an example where you load an object that has nothing to do with JavaFX,
 * with some nested objects, and set the properties in FXML syntax. Extra
 * credit if you use injection.
 */
public class C4E8 implements Exercise, Initializable {

    @FXML
    private Name name;
    @FXML
    private Address address;

    @Test
    @Override
    public void perform() {
        try {
            FXMLLoader.load(getClass().getResource("/fxml/person.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assertNotNull(name);
        assertNotNull(address);
        assertEquals("John", name.getFirstname());
        assertEquals("Black", name.getLastname());
        assertEquals("Mainstr", address.getStreet());
        assertEquals("Maintown", address.getCity());
        assertEquals("12345", address.getPostalCode());
    }
}

