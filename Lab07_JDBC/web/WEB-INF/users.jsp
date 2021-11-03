<%-- 
    Document   : users
    Created on : 29-Oct-2021, 7:02:30 AM
    Author     : tweet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        <h1>User Dashboard</h1>
        <div style="display: inline-block;vertical-align: top">
            <h2>User List</h2>
            <table>
                <div>
                    <tr>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Email</th>
                        <th>Role</th>
                        <th>Status</th>
                    </tr>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.email}</td>
                        <c:choose>
                            <c:when test="${user.role == '1'}">
                              <td>System admin </td>   
                            </c:when>
                            <c:when test="${user.role == '2'}">
                              <td>Regular user </td> 
                            </c:when>
                            <c:otherwise>
                              <td>Company Admin </td> 
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${user.active == '1'}">
                            <td>Active</td>
                            </c:when>
                            <c:when test="${user.active == '2'}">
                                <td>Inactive</td>
                            </c:when>
                        </c:choose>
                        <td><form  action="users" method="post">
                            <input type="submit" name="firstName" value="edit"> 
                            <input type="hidden" name="user_email" value="${user.email}"/>
                            <input type="hidden" name="user_first_name" value="${user.firstName}"/>
                            <input type="hidden" name="user_last_name" value="${user.lastName}"/>
                            <input type="hidden" name="user_active" value="${user.active}"/>
                            <input type="hidden" name="user_role" value="${user.role}"/>
                            <input type="hidden" name="action" value="edit"/>
                            </form></td>
                        <td><form  action="users" method="post">
                            <input type="submit" name="firstName" value="delete"> 
                            <input type="hidden" name="user_email" value="${user.email}"/>
                            <input type="hidden" name="user_first_name" value="${user.firstName}"/>
                            <input type="hidden" name="user_last_name" value="${user.lastName}"/>
                            <input type="hidden" name="user_active" value="${user.active}"/>
                            <input type="hidden" name="user_role" value="${user.role}"/>
                            <input type="hidden" name="action" value="delete"/>
                            </form></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div style="display: inline-block">
            <h2>Add user</h2>
            <form action="users" method="post">
                <div>
                    <label>First Name:</label> 
                    <input type="text" name="user_first_name">
                </div>   
                <div>
                    <label>Last Name:</label>  
                    <input type="text" name="user_last_name">
                </div>
                <div>
                    <label>Email:</label>  
                    <input type="text" name="user_email">
                </div>  
                <div>
                    <label>Password:</label>  
                    <input type="text" name="user_password">
                </div>   
                <div>
                    <label>Status:</label>     
                    <select name="user_active" >
                    <option selected="selected" value="1">Active</option>
                    <option value="2">Inactive</option>
                    </select>
                </div>
                <div>
                    <label>Role:</label> 
                        <select name="user_role" >
                        <c:forEach items="${roles}" var="role">
                        <option selected="selected" value="${role.roleID}">${role.description}</option>
                        </c:forEach>
                        </select>
                </div> 
                <input type="hidden" name="action" value="add">
                <input type="submit" value="Add & Save">
            </form>
            <h2>Edit User</h2>
             <form action="users" method="post">
                <div>
                    <label>First Name:</label> 
                    <input type="text" name="first_name_edit" value="${first_name_edit}">
                </div>   
                <div>
                    <label>Last Name:</label>  
                    <input type="text" name="last_name_edit" value="${last_name_edit}">
                </div>     
                <div>
                    <label>Status:</label>
                    <c:choose>
                        <c:when  test="${active_edit == '2'}">
                            <select name="active_edit" >
                            <option value="1">Inactive</option>
                            <option selected="selected"value="2">Inactive</option>    
                            </select>
                        </c:when>
                        <c:when  test="${active_edit == '1'}">
                            <select name="active_edit" >
                            <option selected="selected" value="1">Active</option>
                            <option value="2">Inactive</option>
                            </select>
                        </c:when>
                        <c:otherwise>
                            <select name="active_edit" >

                            <option selected="selected"value=""></option>
                            </select>
                        </c:otherwise>
                    </c:choose>
                </div> 
                <div>
                    <label>Role:</label> 
                        <select name="role_edit" >
                        <c:forEach items="${roles_edit}" var="role">                
                            <c:choose>
                                <c:when  test="${role_edit == role.roleID}">
                                    <option selected="selected" value="${role.roleID}">${role.description}</option>
                                </c:when> 
                                <c:otherwise>
                                    <option  value="${role.roleID}">${role.description}</option>   
                                </c:otherwise> 
                            </c:choose>      
                        </c:forEach>
                        </select>            
                 </div>
                <input type="hidden" name="user_email_edit" value="${user_email_edit}">
                <input type="hidden" name="action" value="update">
                <div>
                    <input type="submit" value="Update & Save">
                </div>
            </form>  
        </div>        
    </body>
</html>
