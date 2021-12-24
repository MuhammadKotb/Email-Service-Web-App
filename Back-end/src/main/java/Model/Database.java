package Model;

import Model.ProfileBuilder.ProfileI;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Database {

    private final static String databasePath = "src/main/java/Model/Database/";
    private static Database instance;
    private static int size = 0;
    private static List<ProfileI> dataBaseList;

    private Database() throws Exception{
        dataBaseList = new ArrayList<>();
        setDatabase();
    }

    public static Database getInstance() throws Exception {
        if (instance == null) {
            instance = new Database();
            System.out.println("CREATED DATABASE");
        }
        return instance;
    }


    private static void setDatabase() throws Exception{
        Creator creator = Creator.getInstance();
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
            dataBaseList.add(creator.setProfile(databasePath, files[i].getName()));
        }
    }

    public int getSize(){
        return size;
    }

    public String getDatabasePath(){
        return databasePath;
    }


    public static ProfileI getProfilebyUsername(String encryption, String username){

        if(username == "") username = encryption.substring(0, encryption.indexOf("$"));
        ProfileI profile = null;
        System.out.println(username);
        for(int i = 0; i < size; i++){
            if(username.equals(dataBaseList.get(i).getUsername())){
                System.out.println("INSIDE GET PROFILE BY USERNAME");
                profile = dataBaseList.get(i);
                System.out.println(profile.getUsername());
            }
        }
        return profile;
    }
    public static ProfileI getProfilebyEncryption(String encryption)throws Exception{
        ProfileI profile = null;
        for(int i = 0; i < size; i++){
            if(encryption.equals(dataBaseList.get(i).getEncryption())){
                System.out.println("INSIDE GET PROFILE BY USERNAME");
                profile = dataBaseList.get(i);
            }
        }
        if(profile == null){
            throw new Exception("COULD NOT FIND PROFILE BY THIS USERNAME");
        }
        return profile;
    }


    public void addProfile(String encryption) throws Exception{
        Creator creator = Creator.getInstance();
        if(size > 0){
            if (getProfilebyUsername(encryption, "") != null) {
                System.out.println(getProfilebyUsername(encryption, ""));
                throw new Exception("PROFILE WITH SAME NAME EXISTS");
            }
            else{
                System.out.println("AFTER CATCH");
                ProfileI profile = creator.createProfile(databasePath, encryption);
                dataBaseList.add(profile);
                size++;
            }
        }
        else{
            System.out.println(encryption);
            ProfileI profile = creator.createProfile(databasePath, encryption);
            dataBaseList.add(profile);
            size++;

        }
    }
    public void removeProfile(String encryption) throws Exception{
        Deleter deleter = Deleter.getInstance();
        ProfileI profile = getProfilebyUsername(encryption, "");
        if(size > 0){
            if(profile != null){
                deleter.deleteProfile(profile);
                dataBaseList.remove(profile);
                size--;
            }
            else{
                throw new Exception("COULD NOT FIND PROFILE TO DELETE");
            }
        }
        else{
            throw new Exception("DATABASE IS EMPTY");
        }
    }

    public void createDataFile(String encryption) throws Exception{
        Creator creator = Creator.getInstance();
        if(getProfilebyEncryption(encryption) == null){
            throw new Exception("THERE IS NO SUCH PROFILE");
        }
        creator.createDataFile(getProfilebyEncryption(encryption));
    }

    public void sendEmail(EmailI email) throws Exception{

        if(getProfilebyUsername("", email.getSenderUsername()) == null){
            throw new Exception("THERE IS NO SENDER BY THIS USERNAME");
        }
        if(getProfilebyUsername("", email.getreceiverUsername()) == null){
            throw new Exception("THERE IS NO RECIEVER BY THIS USERNAME");
        }
        ProfileI sender = getProfilebyUsername("", email.getSenderUsername());
        ProfileI reciever = getProfilebyUsername("", email.getreceiverUsername());
        Creator creator = Creator.getInstance();
        String senderID = UUID.randomUUID().toString();
        String recieverID = UUID.randomUUID().toString();
        reciever.getInbox().addEmail(creator.createEmailDataInbox(email, reciever, senderID));
        sender.getOutbox().addEmail(creator.createEmailDataOutbox(email, sender, recieverID));
    }

    public void movetoTrash(EmailI email) throws Exception{
        if(getProfilebyUsername("", email.getOwner()) == null){
            throw new Exception("THERE IS NO SENDER BY THIS USERNAME");
        }
        System.out.println("INSIDE MOVE TO TRASH");

        ProfileI owner = getProfilebyUsername("", email.getOwner());
        System.out.println("INSIDE MOVE TO TRASH AFTER PROFILE GET");

        if(email.getEmailType().equals("Inbox")){
            System.out.println("INSIDE INBOX MOVE TO TRASH");
            Creator.getInstance().createEmailDataTrash(email, owner, email.getEmailID());
            Deleter.getInstance().deleteEmailDataInbox(email, owner);
            owner.getInbox().removeEmailbyID(email.getEmailID());
            owner.getTrash().addEmail(email);
        }
        if(email.getEmailType().equals("Outbox")){
            Creator.getInstance().createEmailDataTrash(email, owner, email.getEmailID());
            Deleter.getInstance().deleteEmailDataOutbox(email, owner);
            owner.getOutbox().removeEmailbyID(email.getEmailID());
            owner.getTrash().addEmail(email);

        }
        if(email.getEmailType().equals("Draft")){
            Creator.getInstance().createEmailDataTrash(email, owner, email.getEmailID());
            Deleter.getInstance().deleteEmailDataDraft(email, owner);
            owner.getDraft().removeEmailbyID(email.getEmailID());
            owner.getTrash().addEmail(email);

        }
    }

    public void printDatabase(){
        for(int i = 0; i < size; i++){
            System.out.println("PROFILE Encyrption ==> ".concat(dataBaseList.get(i).getEncryption()));
            System.out.println("PROFILE UserName ==> ".concat(dataBaseList.get(i).getUsername()));
            System.out.println("PROFILE passWord ==> ".concat(dataBaseList.get(i).getPassWord()));
            System.out.println("PROFILE DataContainer Name ==> ".concat(dataBaseList.get(i).getDataContainer().getDataContainerName()));
            System.out.println("PROFILE DataContainer Path ==> ".concat(dataBaseList.get(i).getDataContainer().getDataContainerPath()));
        }
    }







}
