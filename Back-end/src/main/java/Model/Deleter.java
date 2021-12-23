package Model;

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
        deleteDataContainer(profile.getSpam().getSpamDataContainer());
        deleteDataContainer(profile.getDraft().getDraftDataContainer());
        deleteDataContainer(profile.getInbox().getInboxDataContainer());
        deleteDataContainer(profile.getOutbox().getOutboxDataContainer());
        deleteDataContainer(profile.getDataContainer());

    }

}
