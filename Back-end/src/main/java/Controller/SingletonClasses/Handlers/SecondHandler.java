package Controller.SingletonClasses.Handlers;

import Controller.Email.EmailI;
import Controller.Profile.ProfileI;
import Controller.SingletonClasses.Creator;
import Controller.SingletonClasses.Database;
import Controller.SingletonClasses.Deleter;

public class SecondHandler implements HandlerI{
    private final String concern = "MovetoTrash";
    private HandlerI successor = ThirdHandler.getInstance();
    private static SecondHandler instance = null;

    private SecondHandler(){}
    public static SecondHandler getInstance(){
        if(instance == null){
            return new SecondHandler();
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
            if(email.getEmailType().equals("Sent")){
                Creator.getInstance().createEmailDataTrash(email, owner, email.getEmailID());
                Deleter.getInstance().deleteEmailDataSent(email, owner);
                owner.getSent().removeEmailbyID(email.getEmailID());
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
