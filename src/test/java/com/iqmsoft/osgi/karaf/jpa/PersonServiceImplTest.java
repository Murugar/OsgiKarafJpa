package com.iqmsoft.osgi.karaf.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Test;

import com.iqmsoft.osgi.karaf.jpa.Person;
import com.iqmsoft.osgi.karaf.jpa.impl.PersonServiceImpl;


public class PersonServiceImplTest {

    @Test
    public void testWriteRead() throws Exception {
        PersonServiceImpl personService = new PersonServiceImpl();
        EntityManagerFactory emf = Persistence.
        		createEntityManagerFactory("person", System.getProperties());
        EntityManager em = emf.createEntityManager();
        personService.setEntityManager(em);
        
        em.getTransaction().begin();
        personService.deleteAll();
        personService.add(new Person("Test1", "@test1"));
        em.getTransaction().commit();

        List<Person> persons = personService.getAll();
        Assert.assertEquals(1, persons.size());
        Assert.assertEquals("Test1", persons.get(0).getName());
        Assert.assertEquals("@test1", persons.get(0).getTwitterName());
    }

}
