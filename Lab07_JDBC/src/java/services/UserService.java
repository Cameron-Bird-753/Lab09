/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.User;
import dataaccess.UserDB;
import models.Role;
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
        User user = userdb.getUser(email);
        return user;
    }

    
    public void insert(String email, int active, String firstName, String lastName, String password, int userRole) throws Exception {
        RoleService roleService = new RoleService();
        Role role = roleService.getRole(userRole);
        User newUser = new User(email, active, firstName, lastName, password,role);
        UserDB noteDB = new UserDB();
        noteDB.insert(newUser);
    }
    
    public void update(int active, String firstName, String lastName, int userRole, String email) throws Exception {
        RoleService roleService = new RoleService();
        Role role = roleService.getRole(userRole);
        User user = new User( active,  firstName,  lastName,  role, email);
        UserDB userdb = new UserDB();
        userdb.update(user);
    }
    
    public void delete(String email) throws Exception {
        UserDB userdb = new UserDB();
        userdb.delete(email);
    }
}
