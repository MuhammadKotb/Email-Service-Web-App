package Model.Profile.Elements;

import Model.DataContainerI;
import Model.Email.EmailI;

import java.util.ArrayList;

public interface ProfileInboxI {
    DataContainerI inboxDataContainer = null;

    ArrayList<EmailI> emails = null;

    ArrayList<EmailI> getEmails();

    void addEmail(EmailI email);
    void removeEmail(EmailI email);
    void removeEmailbyID(String ID);

    EmailI getEmailbySubject(String subject);
    EmailI getEmailbyBody(String body);
    EmailI getEmailbySenderUsername(String username);
    EmailI getEmailbyreceiverUsername(String username);
    EmailI getEmailbyID(String ID);


    DataContainerI getInboxDataContainer();
    void setInboxDataContainer(DataContainerI inboxDataContainer);


}
