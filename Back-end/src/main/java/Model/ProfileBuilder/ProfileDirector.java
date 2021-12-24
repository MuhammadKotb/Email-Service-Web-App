package Model.ProfileBuilder;

import Model.DataContainerI;

public class ProfileDirector {


    public void buildTrash(ProfileBuilderI profileBuilder, DataContainerI dataContainer) throws Exception{
        profileBuilder.setTrash(new ProfileTrash(dataContainer));
    }
    public void buildDraft(ProfileBuilderI profileBuilder, DataContainerI dataContainer) throws Exception{
        profileBuilder.setDraft(new ProfileDraft(dataContainer));
    }
    public void buildInbox(ProfileBuilderI profileBuilder, DataContainerI dataContainer) throws Exception{
        profileBuilder.setInbox(new ProfileInbox(dataContainer));
    }
    public void buildOutbox(ProfileBuilderI profileBuilder, DataContainerI dataContainer) throws Exception{
        profileBuilder.setOutBox(new ProfileOutbox(dataContainer));
    }
    public void buildProfileData(ProfileBuilderI profileBuilder, String encryption){
        profileBuilder.setUsername(encryption.substring(0, encryption.indexOf("$")));
        profileBuilder.setPassWord(encryption.substring(encryption.indexOf("$") + 1));
        profileBuilder.setEncryption(encryption);
    }
    public void buildDataContainer(ProfileBuilderI profileBuilder, DataContainerI dataContainer){
        profileBuilder.setDataContainer(dataContainer);
    }

}
