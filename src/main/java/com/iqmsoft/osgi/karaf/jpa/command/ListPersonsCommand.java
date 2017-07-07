package com.iqmsoft.osgi.karaf.jpa.command;

import java.util.List;

import org.apache.felix.gogo.commands.Action;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.service.command.CommandSession;

import com.iqmsoft.osgi.karaf.jpa.Person;
import com.iqmsoft.osgi.karaf.jpa.PersonService;

@Command(scope = "person", name = "list", description = "Lists all persons")
public class ListPersonsCommand implements Action {
    private PersonService personService;
    
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public Object execute(CommandSession session) throws Exception {
        List<Person> persons = personService.getAll();
        for (Person person : persons) {
            System.out.println(person.getName() + ", " + person.getTwitterName());
        }
        return null;
    }

}
