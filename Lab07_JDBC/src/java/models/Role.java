/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author tweet
 */
public class Role {
    private String description;
    private int roleID;

    public Role(int roleID, String description) {
        this.roleID = roleID;
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }

    public int getRoleID() {
        return roleID;
    }
}
