
package com.iqmsoft.osgi.karaf.jpa.command;

import org.apache.felix.gogo.commands.Action;
import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.service.command.CommandSession;

import com.iqmsoft.osgi.karaf.jpa.Person;
import com.iqmsoft.osgi.karaf.jpa.PersonService;

@Command(scope = "person", name = "add", description = "Adds a person")
public class AddPersonCommand implements Action {
    @Argument(index=0, name="Name", required=true, description="Name", multiValued=false)
    String name;
    @Argument(index=1, name="Twitter Name", required=true, description="Twitter Name", multiValued=false)
    String twitterName;
    private PersonService personService;
    
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public Object execute(CommandSession session) throws Exception {
        Person person = new Person(name, twitterName);
        personService.add(person);
        return null;
    }

}
