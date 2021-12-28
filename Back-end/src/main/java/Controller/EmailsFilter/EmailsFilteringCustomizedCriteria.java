package Controller.EmailsFilter;

import Controller.Profile.Elements.Email.EmailI;

import java.util.ArrayList;

public class EmailsFilteringCustomizedCriteria implements CriteriaI{
    private String feature;
    private String target;

    public EmailsFilteringCustomizedCriteria(String feature, String target){
        this.feature = feature;
        this.target = target;
    }

    public String getFeature() {
        return feature;
    }

    public String getTarget() {
        return target;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public void setTarget(String target) {
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
            case "senderUsername":
                for(EmailI email:emails){
                    if((email.getSenderUsername().toLowerCase()).contains(this.target.toLowerCase())){
                        filteredEmails.add(email);
                    }
                }
                break;
            case "receiverUsername":
                for(EmailI email:emails){
                    if((email.getReceiversUsernames().get(0).toLowerCase()).contains(this.target.toLowerCase())){
                        filteredEmails.add(email);
                    }
                }
                break;
            case "timeSent":
                for(EmailI email:emails){
                    if((email.getTimeSentString().toLowerCase()).contains(this.target.toLowerCase())){
                        filteredEmails.add(email);
                    }
                }
                break;
        }
        return filteredEmails;
    }
}
