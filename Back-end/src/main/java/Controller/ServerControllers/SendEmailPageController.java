package Controller.ServerControllers;

import Controller.Email.Attachment;
import Controller.Email.Email;
import Controller.Email.EmailI;
import Controller.SingletonClasses.Database;
import ch.qos.logback.core.util.FileUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import Controller.SingletonClasses.Handlers.SendEmailHandler;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200/home/sendEmail")
public class SendEmailPageController {
    Attachment attachment = new Attachment();

    @PostMapping("/sendEmail")
    String sendEmail(@RequestBody Email email){
        try{
            SendEmailHandler.getInstance().handle("SendEmail",email);
            return "SENT EMAIL SUCCESSFULLY";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    @PostMapping("/attachment")
    byte[] attachment(@RequestParam MultipartFile file){
        try{
            this.attachment.setEncoded(file.getBytes());
            this.attachment.setType(file.getContentType());
            this.attachment.setName(file.getOriginalFilename());
            ObjectMapper map = new ObjectMapper();
            map.writeValue(new File("lol4.json"), attachment);
            FileWriter fileWriter = new FileWriter(new File("lil5.txt"));
            fileWriter.write(new String(Base64.encodeBase64String(file.getBytes() )));
            System.out.println(file.getSize());
            return Base64.encodeBase64(file.getBytes());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }


}
