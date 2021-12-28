package Controller.Email;

import java.text.DateFormat;
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

    DateFormat timeSent = null;
    String timeSentString = null;

    String getSenderUsername();
    String getReceiverUsername();
    String getSubject();
    String getBody();
    String getEmailID();
    String getTimeSent();
    String getTimeSentString();
    String getEmailType();
    String getOwner();
    String getPriority();
    List<Attachment> getAttachments();


    void setSenderUsername(String senderUsername);
    void setReceiverUsername(String receiverUsername);
    void setSubject(String subject);
    void setTimeSent(String timeSent);
    void setTimeSentString(String timeSentString);
    void setBody(String body);
    void setEmailID(String emailID);
    void setEmailType(String emailType);
    void setOwner(String owner);
    void setPriority(String priority);
    void setAttachments(List<Attachment> attachments);


    void addAttachment(Attachment attachment);
    void removeAttachment(Attachment attachment);





}
