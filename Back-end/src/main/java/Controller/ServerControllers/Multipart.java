package Controller.ServerControllers;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Multipart {

    public MultipartFile Multipart(){

        MultipartFile multipartFile = new MultipartFile() {
            @Override
            public String getName() {
                return this.getName();
            }

            @Override
            public String getOriginalFilename() {
                return this.getOriginalFilename();
            }

            @Override
            public String getContentType() {
                return this.getContentType();
            }

            @Override
            public boolean isEmpty() {
                return this.isEmpty();
            }

            @Override
            public long getSize() {
                return this.getSize();
            }

            @Override
            public byte[] getBytes() throws IOException {
                return this.getBytes();
            }

            @Override
            public InputStream getInputStream() throws IOException {
                return this.getInputStream();
            }

            @Override
            public void transferTo(File dest) throws IOException, IllegalStateException {
                this.transferTo(dest);
            }
        };
        return multipartFile;
    }

}
