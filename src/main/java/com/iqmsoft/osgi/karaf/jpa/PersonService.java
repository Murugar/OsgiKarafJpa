package com.iqmsoft.osgi.karaf.jpa;

import java.util.List;

public interface PersonService {
    void add(Person person);
    void deleteAll();
    List<Person> getAll();
}
