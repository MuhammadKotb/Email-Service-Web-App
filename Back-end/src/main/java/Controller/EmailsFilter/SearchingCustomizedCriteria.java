package Controller.EmailsFilter;

import Controller.Email.EmailI;

import java.util.ArrayList;

public class SearchingCustomizedCriteria implements CriteriaI{
    private String target;

    public SearchingCustomizedCriteria(String target){
        this.target = target;
    }

    @Override
    public ArrayList<EmailI> meetCriteria(ArrayList<EmailI> emails) {
        ArrayList<EmailI> filteredEmails = null;
        for(EmailI email:emails){
            if((email.getBody().toLowerCase()).concat(email.getSubject().toLowerCase()
            .concat(email.getSenderUsername().toLowerCase().concat(email.getreceiverUsername().toLowerCase()
            .concat(email.getTimeSent().toLowerCase())))).contains(this.target.toLowerCase())){
                filteredEmails.add(email);
            }
        }

        return filteredEmails;
    }
}
