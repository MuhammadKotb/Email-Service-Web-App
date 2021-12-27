package Controller.EmailsFilter;

import Controller.Email.EmailI;

import java.util.ArrayList;

public class CustomedCriteria implements CriteriaI{
    private String feature;
    private String target;

    public CustomedCriteria(String feature, String target){
        this.feature = feature;
        this.target = target;
    }

    @Override
    public ArrayList<EmailI> meetCriteria(ArrayList<EmailI> emails) {
        ArrayList<EmailI> filteredEmails = null;
        switch (this.feature){
            case "subject":
                for(EmailI email:emails){
                    if((email.getSubject().toLowerCase()).contains(this.target.toLowerCase())){
                        filteredEmails.add(email);
                    }
                }
                break;
            case "body":
                for(EmailI email:emails){
                    if((email.getBody().toLowerCase()).contains(this.target.toLowerCase())){
                        filteredEmails.add(email);
                    }
                }
                break;
            case "senderUsername":
                for(EmailI email:emails){
                    if((email.getSenderUsername().toLowerCase()).contains(this.target.toLowerCase())){
                        filteredEmails.add(email);
                    }
                }
                break;
            case "receiverUsername":
                for(EmailI email:emails){
                    if((email.getreceiverUsername().toLowerCase()).contains(this.target.toLowerCase())){
                        filteredEmails.add(email);
                    }
                }
                break;
            case "timeSent":
                for(EmailI email:emails){
                    if((email.getTimeSent().toLowerCase()).contains(this.target.toLowerCase())){
                        filteredEmails.add(email);
                    }
                }
                break;
        }
        return filteredEmails;
    }
}
