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
import models.User;
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

        try {
            HttpSession session = request.getSession();
            List<User> users = userService.getAll();
            System.out.println("users" + users.get(0));
            request.setAttribute("users", users);
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
        UserService userService = new UserService();

       
        String action = request.getParameter("action");
          
            System.out.println("ACTION IS: " + action);
      

        try {
            String email = request.getParameter("user_email");
            String firstName = request.getParameter("user_first_name");
            String lastName = request.getParameter("user_last_name");
            int active = Integer.parseInt(request.getParameter("user_active"));
            int role = Integer.parseInt(request.getParameter("user_role"));
            String password = request.getParameter("user_password");
            switch (action) {
                
                case "edit": 
                    request.setAttribute("last_name_edit", lastName);
                    request.setAttribute("first_name_edit", firstName);
                    request.setAttribute("active_edit", active);
                    request.setAttribute("role_edit", role);
                    request.setAttribute("user_email_edit", email);
                    break;
                case "delete":
                    System.out.println("delete info" + email + active + role);
                    userService.delete(email);
                    break;
                case "update":
                    String emailUpdate = request.getParameter("user_email_edit");
                    System.out.println("email is: " + emailUpdate);
                    String firstNameUpdate = request.getParameter("first_name_edit");
                    String lastNameUpdate = request.getParameter("last_name_edit");
                    int activeUpdate = Integer.parseInt(request.getParameter("active_edit"));
                    int roleUpdate = Integer.parseInt(request.getParameter("role_edit"));

                    userService.update(activeUpdate, firstNameUpdate, lastNameUpdate,roleUpdate,emailUpdate);
                    System.out.println("ran update");
                    break;
                case "add":
                    userService.insert(email, active, firstName, lastName, password,role);  
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(userServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
//            request.setAttribute("message", action);
//        } catch (Exception ex) {
//            Logger.getLogger(NoteServlet.class.getName()).log(Level.SEVERE, null, ex);
//            request.setAttribute("message", "error");
//        }
//
        try {
            List<User> users = userService.getAll();
            request.setAttribute("users", users);
            getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
            return;
        } catch (Exception ex) {
            
            request.setAttribute("message", "error");
        }

       
    }

}
