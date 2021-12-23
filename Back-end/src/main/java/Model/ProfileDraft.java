package Model;

public class ProfileDraft implements ProfileDraftI {
    private DataContainerI draftDataContainer;

    public ProfileDraft(DataContainerI draftDataContainer){
        this.draftDataContainer = draftDataContainer;
    }

    @Override
    public DataContainerI getDraftDataContainer() {
        return this.draftDataContainer;
    }

    @Override
    public void setDraftDataContainer(DataContainerI draftDataContainer) {
        this.draftDataContainer = draftDataContainer;
    }
}
