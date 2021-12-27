package Controller.ServerControllers;

import Controller.Email.Attachment;
import Controller.Email.Email;
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
            FirstHandler.getInstance().handle("SendEmail",email);
            return "SENT EMAIL SUCCESSFULLY";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/attachment")
    void attachment(@RequestParam("file") MultipartFile file){
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


}
