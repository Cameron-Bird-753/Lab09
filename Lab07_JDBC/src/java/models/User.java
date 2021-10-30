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
public class User {
    private String firstName;
    private String lastName;
    private String password;
    private int role;
    private String email;
    private int active;
    
    public User(String email, int active, String firstName, String lastName, String password, int role ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.email= email;
        this.active = active;
    }
    
    public User(int active, String firstName, String lastName, int role, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.active = active;
        this.email= email;
    }
       

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" + "firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", role=" + role + ", email=" + email + ", active=" + active + '}';
    }
    
    
    
    
}
