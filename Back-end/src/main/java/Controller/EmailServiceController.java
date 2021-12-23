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

    @PostMapping("/getProfile")
    String getProfile(@RequestBody String encryption){
        String ret;
        try{
            Database database =  Database.getInstance();
            System.out.println("INSIDE GET dataContainer");
            ret = database.getProfilebyEncryption(encryption).getPassWord();
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
