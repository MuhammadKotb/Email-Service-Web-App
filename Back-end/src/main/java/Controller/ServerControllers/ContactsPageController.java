package Controller.ServerControllers;

import Controller.ContactsFilter.SearchingCustomizedCriteria;
import Controller.Profile.Elements.Contacts.ContactI;
import Controller.SingletonClasses.Database;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:4200/home/contacts")
public class ContactsPageController {

    @PostMapping("/addContact")
    void addContact(@RequestParam(value = "contact") ContactI contact, @RequestParam(value = "username") String username){
        try {
            Database database = Database.getInstance();
            database.getProfilebyUsername("",username).getContacts().addContact(contact);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    @PostMapping("/getContacts")
    ArrayList<ContactI> getContacts(@RequestParam(value = "username") String username){
        try {
            Database database = Database.getInstance();
            return database.getProfilebyUsername("",username).getContacts().getContacts();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
    @PostMapping("/editContact")
    ContactI editContact(@RequestParam(value = "username") String username,@RequestParam(value = "oldContact") ContactI oldContact
            ,@RequestParam(value = "editedAttribute") String editedAttribute,@RequestParam(value = "newContact") ContactI newContact){
        try {
            Database database = Database.getInstance();
            ContactI contact = database.getProfilebyUsername("",username).getContacts().getContact(oldContact.getUsername());
            if(editedAttribute.equalsIgnoreCase("username")){
                contact.setUsername(newContact.getUsername());
            }else if(editedAttribute.equalsIgnoreCase("emailAddresses")){
                contact.setEmailAddresses(newContact.getEmailAddresses());
            }
            return contact;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
    @DeleteMapping ("/removeContact")
    void removeContact(@RequestParam(value = "contact") ContactI contact,@RequestParam(value = "username") String username){
        try {
            Database database = Database.getInstance();
            database.getProfilebyUsername("",username).getContacts().removeContact(contact.getUsername());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    @PostMapping("/searchContacts")
    ArrayList<ContactI> searchContacts(@RequestParam(value = "username") String username,@RequestParam(value = "target") String target){
        try {
            Database database = Database.getInstance();
            SearchingCustomizedCriteria search = new SearchingCustomizedCriteria(target);
            return search.meetCriteria(database.getProfilebyUsername("",username).getContacts().getContacts());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}
