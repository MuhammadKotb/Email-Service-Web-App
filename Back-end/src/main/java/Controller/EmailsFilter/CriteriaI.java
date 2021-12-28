package Controller.EmailsFilter;

import Controller.Profile.Elements.Email.EmailI;

import java.util.ArrayList;

public interface CriteriaI {
    ArrayList<EmailI> meetCriteria(ArrayList<EmailI> emails);
}
