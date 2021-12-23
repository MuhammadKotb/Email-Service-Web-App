package Model;

import java.io.File;

public class ProfileDirector {


    void buildTrash(ProfileBuilderI profileBuilder, DataContainerI dataContainer) throws Exception{
        profileBuilder.setTrash(new ProfileTrash(dataContainer));
    }
    void buildSpam(ProfileBuilderI profileBuilder, DataContainerI dataContainer) throws Exception{
        profileBuilder.setSpam(new ProfileSpam(dataContainer));
    }
    void buildDraft(ProfileBuilderI profileBuilder, DataContainerI dataContainer) throws Exception{
        profileBuilder.setDraft(new ProfileDraft(dataContainer));
    }
    void buildInbox(ProfileBuilderI profileBuilder, DataContainerI dataContainer) throws Exception{
        profileBuilder.setInbox(new ProfileInbox(dataContainer));
    }
    void buildOutbox(ProfileBuilderI profileBuilder, DataContainerI dataContainer) throws Exception{
        profileBuilder.setOutBox(new ProfileOutbox(dataContainer));
    }
    void buildProfileData(ProfileBuilderI profileBuilder, String encryption){
        profileBuilder.setUsername(encryption.substring(0, encryption.indexOf("$")));
        profileBuilder.setPassWord(encryption.substring(encryption.indexOf("$") + 1));
        profileBuilder.setEncryption(encryption);
    }
    void buildDataContainer(ProfileBuilderI profileBuilder, DataContainerI dataContainer){
        profileBuilder.setDataContainer(dataContainer);
    }

}
