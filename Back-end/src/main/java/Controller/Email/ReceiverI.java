package Controller.Email;

public interface ReceiverI {
    String username = null;
    int number = 1;

    void setUsername(String username);
    void setNumber(int number);

    int getNumber();
    String getUsername();
}
