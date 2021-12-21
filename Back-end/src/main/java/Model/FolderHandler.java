package Model;

public class FolderHandler implements FolderHandlerI {
    private String folderName;
    private String folderPath;
    FolderHandlerI Successor;

    public FolderHandler() {
    }
    public FolderHandler(String folderName){
        this.folderName = folderName;
    }

    public void handle(String folderName){

    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

    public FolderHandlerI getSuccessor() {
        return Successor;
    }

    public void setSuccessor(FolderHandlerI successor) {
        Successor = successor;
    }
}
