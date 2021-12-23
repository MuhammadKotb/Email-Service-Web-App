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

    private static DataContainerI createDataContainer(String dataContainerPath, String dataContainerName) throws Exception{
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

    public ProfileI setProfile(String dataBasePath, String encryption){
        ProfileBuilderI profileBuilder = new ProfileBuilder();
        ProfileDirector profileDirector = new ProfileDirector();

        profileDirector.buildProfileData(profileBuilder, encryption);

        profileDirector.buildDataContainer(profileBuilder, new DataContainer(dataBasePath.concat(encryption), encryption, new File(dataBasePath.concat(encryption))));

        profileDirector.buildInbox(profileBuilder, new DataContainer(dataBasePath.concat(encryption).concat("/Inbox"), "Inbox", new File(dataBasePath.concat(encryption).concat("/Inbox"))));
        profileDirector.buildOutbox(profileBuilder, new DataContainer(dataBasePath.concat(encryption).concat("/Outbox"), "Outbox", new File(dataBasePath.concat(encryption).concat("/Outbox"))));
        profileDirector.buildSpam(profileBuilder, new DataContainer(dataBasePath.concat(encryption).concat("/Spam"), "Spam", new File(dataBasePath.concat(encryption).concat("/Spam"))));
        profileDirector.buildDraft(profileBuilder, new DataContainer(dataBasePath.concat(encryption).concat("/Draft"), "Draft", new File(dataBasePath.concat(encryption).concat("/Draft"))));
        profileDirector.buildTrash(profileBuilder, new DataContainer(dataBasePath.concat(encryption).concat("/Trash"), "Trash", new File(dataBasePath.concat(encryption).concat("/Trash"))));

        return profileBuilder.getProfile();


    }




}
