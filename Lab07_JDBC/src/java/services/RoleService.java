/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.RoleDB;
import dataaccess.UserDB;
import java.util.ArrayList;
import java.util.List;
import models.Role;
import models.User;

/**
 *
 * @author tweet
 */
public class RoleService {
    public List<Role> getAll() throws Exception {
        RoleDB roledb = new RoleDB();
        List<Role> roles = roledb.getAll();
        return roles;
    }
        
    public Role getRole(int roleID) throws Exception {
        RoleDB roledb = new RoleDB();
        Role role = roledb.getRole(roleID);
        return role;
    }
}
