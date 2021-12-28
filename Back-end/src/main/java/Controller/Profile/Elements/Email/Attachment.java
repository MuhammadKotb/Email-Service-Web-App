package Controller.Profile.Elements.Email;

public class Attachment {

    String encodedString;
    byte[] encoded;
    String name;
    String type;



    public void setEncoded(byte[] encoded) {
        this.encoded = encoded;
    }

    public String getEncodedString() {
        return this.encodedString;
    }
    public byte[] getEncoded(){
        return this.encoded;
    }

    public void setEncoded(String encodedString) {
        this.encodedString = encodedString;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
