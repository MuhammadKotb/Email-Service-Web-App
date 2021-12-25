package Controller.Email;

import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public class Attachment {

    ArrayList<MultipartFile> file = new ArrayList<>();
    public Attachment(){}


    public void setFile(ArrayList<MultipartFile> file) {
        this.file = file;
    }

    public ArrayList<MultipartFile> getFile() {
        return file;
    }


}
