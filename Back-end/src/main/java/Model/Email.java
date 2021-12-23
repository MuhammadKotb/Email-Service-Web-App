package Model;

import java.time.LocalTime;

public class Email implements EmailI{

    String subject;
    String body;

    ProfileI sender;
    ProfileI reciever;

    LocalTime timeSent;

    public Email(){
        this.timeSent = LocalTime.now();
    }
    @Override
    public ProfileI getSender() {
        return this.sender;
    }

    @Override
    public ProfileI getReciever() {
        return this.reciever;
    }

    @Override
    public String getSubject() {
        return this.subject;
    }

    @Override
    public String getBody() {
        return this.body;
    }

    @Override
    public LocalTime getTimeSent() {
        return this.timeSent;
    }

    @Override
    public void setReciever(ProfileI reciever) {
        this.reciever = reciever;
    }

    @Override
    public void setSender(ProfileI sender) {
        this.sender = sender;
    }

    @Override
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void setTimeSent(LocalTime timeSent) {
        this.timeSent = timeSent;
    }

    @Override
    public void setBody(String body) {
        this.body = body;
    }
}
