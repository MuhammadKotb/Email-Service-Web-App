package Model;

public class ProfileTrash implements ProfileTrashI {

    private DataContainerI trashDataContainer;


    public ProfileTrash(DataContainerI trashDataContainer){
        this.trashDataContainer = trashDataContainer;
    }

    @Override
    public DataContainerI getTrashDataContainer() {
        return this.trashDataContainer;
    }

    @Override
    public void setTrashDataContainer(DataContainerI trashDataContainer) {
        this.trashDataContainer = trashDataContainer;
    }
}
