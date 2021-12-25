package Controller.Profile.Builder;

import Controller.DataContainerI;
import Controller.Profile.*;
import Controller.Profile.Elements.Contacts.ProfileContactsI;
import Controller.Profile.Elements.ProfileDraftI;
import Controller.Profile.Elements.ProfileInboxI;
import Controller.Profile.Elements.ProfileOutboxI;
import Controller.Profile.Elements.ProfileTrashI;

public interface ProfileBuilderI {
    void setUsername(String username);
    void setPassWord(String passWord);
    void setEncryption(String encryption);
    void setDataContainer(DataContainerI dataContainer);
    void setTrash(ProfileTrashI trash);
    void setDraft(ProfileDraftI draft);
    void setInbox(ProfileInboxI inbox);
    void setOutBox(ProfileOutboxI outBox);
    void setContacts(ProfileContactsI contacts);

    ProfileI getProfile();
}
