package Controller.ServerControllers;

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
            Database.getInstance().getProfilebyUsername("",username).getContacts().addContact(contact);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    @PostMapping("/getContacts")
    ArrayList<ContactI> getContacts(@RequestParam(value = "username") String username){
        try {
            return Database.getInstance().getProfilebyUsername("",username).getContacts().getContacts();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
    @DeleteMapping("/removeContact")
    void removeContact(@RequestParam(value = "contact") ContactI contact,@RequestParam(value = "username") String username){
        try {
            Database.getInstance().getProfilebyUsername("",username).getContacts().removeContact(contact.getUsername());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
