package Model;

public class ProfileOutbox implements ProfileOutboxI {

    private DataContainerI outboxDataContainer;

    public ProfileOutbox(DataContainerI outboxDataContainer){
        this.outboxDataContainer = outboxDataContainer;
    }
    @Override
    public DataContainerI getOutboxDataContainer() {
        return this.outboxDataContainer;
    }

    @Override
    public void setOutboxDataContainer(DataContainerI outboxDataContainer) {
        this.outboxDataContainer = outboxDataContainer;
    }
}
