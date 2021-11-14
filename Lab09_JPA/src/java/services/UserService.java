    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.RoleDB;
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
        UserDB userdb = new UserDB();
        User newUser = new User(email, active, firstName, lastName, password);
        RoleDB roleDB = new RoleDB();
        Role role = roleDB.getRole(userRole);
        newUser.setRole(role);
        userdb.insert(newUser);
    }
    
    public void update(int active, String firstName, String lastName, int userRole, String email) throws Exception {
          UserDB userdb = new UserDB();
          RoleDB roleDB = new RoleDB();
          User user = userdb.getUser(email);
          
          user.setActive(active);
          user.setFirstName(firstName);
          user.setLastName(lastName);
          Role role = roleDB.getRole(userRole);
          user.setRole(role);
          userdb.update(user);

    }
    
    public void delete(String email) throws Exception {
//        UserDB userdb = new UserDB();
//        userdb.delete(email);
    }
}
