package Model.Profile.Elements.Contacts;

public interface ContactI {
    String username = null;
    String phoneNumber = null;

    String getPhoneNumber();
    String getUsername() ;
    void setUsername(String username);
    void setPhoneNumber(String phoneNumber) ;

}
