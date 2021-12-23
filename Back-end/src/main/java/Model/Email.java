package Model;

import java.time.LocalTime;

public class Email implements EmailI{

    private String subject;
    private String body;

    private String owner;
    private String senderUsername;
    private String recieverUsername;


    private String timeSent;
    private String emailID;

    private String emailType;


    public Email(){}
    public Email(String subject, String body, String senderUsername, String recieverUsername, String emailType){
        this.senderUsername = senderUsername;
        this.recieverUsername = recieverUsername;
        this.subject = subject;
        this.body = body;
        this.timeSent = LocalTime.now().toString();
        this.emailType = emailType;
    }
    @Override
    public String getSenderUsername() {
        return this.senderUsername;
    }

    @Override
    public String getRecieverUsername() {
        return this.recieverUsername;
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
    public String getEmailID() {
        return this.emailID;
    }

    @Override
    public String getTimeSent() {
        return this.timeSent;
    }

    @Override
    public String getEmailType() {
        return this.emailType;
    }

    @Override
    public String getOwner() {
        return this.owner;
    }

    @Override
    public void setRecieverUsername(String recieverUsername) {
        this.recieverUsername = recieverUsername;
    }

    @Override
    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }

    @Override
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void setTimeSent(String timeSent) {
        this.timeSent = timeSent;
    }

    @Override
    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    @Override
    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    @Override
    public void setOwner(String owner) {
        this.owner = owner;
    }


}
