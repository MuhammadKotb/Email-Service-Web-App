package Controller.Profile;

import Controller.DataContainerI;
import Controller.Profile.Elements.Contacts.ProfileContactsI;
import Controller.Profile.Elements.ProfileDraftI;
import Controller.Profile.Elements.ProfileInboxI;
import Controller.Profile.Elements.ProfileOutboxI;
import Controller.Profile.Elements.ProfileTrashI;

public interface ProfileI {
    String username = null;
    String passWord = null;
    String encryption = null;
    DataContainerI dataContainer = null;
    ProfileTrashI trash = null;
    ProfileDraftI draft = null;
    ProfileInboxI inbox = null;
    ProfileOutboxI outbox = null;
    ProfileContactsI contacts = null;

    String getUsername();
    String getPassWord();
    String getEncryption();
    DataContainerI getDataContainer();

    void setUsername(String username);
    void setPassWord(String passWord);
    void setEncryption(String encryption);
    void setDataContainer(DataContainerI dataContainer);

    ProfileTrashI getTrash();
    ProfileInboxI getInbox();
    ProfileDraftI getDraft();
    ProfileOutboxI getOutbox();
    ProfileContactsI getContacts();


    void setTrash(ProfileTrashI trash);
    void setDraft(ProfileDraftI draft);
    void setInbox(ProfileInboxI inbox);
    void setOutbox(ProfileOutboxI outbox);
    void setContacts(ProfileContactsI contacts);


}
