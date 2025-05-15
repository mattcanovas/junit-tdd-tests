package com.github.mattcanovas.services;

import java.util.concurrent.atomic.AtomicLong;

import com.github.mattcanovas.entities.Person;

public class PersonService implements IPersonService {

    @Override
    public Person create(Person person) {
        if (person.getEmail() == null || person.getEmail().length() == 0) {
            throw new IllegalArgumentException("The email should not be null.");
        }

        long id = new AtomicLong().incrementAndGet();
        person.setId(id);
        return person;
    }

}
