package Controller.Profile.Elements;

import Controller.DataContainerI;
import Controller.Email.EmailI;

import java.util.ArrayList;

public interface ProfileSentI {
    DataContainerI SentDataContainer = null;

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


    DataContainerI getSentDataContainer();
    void setSentDataContainer(DataContainerI SentDataContainer);


}