package Model;

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
    public void setSpam(ProfileSpamI spam) {
        this.profile.setSpam(spam);
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
    public ProfileI getProfile() {
        return this.profile;
    }
}
