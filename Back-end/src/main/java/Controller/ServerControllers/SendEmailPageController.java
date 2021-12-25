package Controller.ServerControllers;

import Controller.Email.Email;
import Controller.SingletonClasses.Handlers.SendEmailHandler;
import org.springframework.web.bind.annotation.*;

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
