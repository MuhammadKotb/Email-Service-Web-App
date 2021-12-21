package Controller;

import Model.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import javax.xml.crypto.Data;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class EmailServiceController {




    @PostMapping("/createFolder")
    String createFolder(@RequestBody String folderName){
        String ret ;
        try{
            Database database =  Database.getInstance();
            System.out.println("INSIDE CREATE FOLDER");
            database.addFolder(folderName);
            database.printDatabase();
            ret = "CREATED FOLDER SUCCESSFULLY";
        }
        catch (Exception e){
            System.out.println(e);
            ret = e.getMessage();
        }
        return ret;
    }

    @PostMapping("/deleteFolder")
    String deleteFolder(@RequestBody String folderName){
        String ret;
        try{
            Database database =  Database.getInstance();
            System.out.println("INSIDE DELETE FOLDER");
            database.deleteFolder(folderName);
            database.printDatabase();
            ret = "DELETED SUCCESSFULLY";
        }
        catch (Exception e){
            System.out.println(e);
            ret = e.getMessage();
        }
        return ret;
    }

    @PostMapping("/getFolder")
    String getFolder(@RequestBody String folderName){
        String ret;
        try{
            Database database =  Database.getInstance();
            System.out.println("INSIDE GET FOLDER");
            ret = database.getFolderbyName(folderName).getFolderPath();
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

   /* @PostMapping("/changeFolderName")
    String changeFolderName(@RequestBody String oldFolderName, @RequestBody String newFolderName){
        String ret = "COULD NOT CHANGE FOLDER NAME";
        try{
            Database database = Database.getInstance();

        }
        catch (Exception e){
            System.out.println(e);
        }
        return ret;
    }*/







}
