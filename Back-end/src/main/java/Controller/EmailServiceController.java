package Controller;

import Model.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import javax.xml.crypto.Data;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class EmailServiceController {




    @PostMapping("/createProfile")
    String createProfile(@RequestBody String encryption){
        String ret;
        try{
            Database database =  Database.getInstance();
            database.addProfile(encryption);
            database.printDatabase();
            ret = "CREATED DataContainer SUCCESSFULLY";
        }
        catch (Exception e){
            System.out.println(e);
            ret = e.getMessage();
        }
        return ret;
    }

    @DeleteMapping("/deleteProfile")
    String deleteProfile(@RequestBody String encryption){
        String ret;
        try{
            Database database =  Database.getInstance();
            System.out.println("INSIDE DELETE dataContainer");
            database.removeProfile(encryption);
            database.printDatabase();
            ret = "DELETED SUCCESSFULLY";
        }
        catch (Exception e){
            System.out.println(e);
            ret = e.getMessage();
        }
        return ret;
    }


    @GetMapping("/getDatabaseSize")
    int getSize() {
        int ret = -1;
        try{
            Database database = Database.getInstance();
            database.printDatabase();
            ret = database.getSize();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return ret;
    }
    @GetMapping("/getDataContainer")
    DataContainerI getDataContainer(@RequestBody String encryption){
        try{
            Database database = Database.getInstance();
            return database.getProfilebyEncryption(encryption).getDataContainer();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @PostMapping("/getProfile")
    ProfileI getProfile(@RequestBody String encryption){
        try{
            Database database = Database.getInstance();
            return database.getProfilebyEncryption(encryption);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("saveProfileData")
    String saveProfile(@RequestBody String encryption){
        try{
            Database.getInstance().createDataFile(encryption);
            return "CREATED DATA FILE SUCCESSFULLY";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

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
    @PostMapping("movetoTrash")
    String movetoTrash(@RequestBody Email email){
        try{
            Database.getInstance().movetoTrash(email);
            return "MOVED TO TRASH SUCCESSFULLY";
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
    }

    @PostMapping("addContact")
    void addContact(@RequestBody ContactI contactI){

    }


   /* @PostMapping("/changedataContainerName")
    String changedataContainerName(@RequestBody String olddataContainerName, @RequestBody String newdataContainerName){
        String ret = "COULD NOT CHANGE dataContainer NAME";
        try{
            Database database = Database.getInstance();

        }
        catch (Exception e){
            System.out.println(e);
        }
        return ret;
    }*/







}
