package Controller.ServerControllers;

import Controller.Email.Email;
import Controller.Email.EmailI;
import Controller.SingletonClasses.Database;
import Controller.SingletonClasses.Handlers.FirstHandler;
import Controller.Sorter.Sorter;
import Controller.Sorter.SorterI;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:4200/home/sent")
public class SentPageController {
    @PostMapping("/movetoTrashSent")
    String movetoTrash(@RequestBody Email email){
        try{
            FirstHandler.getInstance().handle("MovetoTrash",email);
            return "MOVED TO TRASH SUCCESSFULLY";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }
    @GetMapping("/getSent")
    ArrayList<EmailI> getInbox(@RequestParam(value = "username") String username){
        try{
            return Database.getInstance().getProfilebyUsername("", username).getSent().getEmails();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/sortSent")
    ArrayList<EmailI> sortSent(@RequestParam(value = "username") String username, @RequestParam(value = "target") String target, @RequestParam(value = "ascending") String ascending){
        try{
            Database database = Database.getInstance();
            SorterI sorter = new Sorter(Boolean.parseBoolean(ascending));
            return sorter.sort(database.getProfilebyUsername("", username).getSent().getEmails(), target);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
