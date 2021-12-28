package Controller.ContactsFilter;

import Controller.Profile.Elements.Contacts.ContactI;

import java.util.ArrayList;

public class SearchingCustomizedCriteria implements CriteriaI {
    private String target;

    public SearchingCustomizedCriteria(String target){
        this.target = target;
    }

    @Override
    public ArrayList<ContactI> meetCriteria(ArrayList<ContactI> contacts) {
        ArrayList<ContactI> filteredContacts = null;
        for(ContactI contact:contacts){
            if((contact.getUsername().toLowerCase()).concat(contact.getEmailAddresses().toString().toLowerCase()
                    ).contains(this.target.toLowerCase())){
                filteredContacts.add(contact);
            }
        }

        return filteredContacts;
    }
}
