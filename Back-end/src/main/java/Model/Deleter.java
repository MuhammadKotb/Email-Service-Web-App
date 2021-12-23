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
        try{
            deleteDataContainer(profile.getDataContainer());
        }
        catch (Exception e){
            throw e;
        }
    }

}
