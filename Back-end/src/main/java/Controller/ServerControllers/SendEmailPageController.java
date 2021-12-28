package Controller.ServerControllers;

import Controller.Profile.Elements.Email.Attachment;
import Controller.Profile.Elements.Email.Email;
import Controller.Profile.Elements.Email.EmailI;
import Controller.SingletonClasses.Database;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import Controller.SingletonClasses.Handlers.FirstHandler;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SendEmailPageController {
    Attachment attachment = new Attachment();

    @PostMapping("/sendEmail")
    String sendEmail(@RequestBody Email email){
        try{
            FirstHandler.getInstance().handle("SendEmail", email, "");
            return "SENT EMAIL SUCCESSFULLY";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/attachment")
    void attachment(@RequestParam("file") MultipartFile file, @RequestBody Email email){
        try{
            this.attachment.setEncoded(file.getBytes());
            this.attachment.setType(file.getContentType());
            this.attachment.setName(file.getOriginalFilename());
            ObjectMapper map = new ObjectMapper();
            map.writeValue(new File("lol4.json"), attachment);
            System.out.println(file.getSize());
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
    void movetoDraft(@RequestParam(value = "email") EmailI email){
        try {
            FirstHandler.getInstance().handle("MovetoDraft",email, "");
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
}
