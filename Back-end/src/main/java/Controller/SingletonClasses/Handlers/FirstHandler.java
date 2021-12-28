package Controller.SingletonClasses.Handlers;

import Controller.Email.EmailI;
import Controller.Profile.ProfileI;
import Controller.SingletonClasses.Creator;
import Controller.SingletonClasses.Database;

import java.util.UUID;

public class FirstHandler implements HandlerI{
    private final String concern = "SendEmail";
    private HandlerI successor = SecondHandler.getInstance();
    private static FirstHandler instance = null;

    private FirstHandler(){}
    public static FirstHandler getInstance(){
        if(instance == null){
            return new FirstHandler();
        }else {
            return instance;
        }

    }

    public void handle(String concern, EmailI email)throws Exception{
        if(concern == this.concern){
            Database database = Database.getInstance();
            if(database.getProfilebyUsername("", email.getSenderUsername()) == null){
                throw new Exception("THERE IS NO SENDER BY THIS USERNAME");
            }

            if(database.getProfilebyUsername("", email.getReceiversUsernames().get(0)) == null){
                throw new Exception("THERE IS NO RECIEVER BY THIS USERNAME");
            }
            ProfileI sender = database.getProfilebyUsername("", email.getSenderUsername());
            ProfileI reciever = database.getProfilebyUsername("", email.getReceiversUsernames().get(0));
            Creator creator = Creator.getInstance();
            String senderID = UUID.randomUUID().toString();
            String recieverID = UUID.randomUUID().toString();
            reciever.getInbox().addEmail(creator.createEmailDataInbox(email, reciever, senderID));
            sender.getSent().addEmail(creator.createEmailDataSent(email, sender, recieverID));
        }else{
            if(this.successor == null){
                throw new Exception("NO HANDLER CAN HANDLE THIS CONCERN");
            }
            this.successor.handle(concern,email);
        }
    }

}
