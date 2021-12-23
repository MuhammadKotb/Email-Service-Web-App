package Model;

public class ProfileSpam implements ProfileSpamI {

    private DataContainerI spamDataContainer;

    public ProfileSpam(DataContainerI spamDataContainer){
        this.spamDataContainer = spamDataContainer;
    }

    @Override
    public DataContainerI getSpamDataContainer() {
        return this.spamDataContainer;
    }

    @Override
    public void setSpamDataContainer(DataContainerI spamDataContainer) {
        this.spamDataContainer = spamDataContainer;
    }
}
