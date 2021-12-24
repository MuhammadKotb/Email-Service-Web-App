package Model;

import java.util.ArrayList;

public interface ProfileContactsI {

    ArrayList<ContactI> contacts = null;

    ArrayList<ContactI> getContacts();

    void addContact(ContactI contact);

    void removeContact(String username);

    ContactI getContact(String username);




}
