
package com.iqmsoft.osgi.karaf.jpa.command;

import org.apache.felix.gogo.commands.Action;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.service.command.CommandSession;

import com.iqmsoft.osgi.karaf.jpa.PersonService;

@Command(scope = "person", name = "deleteAll", description = "Delete all persons")
public class DeleteAllPersonsCommand implements Action {
    private PersonService personService;
    
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public Object execute(CommandSession session) throws Exception {
        personService.deleteAll();
        return null;
    }

}
