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
    private int roleNumber;
    
    public String getDescription() {
        return description;
    }

    public int getRoleNumber() {
        return roleNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Role(String name) {
        this.description = name;
    }
}
