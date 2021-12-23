package Model;

public class ProfileInbox implements ProfileInboxI{

    private DataContainerI inboxDataContainer;

    public ProfileInbox(DataContainerI inboxDataContainer){
        this.inboxDataContainer = inboxDataContainer;
    }

    @Override
    public DataContainerI getInboxDataContainer() {
        return this.inboxDataContainer;
    }

    @Override
    public void setInboxDataContainer(DataContainerI inboxDataContainer) {
        this.inboxDataContainer = inboxDataContainer;
    }
}
