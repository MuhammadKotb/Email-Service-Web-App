package Model;

public class Deleter {
    private static Deleter instance;
    private Deleter(){}

    public static Deleter getInstance(){
        if(instance == null){
            instance = new Deleter();
        }
        System.out.println("CREATED DELETER");
        return instance;
    }
    private final String databaePath = "src/main/java/Model/Database/";


    public void deleteFolder(Folder folder){
        try{
            folder.getOutboxFolder().getFile().delete();
            folder.getTrashFolder().getFile().delete();
            folder.getInboxFolder().getFile().delete();
            folder.getSpamFolder().getFile().delete();
            folder.getFile().delete();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

}
