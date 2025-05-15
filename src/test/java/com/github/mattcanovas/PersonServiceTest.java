package com.github.mattcanovas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.mattcanovas.entities.Person;
import com.github.mattcanovas.services.IPersonService;
import com.github.mattcanovas.services.PersonService;

public class PersonServiceTest {

    private static IPersonService service;
    private Person person;

    @BeforeAll
    static void setup() {
        service = new PersonService();
    }

    @BeforeEach
    void setupBeforeEach() {
        this.person = new Person(
                "Matheus",
                "Canovas",
                "Endereço X",
                "teste@teste.com",
                "Male");
    }

    @Test
    @DisplayName("When Create a Person with SUccess Should Return a Person Object")
    public void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {

        Person personCreated = service.create(person);

        assertNotNull(personCreated, () -> "The create() should not have returned null!");
    }

    @Test
    @DisplayName("When create a person with success should contains firstname in returned person object")
    public void testCreatePerson_WhenSuccess_ShouldContainsFirstNameInReturnedPersonObject() {

        Person personCreated = service.create(person);

        assertEquals(person.getFirstName(), personCreated.getFirstName(), () -> "The firstName is different");
    }

    @Test
    @DisplayName("When create a person with success should contains lastName in returned person object")
    public void testCreatePerson_WhenSuccess_ShouldContainsLastNameInReturnedPersonObject() {

        Person personCreated = service.create(person);

        assertEquals(person.getLastName(), personCreated.getLastName(), () -> "The lastName is different");
    }

    @Test
    @DisplayName("When create a person with success should contains address in returned person object")
    public void testCreatePerson_WhenSuccess_ShouldContainsAddressInReturnedPersonObject() {

        Person personCreated = service.create(person);

        assertEquals(person.getAddress(), personCreated.getAddress(), () -> "The address is different");
    }

    @Test
    @DisplayName("When create a person with success should contains email in returned person object")
    public void testCreatePerson_WhenSuccess_ShouldContainsEmailInReturnedPersonObject() {

        Person personCreated = service.create(person);

        assertEquals(person.getEmail(), personCreated.getEmail(), () -> "The email is different");
    }

    @Test
    @DisplayName("When create a person with success should contains gender in returned person object")
    public void testCreatePerson_WhenSuccess_ShouldContainsGenderInReturnedPersonObject() {

        Person personCreated = service.create(person);

        assertEquals(person.getGender(), personCreated.getGender(), () -> "The address is different");
    }

    @Test
    @DisplayName("When create a person with a email defined by value null should throw illegal argument exception.")
    public void testCreatePerson_WhenEmailIsNull_ShoudlThrowIllegalArgumentException() {
        person.setEmail(null);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.create(person);
        });
        assertInstanceOf(IllegalArgumentException.class, exception);
        assertEquals("The email should not be null.", exception.getMessage());
    }

    
}
