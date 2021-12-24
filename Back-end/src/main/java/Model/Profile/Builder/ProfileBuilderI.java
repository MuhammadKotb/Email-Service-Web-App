package Model.Profile.Builder;

import Model.DataContainerI;
import Model.Profile.*;
import Model.Profile.Elements.Contacts.ProfileContactsI;
import Model.Profile.Elements.ProfileDraftI;
import Model.Profile.Elements.ProfileInboxI;
import Model.Profile.Elements.ProfileOutboxI;
import Model.Profile.Elements.ProfileTrashI;

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
