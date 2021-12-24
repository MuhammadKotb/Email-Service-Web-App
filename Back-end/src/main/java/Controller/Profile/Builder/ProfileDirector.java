package Controller.Profile.Builder;

import Controller.DataContainerI;
import Controller.Profile.Elements.Contacts.ProfileContacts;
import Controller.Profile.Elements.ProfileDraft;
import Controller.Profile.Elements.ProfileInbox;
import Controller.Profile.Elements.ProfileOutbox;
import Controller.Profile.Elements.ProfileTrash;

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
    public void buildContacts(ProfileBuilderI profileBuilder,DataContainerI dataContainer)throws Exception{
        profileBuilder.setContacts(new ProfileContacts(dataContainer));
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
