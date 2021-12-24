package Model.ProfileBuilder;

import Model.DataContainerI;

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
