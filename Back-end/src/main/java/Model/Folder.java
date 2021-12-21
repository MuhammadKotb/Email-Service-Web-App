package Model;

import java.io.File;
import java.util.ArrayList;
import java.util.IllegalFormatException;

public class Folder {
    private String folderPath;
    private String folderName;
    private Folder trashFolder;
    private Folder spamFolder;
    private Folder inboxFolder;
    private Folder outboxFolder;
    private ArrayList<File> dataFiles;
    File file;




    public Folder(){}
    public Folder(String folderPath, String folderName,Folder trashFolder,Folder inboxFolder,Folder spamFolder,Folder outboxFolder, File file) {
        this.folderPath = folderPath;
        this.folderName = folderName;
        this.trashFolder = trashFolder;
        this.spamFolder = spamFolder;
        this.inboxFolder = inboxFolder;
        this.outboxFolder = outboxFolder;
        this.file = file;
    }
    public Folder(String folderPath, String folderName, File file) {
        this.folderPath = folderPath;
        this.folderName = folderName;
        this.file = file;
    }

    public void newFolder(String folderPath, String folderName) throws Exception {

        file = new File(folderPath);
        boolean created = file.mkdirs();
        if(!created){
            throw new Exception("CANNOT CREATE FOLDER AT THIS PATH : " + folderPath);
        }
        this.folderPath = folderPath;
        this.folderName = folderName;
        this.file = file;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Folder getTrashFolder() {
        return trashFolder;
    }

    public void setTrashFolder(Folder trashFolder) {
        this.trashFolder = trashFolder;
    }

    public Folder getSpamFolder() {
        return spamFolder;
    }

    public void setSpamFolder(Folder spamFolder) {
        this.spamFolder = spamFolder;
    }

    public Folder getInboxFolder() {
        return inboxFolder;
    }

    public void setInboxFolder(Folder inboxFolder) {
        this.inboxFolder = inboxFolder;
    }

    public Folder getOutboxFolder() {
        return outboxFolder;
    }

    public void setOutboxFolder(Folder outboxFolder) {
        this.outboxFolder = outboxFolder;
    }

}
