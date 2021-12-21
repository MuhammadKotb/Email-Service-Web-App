package Model;


import java.io.File;

public class Creator {

    private static Creator instance;

    private Creator() {}
    public static Creator getInstance(){
        if(instance == null){
            instance = new Creator();
            System.out.println("CREATED CREATOR");
        }
        return instance;
    }

    public Folder createFolder(String folderPath, String folderName) throws Exception{
        Folder folder = new Folder();
        folder.newFolder(folderPath, folderName);
        System.out.println("CREATED FOLDER");
        return folder;
    }

    public void createFolderData(Folder folder){
        try{
            folder.setInboxFolder(new Folder(folder.getFolderPath().concat("/Inbox"), "Inbox", new File(folder.getFolderPath().concat("/Inbox"))));
            folder.getInboxFolder().newFolder(folder.getFolderPath().concat("/Inbox"), "Inbox");
            folder.setTrashFolder(new Folder(folder.getFolderPath().concat("/Trash"), "Trash", new File(folder.getFolderPath().concat("/Trash"))));
            folder.getTrashFolder().newFolder(folder.getFolderPath().concat("/Trash"), "Trash");
            folder.setSpamFolder(new Folder(folder.getFolderPath().concat("/Spam"), "Trash", new File(folder.getFolderPath().concat("/Spam"))));
            folder.getSpamFolder().newFolder(folder.getFolderPath().concat("/Spam"), "Spam");
            folder.setOutboxFolder(new Folder(folder.getFolderPath().concat("/Outbox"), "Outbox", new File(folder.getFolderPath().concat("/Spam"))));
            folder.getOutboxFolder().newFolder(folder.getFolderPath().concat("/Outbox"), "Outbox");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }



}
