package Model;

import java.time.LocalTime;

public interface EmailI {
    String subject = null;
    String body = null;
    ProfileI sender = null;
    ProfileI reciever = null;

    LocalTime timeSent = null;

    ProfileI getSender();
    ProfileI getReciever();
    String getSubject();
    String getBody();
    LocalTime getTimeSent();

    void setReciever(ProfileI reciever);
    void setSender(ProfileI sender);
    void setSubject(String subject);
    void setTimeSent(LocalTime timeSent);
    void setBody(String body);




}
