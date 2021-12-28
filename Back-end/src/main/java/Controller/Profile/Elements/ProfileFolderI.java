package Controller.Profile.Elements;

import Controller.DataContainer;
import Controller.DataContainerI;
import Controller.Email.EmailI;

import java.util.ArrayList;

public interface ProfileFolderI {
    String name = null;
    DataContainerI folderDataContainer = null;
    ArrayList<EmailI> email = null;

    ArrayList<EmailI> getEmails();

    void addEmail(EmailI email);
    void removeEmail(EmailI email);
    void removeEmailbyID(String ID);


    String getName();
    void setName(String name);

    EmailI getEmailbySubject(String subject);
    EmailI getEmailbyBody(String body);
    EmailI getEmailbySenderUsername(String username);
    EmailI getEmailbyreceiverUsername(String username);
    EmailI getEmailbyID(String ID);


    DataContainerI getFolderDataContainer();
    void setFolderDataContainer(DataContainerI folderDataContainer);



}
