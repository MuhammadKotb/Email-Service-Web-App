package Controller.ServerControllers;

import Controller.Profile.Elements.Email.Email;
import Controller.Profile.Elements.Email.EmailI;
import Controller.SingletonClasses.Creator;
import Controller.SingletonClasses.Database;
import Controller.SingletonClasses.Deleter;
import Controller.Sorter.EmailsSorter;
import Controller.Sorter.EmailsSorterI;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserFoldersPageController {

    @PostMapping("/addUserFolder")
    String addUserFolder(@RequestParam(value="foldername") String folderName, @RequestParam("username") String username){
        try{
            Creator.getInstance().createProfileFoler(folderName, Database.getInstance().getProfilebyUsername("", username));
            return "CREATED FOLDER SUCCESSFULLY";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    @DeleteMapping("/removeUserFolder")
    String removeUserFolder(@RequestParam(value = "foldername") String foldername, @RequestParam("username") String username){
        try{
            Deleter.getInstance().deleteProfileFolder(Database.getInstance().getProfilebyUsername("", username), foldername);
            return "REMOVED FOLDER SUCCESSFULLY";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }
    @PostMapping("/createEmailFolder")
    String createEmailFolder(@RequestParam(value = "username") String username, @RequestParam(value = "foldername") String folderName, @RequestParam(value = "email") String email){
        try{
            ObjectMapper map = new ObjectMapper();
            String ID = UUID.randomUUID().toString();
            Creator.getInstance().createEmailDataProfileFolder(map.readValue(email, Email.class), Database.getInstance().getProfilebyUsername("", username), folderName, ID);
            return "CREATED EMAIL SUCCESSFULLY";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    @GetMapping("/sortFolder")
    ArrayList<EmailI> sortFolder(@RequestParam(value = "username") String username, @RequestParam(value = "foldername") String folderName, @RequestParam(value = "target") String target, @RequestParam(value = "ascending") String ascending){
        try{
            Database database = Database.getInstance();
            EmailsSorterI sorter = new EmailsSorter(Boolean.parseBoolean(ascending));
            return sorter.sort(database.getProfilebyUsername("", username).getProfileFolderbyName(folderName).getEmails(), target);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
