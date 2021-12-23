package Model;

import java.util.ArrayList;

public interface ProfileOutboxI {
    DataContainerI outboxDataContainer = null;

    ArrayList<EmailI> emails = null;

    ArrayList<EmailI> getEmails();

    void addEmail(EmailI email);
    void removeEmail(EmailI email);
    void removeEmailbyID(String ID);

    EmailI getEmailbySubject(String subject);
    EmailI getEmailbyBody(String body);
    EmailI getEmailbySenderUsername(String username);
    EmailI getEmailbyRecieverUsername(String username);
    EmailI getEmailbyID(String ID);


    DataContainerI getOutboxDataContainer();
    void setOutboxDataContainer(DataContainerI outboxDataContainer);


}
