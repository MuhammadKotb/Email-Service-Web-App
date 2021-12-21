package Model;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

public class Database {

    private final static String databasePath = "src/main/java/Model/Database/";
    private static Database instance;
    private static int size = 0;
    private Database() throws Exception{
        setDatabase();
    }

    public static Database getInstance() throws Exception {
        if (instance == null) {
            instance = new Database();
            System.out.println("CREATED DATABASE");
        }
        return instance;
    }

    private static ArrayList<Folder> dataBaseFolder = new ArrayList<>();

    private static void setDatabase() throws Exception{
        File file = new File(databasePath);
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        if(files == null || file == null){
            throw new Exception("NO SUCH DIRECTORY");
        }
        size = files.length;

        for(int i = 0; i < size; i++){
            Folder folder = new Folder(files[i].getPath(), files[i].getName(), files[i]);
            folder.setInboxFolder(new Folder(folder.getFolderPath().concat("/Inbox"), "Inbox", new File(folder.getFolderPath().concat("/Inbox"))));
            folder.setTrashFolder(new Folder(folder.getFolderPath().concat("/Trash"), "Trash", new File(folder.getFolderPath().concat("/Trash"))));
            folder.setSpamFolder(new Folder(folder.getFolderPath().concat("/Spam"), "Spam", new File(folder.getFolderPath().concat("/Spam"))));
            folder.setOutboxFolder(new Folder(folder.getFolderPath().concat("/Outbox"), "Outbox", new File(folder.getFolderPath().concat("/Outbox"))));
            dataBaseFolder.add(folder);
        }
    }
    public int getSize(){
        return size;
    }

    public String getDatabasePath(){
        return databasePath;
    }


    public Folder getFolderbyName(String folderName)throws Exception{
        Folder folder = null;
        for(int i = 0; i < size; i++){
            if(folderName.equals(dataBaseFolder.get(i).getFolderName())){
                System.out.println("INSIDE GET FOLDER BY NAME");
                folder = dataBaseFolder.get(i);
            }
        }
        if(folder == null){
            throw new Exception("COULD NOT FIND FOLDER BY THIS NAME");
        }
        return folder;
    }
    public void addFolder(String folderName) throws Exception{
        Creator creator = Creator.getInstance();
        if(size > 0){
            try {
                if (getFolderbyName(folderName) != null) {

                    throw new Exception("FOLDER WITH SAME NAME AND PATH EXISTS");
                }
            }catch (Exception e){
                Folder folder = creator.createFolder(databasePath.concat(folderName), folderName);
                dataBaseFolder.add(folder);
                size++;
                creator.createFolderData(folder);
            }

        }
        else {
            Folder folder = creator.createFolder(databasePath.concat(folderName), folderName);
            dataBaseFolder.add(folder);
            size++;
            creator.createFolderData(folder);
        }
    }
    public void deleteFolder(String folderName) throws Exception{
        Deleter deleter = Deleter.getInstance();
        Folder folder = getFolderbyName(folderName);
        if(size > 0){
            if(folder != null){
                deleter.deleteFolder(folder);
                dataBaseFolder.remove(folder);
                size--;
            }
            else{
                throw new Exception("COULD NOT FIND FOLDER TO DELETE");
            }
        }
        else{
            throw new Exception("DATABASE IS EMPTY");
        }
    }



    public void printDatabase(){
        for(int i = 0; i < size; i++){
            System.out.println("Folder Path ==> ".concat(dataBaseFolder.get(i).getFolderPath()));
            System.out.println("Folder Name ==> ".concat(dataBaseFolder.get(i).getFolderName()));
        }
    }







}
