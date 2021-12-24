package Controller.Email;

public class Attachment {
    String extension;
    String name;
    String encoded;
    public Attachment(){}

    public Attachment(String encoded, String extension, String name){
        this.encoded = encoded;
        this.extension = extension;
        this.name = name;
    }

    public String getEncoded() {
        return this.encoded;
    }

    public void setEncoded(String encoded) {
        this.encoded = encoded;
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
