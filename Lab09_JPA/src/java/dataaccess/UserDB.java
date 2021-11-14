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
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import models.User;
/**
 *
 * @author tweet
 */
public class UserDB {

private PreparedStatement ps;  
private ResultSet rs;

public List<User> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
        try {
            List<User> users = query.getResultList();
            System.out.println(users);
            return users;
        } finally {
            em.close();
        }
    }

   public User getUser(String emailSearch) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            User user = em.find(User.class, emailSearch);
            return user;
        } finally { 
            em.close();
        }
    }

    public void insert(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(user);
            em.merge(user);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public void update(User user) throws Exception {

    }

    public void delete(String email) throws Exception {

}
}



