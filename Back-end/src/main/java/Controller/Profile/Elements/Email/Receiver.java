package Controller.Profile.Elements.Email;

public class Receiver implements ReceiverI{
    String username;
    int number;
    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int getNumber() {
        return this.number;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}
