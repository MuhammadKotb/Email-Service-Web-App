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

    public static DataContainerI createDataContainer(String dataContainerPath, String dataContainerName) throws Exception{
        File file = new File(dataContainerPath);
        boolean createdFile = file.mkdir();
        if(createdFile){
            return new DataContainer(dataContainerPath, dataContainerName, file);
        }
        else{
            throw new Exception("COULD NOT CREATE DATA CONTAINER");
        }
    }


    public ProfileI createProfile(String dataBasePath, String encryption) throws Exception{
        ProfileBuilderI profileBuilder = new ProfileBuilder();
        ProfileDirector profileDirector = new ProfileDirector();

        profileDirector.buildProfileData(profileBuilder, encryption);
        profileDirector.buildDataContainer(profileBuilder, createDataContainer(dataBasePath.concat(encryption), encryption));

        profileDirector.buildInbox(profileBuilder, createDataContainer(dataBasePath.concat(encryption).concat("/Inbox"), "Inbox"));
        profileDirector.buildOutbox(profileBuilder, createDataContainer(dataBasePath.concat(encryption).concat("/Outbox"), "Outbox"));
        profileDirector.buildSpam(profileBuilder, createDataContainer(dataBasePath.concat(encryption).concat("/Spam"), "Spam"));
        profileDirector.buildDraft(profileBuilder, createDataContainer(dataBasePath.concat(encryption).concat("/Draft"), "Draft"));
        profileDirector.buildTrash(profileBuilder, createDataContainer(dataBasePath.concat(encryption).concat("/Trash"), "Trash"));

        return profileBuilder.getProfile();

    }




}
