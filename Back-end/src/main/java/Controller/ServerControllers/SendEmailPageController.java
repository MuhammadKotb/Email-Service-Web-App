package Controller.ServerControllers;

import Controller.Email.Attachment;
import Controller.Email.Email;
import Controller.Email.EmailI;
import Controller.SingletonClasses.Database;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/home/sendEmail")
public class SendEmailPageController {
    @PostMapping("/sendEmail")
    String sendEmail(@RequestBody Email email){
        try{
            Database.getInstance().sendEmail(email);
            return "SENT EMAIL SUCCESSFULLY";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }



    @PostMapping("/attachment")
    void attachment(@RequestParam("file") Multipart[] files) {
        try{
           /*for(int i = 0; i < files.length; i++){
               ObjectMapper map = new ObjectMapper();
               map.writeValue(new File("M:\\loltst".concat(String.valueOf(files[i].getSize())).concat(".json")), files);
           }*/
            files =
            ObjectMapper map = new ObjectMapper();
            map.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            Attachment attachment = new Attachment();

            map.writeValue(new File("M:\\lololol".concat(".json")), files[0]);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @PostMapping("/test")
    void test(@RequestParam("test") String lol){
        System.out.println(lol);
    }
}
