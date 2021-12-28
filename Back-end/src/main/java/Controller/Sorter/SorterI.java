package Controller.Sorter;

import Controller.Email.EmailI;

import java.util.ArrayList;

public interface SorterI {
    ArrayList<EmailI> sort(ArrayList<EmailI> emails, String target) throws Exception;

}
