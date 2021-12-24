package Controller.Profile;

import Controller.DataContainerI;
import Controller.Profile.Elements.Contacts.ProfileContactsI;
import Controller.Profile.Elements.ProfileDraftI;
import Controller.Profile.Elements.ProfileInboxI;
import Controller.Profile.Elements.ProfileOutboxI;
import Controller.Profile.Elements.ProfileTrashI;

public class Profile implements ProfileI {
    private String username;
    private String passWord;
    private String encryption;
    private DataContainerI dataContainer;
    private ProfileTrashI trash;
    private ProfileDraftI draft;
    private ProfileInboxI inbox;
    private ProfileOutboxI outbox;

    private ProfileContactsI contacts;

    public Profile(){}


    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassWord() {
        return this.passWord;
    }

    @Override
    public String getEncryption() {
        return this.encryption;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }

    @Override
    public DataContainerI getDataContainer() {
        return this.dataContainer;
    }

    @Override
    public void setDataContainer(DataContainerI dataContainer) {
        this.dataContainer = dataContainer;
    }

    @Override
    public ProfileTrashI getTrash() {
        return this.trash;
    }


    @Override
    public ProfileInboxI getInbox() {
        return this.inbox;
    }

    @Override
    public ProfileDraftI getDraft() {
        return this.draft;
    }

    @Override
    public ProfileOutboxI getOutbox() {
        return this.outbox;
    }

    @Override
    public ProfileContactsI getContacts() {
        return this.contacts;
    }

    @Override
    public void setTrash(ProfileTrashI trash) {
        this.trash = trash;
    }

    @Override
    public void setDraft(ProfileDraftI draft) {
        this.draft = draft;
    }

    @Override
    public void setInbox(ProfileInboxI inbox) {
        this.inbox = inbox;
    }

    @Override
    public void setOutbox(ProfileOutboxI outbox) {
        this.outbox = outbox;
    }

    @Override
    public void setContacts(ProfileContactsI contacts) {
        this.contacts = contacts;
    }
}
