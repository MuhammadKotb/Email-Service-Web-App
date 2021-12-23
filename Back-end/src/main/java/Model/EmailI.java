package Model;

import java.time.LocalTime;

public interface EmailI {
    String subject = null;
    String body = null;
    String owner = null;
    String senderUsername = null;
    String recieverUsername = null;
    String emailID = null;
    String emailType = null;

    String timeSent = null;

    String getSenderUsername();
    String getRecieverUsername();
    String getSubject();
    String getBody();
    String getEmailID();
    String getTimeSent();
    String getEmailType();
    String getOwner();

    void setRecieverUsername(String recieverUsername);
    void setSenderUsername(String senderUsername);
    void setSubject(String subject);
    void setTimeSent(String timeSent);
    void setBody(String body);
    void setEmailID(String emailID);
    void setEmailType(String emailType);
    void setOwner(String owner);




}
