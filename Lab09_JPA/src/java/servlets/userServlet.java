/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Role;
import models.User;
import services.RoleService;
import services.UserService;

/**
 *
 * @author tweet
 */
public class userServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             UserService userService = new UserService();
             RoleService roleService = new RoleService();

        try {
            HttpSession session = request.getSession();
            List<User> users = userService.getAll();
            List<Role> roles = roleService.getAll();
            request.setAttribute("users", users);
            request.setAttribute("roles", roles);
            getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
            return;
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        RoleService roleService = new RoleService();
        UserService userService = new UserService();
        
        String action = request.getParameter("action");

        try {
            List<Role> roles = roleService.getAll();
            String email = request.getParameter("user_email");
            String firstName = request.getParameter("user_first_name");
            String lastName = request.getParameter("user_last_name");
            String active = request.getParameter("user_active");
            String userToEditrole = request.getParameter("user_role");
            String password = request.getParameter("user_password");
            switch (action) {
                
                case "edit": 
                    
                    request.setAttribute("roles", roles);
                    request.setAttribute("last_name_edit", lastName);
                    request.setAttribute("first_name_edit", firstName);
                    request.setAttribute("active_edit", active);
                    request.setAttribute("role_edit", userToEditrole);
                    request.setAttribute("user_email_edit", email);
                    break;
                case "delete":
                    userService.delete(email);
                    break;
                case "update":
                    String emailUpdate = request.getParameter("user_email_edit");
                    String firstNameUpdate = request.getParameter("first_name_edit");
                    String lastNameUpdate = request.getParameter("last_name_edit");
                    int activeUpdate = Integer.parseInt(request.getParameter("active_edit"));
                    Integer roleUpdate = Integer.parseInt(request.getParameter("role_edit"));
                    userService.update(activeUpdate, firstNameUpdate, lastNameUpdate,roleUpdate,emailUpdate);
                    break;
                case "add":
                    int activeNo = Integer.parseInt(active);
                    int roleNo = Integer.parseInt(userToEditrole);
                    userService.insert(email, activeNo, firstName, lastName, password,roleNo);  
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(userServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            List<User> users = userService.getAll();
            List<Role> roles = roleService.getAll();
            request.setAttribute("users", users);
            request.setAttribute("roles", roles);
            getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
            return;
        } catch (Exception ex) {
            request.setAttribute("message", "error");
        }
    }
}
