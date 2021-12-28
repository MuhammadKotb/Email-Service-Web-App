package Controller.Email;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

public class Email implements EmailI {

    private String subject;
    private String body;

    private String owner;
    private String senderUsername;
    private String receiverUsername;
    private String priority;


    private String timeSent;
    private String timeSentString;

    @Override
    public String getTimeSentString() {
        return timeSentString;
    }

    @Override
    public void setTimeSentString(String timeSentString) {
        this.timeSentString = timeSentString;
    }

    private String emailID;

    private String emailType;
    List<Attachment> attachments = null;

    public String getReceiverUsername() {
        return receiverUsername;
    }

    public void setReceiverUsername(String receiverUsername) {
        this.receiverUsername = receiverUsername;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Email(){}
    public Email(String subject, String body, String senderUsername, String receiverUsername, String emailType, List<Attachment> attachments){
        this.senderUsername = senderUsername;
        this.receiverUsername = receiverUsername;
        this.subject = subject;
        this.body = body;
        this.timeSent = String.valueOf(new Date().getTime());
        this.timeSentString = SimpleDateFormat.getDateTimeInstance().format(new Date());
        this.emailType = emailType;
        this.attachments = attachments;
    }
    @Override
    public String getSenderUsername() {
        return this.senderUsername;
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
    public List<Attachment> getAttachments() {
        return this.attachments;
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

    @Override
    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    @Override
    public void addAttachment(Attachment attachment) {
        this.attachments.add(attachment);
    }

    @Override
    public void removeAttachment(Attachment attachment) {
        this.attachments.remove(attachment);
    }


}
