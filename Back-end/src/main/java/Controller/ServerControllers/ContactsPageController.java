package Controller.ServerControllers;


import Controller.ContactsFilter.SearchingCustomizedCriteria;
import Controller.Profile.Elements.Contacts.Contact;
import Controller.Profile.Elements.Contacts.ContactI;
import Controller.SingletonClasses.Creator;
import Controller.SingletonClasses.Database;
import Controller.SingletonClasses.Deleter;
import Controller.Sorter.ContactSorter;
import Controller.Sorter.ContactSorterI;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Arrays;

@RestController
@CrossOrigin(origins = "http://localhost:4200/home/contacts")
public class ContactsPageController {

    @PostMapping("/addContact")
    String addContact(@RequestParam(value = "username") String username, @RequestBody Contact contact){
        try {
            Database database = Database.getInstance();
            ContactI newContact = new Contact();
            newContact.setEmailAddresses(contact.getEmailAddresses());
            newContact.setUsername(contact.getUsername());
            Creator.getInstance().createContactData(database.getProfilebyUsername("", username), newContact);
            database.getProfilebyUsername("",username).getContacts().addContact(newContact);
            return "CREATED CONTACT SUCCESSFULLY";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }

    }
    @PostMapping("/getContacts")
    ArrayList<ContactI> getContacts(@RequestParam(value = "username") String username){
        try {
            Database database = Database.getInstance();
            return database.getProfilebyUsername("", username).getContacts().getContacts();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
    @PostMapping("/editContact")
    void editContact(@RequestParam(value = "username") String username,@RequestParam(value = "oldContact") ContactI oldContact, @RequestParam(value = "newContact") ContactI newContact){
        try {
            Database database = Database.getInstance();
            Deleter.getInstance().deleteContact(oldContact, database.getProfilebyUsername("", username));
            Creator.getInstance().createContactData(database.getProfilebyUsername("", username), newContact);
          //  return ;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @DeleteMapping("/removeContact")
    String removeContact(@RequestParam(value = "contactUsername") String contactUsername, @RequestParam(value = "username") String username){
        try {
            Database database = Database.getInstance();
            Deleter.getInstance().deleteContact(database.getProfilebyUsername("", username).getContacts().getContact(contactUsername), database.getProfilebyUsername("", username));
            return "DELETED CONTACT SUCCESSFULLY";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }

    }
    @GetMapping("/sortContacts")
    ArrayList<ContactI> sortContacts(@RequestParam(value = "username") String username, @RequestParam(value = "ascending") String ascending) {
        try {
            ContactSorterI sorter = new ContactSorter(Boolean.parseBoolean(ascending));
            return sorter.sort(Database.getInstance().getProfilebyUsername("", username).getContacts().getContacts());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
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
