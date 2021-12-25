package Controller.SingletonClasses.Handlers;

import Controller.Email.EmailI;
import Controller.Profile.ProfileI;
import Controller.SingletonClasses.Creator;
import Controller.SingletonClasses.Database;

import java.util.UUID;

public class SendEmailHandler implements HandlerI{
    private String concern = "SendEmail";
    private HandlerI successor = MovetoTrashHandler.getInstance();
    private static SendEmailHandler instance = null;

    private SendEmailHandler(){}
    public static SendEmailHandler getInstance(){
        if(instance == null){
            return new SendEmailHandler();
        }else {
            return instance;
        }

    }
    @Override
    public void handle(String concern, EmailI email) throws Exception {
        if(concern == this.concern){
            Database database = Database.getInstance();
            if(database.getProfilebyUsername("", email.getSenderUsername()) == null){
                throw new Exception("THERE IS NO SENDER BY THIS USERNAME");
            }
            if(database.getProfilebyUsername("", email.getreceiverUsername()) == null){
                throw new Exception("THERE IS NO RECIEVER BY THIS USERNAME");
            }
            ProfileI sender = database.getProfilebyUsername("", email.getSenderUsername());
            ProfileI reciever = database.getProfilebyUsername("", email.getreceiverUsername());
            Creator creator = Creator.getInstance();
            String senderID = UUID.randomUUID().toString();
            String recieverID = UUID.randomUUID().toString();
            reciever.getInbox().addEmail(creator.createEmailDataInbox(email, reciever, senderID));
            sender.getOutbox().addEmail(creator.createEmailDataOutbox(email, sender, recieverID));
        }else{
            if(this.successor == null){
                throw new Exception("NO HANDLER CAN HANDLE THIS CONCERN");
            }
            this.successor.handle(concern,email);
        }

    }
}
