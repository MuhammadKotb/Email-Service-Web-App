package Controller.Handlers;

import Controller.Email.EmailI;

public interface HandlerI {
    String concern = null;
    HandlerI successor = null;
    void handle(String concern, EmailI email)throws Exception;
}
