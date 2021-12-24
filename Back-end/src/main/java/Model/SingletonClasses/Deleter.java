package Model.SingletonClasses;

import Model.DataContainerI;
import Model.Email.EmailI;
import Model.Profile.ProfileI;

import java.io.File;

public class Deleter {
    private static Deleter instance;
    private Deleter(){}

    public static Deleter getInstance(){
        if(instance == null){
            instance = new Deleter();
            System.out.println("CREATED DELETER");
        }

        return instance;
    }


    private static void deleteDataContainer(DataContainerI dataContainer) throws Exception{
        boolean deletedFile = dataContainer.getFile().delete();
        if(!deletedFile){
            throw new Exception("COULD NOT DELETE DATACONTAINER");
        }
    }

    public void deleteProfile(ProfileI profile) throws Exception{
        deleteDataContainer(profile.getTrash().getTrashDataContainer());
        deleteDataContainer(profile.getDraft().getDraftDataContainer());
        deleteDataContainer(profile.getInbox().getInboxDataContainer());
        deleteDataContainer(profile.getOutbox().getOutboxDataContainer());
        deleteDataContainer(profile.getDataContainer());

    }

    public void deleteEmailDataInbox(EmailI email, ProfileI profile) throws Exception{
        if(profile.getInbox().getEmailbyID(email.getEmailID()) == null){
            throw new Exception("NO SUCH EMAIL TO DELETE");
        }
        File file = new File(profile.getInbox().getInboxDataContainer().getDataContainerPath().concat("/").concat(email.getEmailID()).concat(".json"));
        if(!file.delete()){
            throw new Exception("COULD NOT DELETE EMAIL");
        }

    }
    public void deleteEmailDataOutbox(EmailI email, ProfileI profile) throws Exception{
        if(profile.getOutbox().getEmailbyID(email.getEmailID()) == null){
            throw new Exception("NO SUCH EMAIL TO DELETE");
        }
        File file = new File(profile.getOutbox().getOutboxDataContainer().getDataContainerPath().concat("/").concat(email.getEmailID()).concat(".json"));
        if(!file.delete()){
            throw new Exception("COULD NOT DELETE EMAIL");
        }

    }
    public void deleteEmailDataDraft(EmailI email, ProfileI profile) throws Exception{
        if(profile.getDraft().getEmailbyID(email.getEmailID()) == null){
            throw new Exception("NO SUCH EMAIL TO DELETE");
        }
        File file = new File(profile.getDraft().getDraftDataContainer().getDataContainerPath().concat("/").concat(email.getEmailID()).concat(".json"));
        if(!file.delete()){
            throw new Exception("COULD NOT DELETE EMAIL");
        }

    }
    public void deleteEmailDataTrash(EmailI email, ProfileI profile) throws Exception{
        if(profile.getTrash().getEmailbyID(email.getEmailID()) == null){
            throw new Exception("NO SUCH EMAIL TO DELETE");
        }
        File file = new File(profile.getTrash().getTrashDataContainer().getDataContainerPath().concat(email.getEmailID()).concat(".json"));
        if(!file.delete()){
            throw new Exception("COULD NOT DELETE EMAIL");
        }

    }

}
