package gr.aueb.cf.service;

import gr.aueb.cf.model.User;

public class UserNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(User user) {
        super("User with id: " + user.getId() + " was not found");
    }

    public UserNotFoundException(String s) {
        super(s);
    }
}
