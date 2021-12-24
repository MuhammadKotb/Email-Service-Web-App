package Model.Profile.Elements.Contacts;

public class Contact implements ContactI {
    private String username;
    private String phoneNumber;

    public Contact(String username,String phoneNumber){
        this.username = username;
        this.phoneNumber = phoneNumber;

    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
