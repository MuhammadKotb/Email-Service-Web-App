package Model;

import org.springframework.web.multipart.MultipartFile;

public class Attachment {

    MultipartFile file;
    public Attachment(){}


    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public MultipartFile getFile() {
        return file;
    }
}
