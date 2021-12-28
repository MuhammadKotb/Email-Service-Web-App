package Controller.ServerControllers;

import Controller.EmailsFilter.CriteriaI;
import Controller.EmailsFilter.EmailsFilteringCustomizedCriteria;
import Controller.EmailsFilter.EmailsSearchingCustomizedCriteria;
import Controller.Profile.Elements.Email.Email;
import Controller.Profile.Elements.Email.EmailI;
import Controller.SingletonClasses.Database;
import Controller.SingletonClasses.Handlers.FirstHandler;
import Controller.Sorter.EmailsSorter;
import Controller.Sorter.EmailsSorterI;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:4200/home/draft")
public class DraftPageController {
    @PostMapping("/movetoTrashDraft")
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
    @GetMapping("/getDraft")
    ArrayList<EmailI> getInbox(@RequestParam(value = "username") String username){
        try{
            return Database.getInstance().getProfilebyUsername("", username).getDraft().getEmails();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/sortDraft")
    ArrayList<EmailI> sortDraft(@RequestParam(value = "username") String username, @RequestParam(value = "target") String target, @RequestParam(value = "ascending") String ascending){
        try{
            Database database = Database.getInstance();
            EmailsSorterI sorter = new EmailsSorter(Boolean.parseBoolean(ascending));
            return sorter.sort(database.getProfilebyUsername("", username).getDraft().getEmails(), target);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @GetMapping("/filterDraft")
    ArrayList<EmailI> filterDraft(@RequestParam(value = "username") String username, @RequestParam(value = "target") String target, @RequestParam(value = "feature") String feature){
        try{
            Database database = Database.getInstance();
            CriteriaI filter = new EmailsFilteringCustomizedCriteria(feature, target);
            return filter.meetCriteria(database.getProfilebyUsername("", username).getDraft().getEmails());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @GetMapping("/searchDraft")
    ArrayList<EmailI> searchDraft(@RequestParam(value = "username") String username, @RequestParam(value = "target") String target){
        try{
            Database database = Database.getInstance();
            CriteriaI searcher = new EmailsSearchingCustomizedCriteria(target);
            return searcher.meetCriteria(database.getProfilebyUsername("", username).getDraft().getEmails());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
