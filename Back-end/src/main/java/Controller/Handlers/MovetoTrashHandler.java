package Controller.Handlers;

import Controller.Email.EmailI;
import Controller.Profile.ProfileI;
import Controller.SingletonClasses.Creator;
import Controller.SingletonClasses.Database;
import Controller.SingletonClasses.Deleter;

import java.util.UUID;

public class MovetoTrashHandler implements HandlerI{
    private String concern = "MovetoTrash";
    private HandlerI successor = null;
    private static MovetoTrashHandler instance = null;

    private MovetoTrashHandler(){}
    public static MovetoTrashHandler getInstance(){
        if(instance == null){
            return new MovetoTrashHandler();
        }else {
            return instance;
        }

    }
    @Override
    public void handle(String concern, EmailI email) throws Exception {
        if(concern == this.concern){
            Database database = Database.getInstance();
            if(database.getProfilebyUsername("", email.getOwner()) == null){
                throw new Exception("THERE IS NO SENDER BY THIS USERNAME");
            }
            System.out.println("INSIDE MOVE TO TRASH");

            ProfileI owner = database.getProfilebyUsername("", email.getOwner());
            System.out.println("INSIDE MOVE TO TRASH AFTER PROFILE GET");

            if(email.getEmailType().equals("Inbox")){
                System.out.println("INSIDE INBOX MOVE TO TRASH");
                Creator.getInstance().createEmailDataTrash(email, owner, email.getEmailID());
                Deleter.getInstance().deleteEmailDataInbox(email, owner);
                owner.getInbox().removeEmailbyID(email.getEmailID());
                owner.getTrash().addEmail(email);
            }
            if(email.getEmailType().equals("Outbox")){
                Creator.getInstance().createEmailDataTrash(email, owner, email.getEmailID());
                Deleter.getInstance().deleteEmailDataOutbox(email, owner);
                owner.getOutbox().removeEmailbyID(email.getEmailID());
                owner.getTrash().addEmail(email);

            }
            if(email.getEmailType().equals("Draft")){
                Creator.getInstance().createEmailDataTrash(email, owner, email.getEmailID());
                Deleter.getInstance().deleteEmailDataDraft(email, owner);
                owner.getDraft().removeEmailbyID(email.getEmailID());
                owner.getTrash().addEmail(email);

            }
        }else{
            if(this.successor == null){
                throw new Exception("NO HANDLER CAN HANDLE THIS CONCERN");
            }
            this.successor.handle(concern,email);
        }

    }
}
