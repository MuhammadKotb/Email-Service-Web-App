package Model;

public interface ProfileOutboxI {
    DataContainerI outboxDataContainer = null;

    DataContainerI getOutboxDataContainer();
    void setOutboxDataContainer(DataContainerI outboxDataContainer);


}
