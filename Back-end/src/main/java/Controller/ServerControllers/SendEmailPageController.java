package Controller.ServerControllers;

import Controller.Email.Attachment;
import Controller.Email.Email;
import Controller.Email.EmailI;
import Controller.Handlers.SendEmailHandler;
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
            SendEmailHandler.getInstance().handle("SendEmail",email);
            return "SENT EMAIL SUCCESSFULLY";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }


}
