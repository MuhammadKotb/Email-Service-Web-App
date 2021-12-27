package Controller.Email;

import java.util.List;

public interface EmailI {
    String subject = null;
    String body = null;
    String owner = null;
    String senderUsername = null;
    String receiverUsername = null;
    String priority = null;
    String emailID = null;
    String emailType = null;
    List<Attachment> attachments = null;

    String timeSent = null;

    String getSenderUsername();
    String getreceiverUsername();
    String getSubject();
    String getBody();
    String getEmailID();
    String getTimeSent();
    String getEmailType();
    String getOwner();
    List<Attachment> getAttachments();

    void setreceiverUsername(String receiverUsername);
    void setSenderUsername(String senderUsername);
    void setSubject(String subject);
    void setTimeSent(String timeSent);
    void setBody(String body);
    void setEmailID(String emailID);
    void setEmailType(String emailType);
    void setOwner(String owner);
    void setAttachments(List<Attachment> attachments);

    void addAttachment(Attachment attachment);
    void removeAttachment(Attachment attachment);





}
