package Model;

public interface ProfileI {
    String username = null;
    String passWord = null;
    String encryption = null;
    DataContainerI dataContainer = null;
    ProfileTrashI trash = null;
    ProfileSpamI spam = null;
    ProfileDraftI draft = null;
    ProfileInboxI inbox = null;
    ProfileOutboxI outbox = null;

    String getUsername();
    String getPassWord();
    String getEncryption();
    DataContainerI getDataContainer();

    void setUsername(String username);
    void setPassWord(String passWord);
    void setEncryption(String encryption);
    void setDataContainer(DataContainerI dataContainer);

    ProfileTrashI getTrash();
    ProfileSpamI getSpam();
    ProfileInboxI getInbox();
    ProfileDraftI getDraft();
    ProfileOutboxI getOutbox();


    void setTrash(ProfileTrashI trash);
    void setDraft(ProfileDraftI draft);
    void setSpam(ProfileSpamI spam);
    void setInbox(ProfileInboxI inbox);
    void setOutbox(ProfileOutboxI outbox);



}
