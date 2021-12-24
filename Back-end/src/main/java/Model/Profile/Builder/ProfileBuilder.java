package Model.Profile.Builder;

import Model.DataContainerI;
import Model.Profile.*;
import Model.Profile.Elements.Contacts.ProfileContactsI;
import Model.Profile.Elements.ProfileDraftI;
import Model.Profile.Elements.ProfileInboxI;
import Model.Profile.Elements.ProfileOutboxI;
import Model.Profile.Elements.ProfileTrashI;

public class ProfileBuilder implements ProfileBuilderI {

    private ProfileI profile;

    public ProfileBuilder(){
        this.profile = new Profile();
    }

    @Override
    public void setUsername(String username) {
        this.profile.setUsername(username);
    }

    @Override
    public void setPassWord(String passWord) {
        this.profile.setPassWord(passWord);
    }

    @Override
    public void setEncryption(String encryption) {
        this.profile.setEncryption(encryption);
    }

    @Override
    public void setDataContainer(DataContainerI dataContainer) {
        this.profile.setDataContainer(dataContainer);
    }

    @Override
    public void setTrash(ProfileTrashI trash) {
        this.profile.setTrash(trash);
    }


    @Override
    public void setDraft(ProfileDraftI draft) {
        this.profile.setDraft(draft);
    }

    @Override
    public void setInbox(ProfileInboxI inbox) {
        this.profile.setInbox(inbox);
    }

    @Override
    public void setOutBox(ProfileOutboxI outBox) {
        this.profile.setOutbox(outBox);
    }

    @Override
    public void setContacts(ProfileContactsI contacts){ this.profile.setContacts(contacts);}

    @Override
    public ProfileI getProfile() {
        return this.profile;
    }
}
