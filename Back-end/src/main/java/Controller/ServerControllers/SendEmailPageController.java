package Controller.ServerControllers;

import Controller.Email.Attachment;
import Controller.Email.Email;
import Controller.Email.EmailI;
import Controller.SingletonClasses.Database;
import Controller.Sorter.Sorter;
import Controller.Sorter.SorterI;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;

import Controller.SingletonClasses.Handlers.FirstHandler;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SendEmailPageController {
    Attachment attachment = new Attachment();

    @PostMapping("/sendEmail")
    String sendEmail(@RequestBody EmailI email){
        try{
            FirstHandler.getInstance().handle("SendEmail", email);
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
    @PostMapping("/test")
    void testMethod(@RequestParam(value = "string") String string, @RequestBody Email email){
        System.out.println(string);
        System.out.println(email.getBody());
    }

    @GetMapping("/getAttachment")
    Attachment getAttachment(){
        return this.attachment;
    }




}
