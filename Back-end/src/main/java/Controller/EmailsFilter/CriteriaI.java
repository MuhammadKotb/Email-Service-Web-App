package Controller.EmailsFilter;

import Controller.Email.EmailI;

import java.util.ArrayList;

public interface CriteriaI {
    ArrayList<EmailI> meetCriteria(ArrayList<EmailI> emails);
}
