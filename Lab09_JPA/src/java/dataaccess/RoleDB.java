/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import models.Role;
import models.User;

/**
 *
 * @author tweet
 */
public class RoleDB {
   private PreparedStatement ps;  
private ResultSet rs;

public List<Role> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<Role> query = em.createNamedQuery("Role.findAll", Role.class);
        try {
            List<Role> roles = query.getResultList();
   
            return roles;
        } finally {
            em.close();
        }
    } 
public Role getRole(int id) throws Exception {
       EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Role role = em.find(Role.class, id);
            System.out.println("ROLE ACCESS, RETURN ROLE IS :" + role);
            return role;
        } finally { 
            em.close();
        }
    } 
}
