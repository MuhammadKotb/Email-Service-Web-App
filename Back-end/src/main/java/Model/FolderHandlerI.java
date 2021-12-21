package Model;

public interface FolderHandlerI {
    String folderName = null;
    String folderPath = null;
    FolderHandlerI Successor = null;
    String getFolderName();
    String getFolderPath();
    FolderHandlerI getSuccessor();
    void setFolderName(String folderName);
    void setFolderPath(String folderPath);
    void setSuccessor(FolderHandlerI successor);
    void handle(String folderName);

}
