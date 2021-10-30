/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.User;
import dataaccess.UserDB;
/**
 *
 * @author tweet
 */
public class UserService {
    
    public List<User> getAll() throws Exception {
        UserDB userdb = new UserDB();
        List<User> notes = userdb.getAll();
        return notes;
    }
    
       public User getUser(String email) throws Exception {
        UserDB userdb = new UserDB();
        User note = userdb.getUser(email);
        return note;
    }

    
    public void insert(String email, int active, String firstName, String lastName, String password, int role) throws Exception {
        User newUser = new User(email, active, firstName, lastName, password,role);
        UserDB noteDB = new UserDB();
        noteDB.insert(newUser);
    }
    
    public void update(int active, String firstName, String lastName, String password, int role, String email) throws Exception {
        UserDB userdb = new UserDB();
        User user = userdb.getUser(email);
        user.setActive(active);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setRole(role);
        userdb.update(user);
    }
    //NO PASSWORD
    public void update(int active, String firstName, String lastName, int role, String email) throws Exception {
        UserDB userdb = new UserDB();
        User user = userdb.getUser(email);
        user.setActive(active);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRole(role);
        userdb.update(user);
    }
    
    public void delete(String email) throws Exception {
        UserDB userdb = new UserDB();
        userdb.delete(getUser(email));
    }
}
