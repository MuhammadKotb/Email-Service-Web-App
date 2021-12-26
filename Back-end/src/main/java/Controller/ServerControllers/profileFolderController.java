package Controller.ServerControllers;

import Controller.Email.Email;
import Controller.Email.EmailI;
import Controller.SingletonClasses.Creator;
import Controller.SingletonClasses.Database;
import Controller.SingletonClasses.Deleter;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class profileFolderController {

    @PostMapping("/addUserFolder")
    String addUserFolder(@RequestParam(value="foldername") String folderName, @RequestParam("username") String username){
        try{
            Creator.getInstance().createProfileFoler(folderName, Database.getProfilebyUsername("", username));
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
            Deleter.getInstance().deleteProfileFolder(Database.getProfilebyUsername("", username), foldername);
            return "REMOVED FOLDER SUCCESSFULLY";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }
    @PostMapping("/createEmailFolder")
    String createEmailFolder(@RequestBody Email email){
        try{
            Creator.getInstance().createEmailDataProfileFolder(email, Database.getProfilebyUsername("", "Muhammad"), "folder54", "14545945994");
            return "CREATED EMAIL SUCCESSFULLY";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }
}
