package Controller.ServerControllers;

import Controller.Profile.Elements.Contacts.ContactI;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/home/contacts")
public class ContactsPageController {
    @PostMapping("addContact")
    void addContact(@RequestBody ContactI contactI){

    }
}
