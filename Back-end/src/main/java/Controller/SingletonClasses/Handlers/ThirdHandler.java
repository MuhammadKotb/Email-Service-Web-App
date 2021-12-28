package Controller.SingletonClasses.Handlers;

import Controller.Profile.Elements.Email.EmailI;
import Controller.Profile.ProfileI;
import Controller.SingletonClasses.Creator;
import Controller.SingletonClasses.Database;



public class ThirdHandler implements HandlerI {

    private final String concern = "MovetoDraft";
    private HandlerI successor = null;
    private static ThirdHandler instance = null;

    private ThirdHandler(){}
    public static ThirdHandler getInstance(){
        if(instance == null){
            return new ThirdHandler();
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

            ProfileI owner = database.getProfilebyUsername("", email.getOwner());
            Creator.getInstance().createEmailDataDraft(email, owner, email.getEmailID());
            owner.getDraft().addEmail(email);


        }else{
            if(this.successor == null){
                throw new Exception("NO HANDLER CAN HANDLE THIS CONCERN");
            }
            this.successor.handle(concern,email);
        }
    }
}
