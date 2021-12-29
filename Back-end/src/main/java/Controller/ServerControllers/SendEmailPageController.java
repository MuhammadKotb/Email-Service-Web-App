package Controller.ServerControllers;

import Controller.Profile.Elements.Email.Attachment;
import Controller.Profile.Elements.Email.Email;
import Controller.Profile.Elements.Email.EmailI;
import Controller.SingletonClasses.Database;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;

import Controller.SingletonClasses.Handlers.FirstHandler;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SendEmailPageController {
    Attachment attachment = new Attachment();

    /*@PostMapping("/sendEmail")
    String sendEmail(@RequestBody Email email){
        try{
            FirstHandler.getInstance().handle("SendEmail", email, "");
            return "SENT EMAIL SUCCESSFULLY";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }*/

    @PostMapping("/sendEmail")
    void attachment(@RequestParam(value = "email") String email, @RequestParam("file") MultipartFile file){
        try{
            ObjectMapper map = new ObjectMapper();
            EmailI newEmail = map.readValue(email, Email.class);
            newEmail.setAttachments(new ArrayList<Attachment>());
            Attachment attachment = new Attachment();
            attachment.setEncoded(file.getBytes());
            attachment.setName(file.getOriginalFilename());
            attachment.setType(file.getContentType());

            newEmail.addAttachment(attachment);
            System.out.println(attachment.getName());
            FirstHandler.getInstance().handle("SendEmail", newEmail, "");

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @GetMapping("/getAttachment")
    Attachment getAttachment(){
        return this.attachment;
    }

    @PostMapping("/movetoDraft")
    String movetoDraft(@RequestBody Email email){
        try {
            FirstHandler.getInstance().handle("MovetoDraft",email, "");
            return "MOVED TO DRAFT SUCCESSFULLY";

        }catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }
}
