package Controller.ServerControllers;

import Controller.EmailsFilter.CriteriaI;
import Controller.EmailsFilter.EmailsFilteringCustomizedCriteria;
import Controller.EmailsFilter.EmailsSearchingCustomizedCriteria;
import Controller.Profile.Elements.Email.EmailI;
import Controller.SingletonClasses.Database;
import Controller.Sorter.EmailsSorter;
import Controller.Sorter.EmailsSorterI;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:4200/home/trash")
public class TrashPageController {
    @GetMapping("/getTrash")
    ArrayList<EmailI> getInbox(@RequestParam(value = "username") String username){
        try{
            return Database.getInstance().getProfilebyUsername("", username).getTrash().getEmails();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @GetMapping("/sortTrash")
    ArrayList<EmailI> sortTrash(@RequestParam(value = "username") String username, @RequestParam(value = "target") String target, @RequestParam(value = "ascending") String ascending){
        try{
            Database database = Database.getInstance();
            EmailsSorterI sorter = new EmailsSorter(Boolean.parseBoolean(ascending));
            return sorter.sort(database.getProfilebyUsername("", username).getTrash().getEmails(), target);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @GetMapping("/filterTrash")
    ArrayList<EmailI> filterTrash(@RequestParam(value = "username") String username, @RequestParam(value = "target") String target, @RequestParam(value = "feature") String feature){
        try{
            Database database = Database.getInstance();
            CriteriaI filter = new EmailsFilteringCustomizedCriteria(feature, target);
            return filter.meetCriteria(database.getProfilebyUsername("", username).getTrash().getEmails());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @GetMapping("/searchTrash")
    ArrayList<EmailI> searchTrash(@RequestParam(value = "username") String username, @RequestParam(value = "target") String target){
        try{
            Database database = Database.getInstance();
            CriteriaI searcher = new EmailsSearchingCustomizedCriteria(target);
            return searcher.meetCriteria(database.getProfilebyUsername("", username).getTrash().getEmails());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
