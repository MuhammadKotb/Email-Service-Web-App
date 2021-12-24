package Controller.ServerControllers;

import Controller.Email.Email;
import Controller.SingletonClasses.Database;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/home/sendEmail")
public class SendEmailPageController {
    @PostMapping("sendEmail")
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
}
