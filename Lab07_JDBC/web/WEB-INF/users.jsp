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
        <form metod="POST" action="insert">
            
        </form>
        <table>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>${user.role}</td>
                    <td>${user.active}</td>
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
                        <input type="hidden" name="action" value="delete"/>
                        </form></td>
                </tr>
            </c:forEach>
        </table>
            <h2>Edit User</h2>
            <form action="update" method="post">
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
                        <c:when  test="${active_edit == '1'}">
                            <select name="status_edit" >
                            <option selected="selected" value="active">Active</option>
                            <option value="Inactive">Inactive</option>
                            </select>
                        </c:when>
                        <c:otherwise>
                            <select name="status_edit" >
                            <option value="active">Active</option>
                            <option selected="selected"value="Inactive">Inactive</option>
                            </select>
                        </c:otherwise>
                    </c:choose>
                </div> 
                <div>
                <label>Role:</label> 
                    <c:choose>
                        <c:when  test="${role_edit == '1'}">
                            <select name="status_edit" >
                            <option selected="selected" value="1">System Admin</option>
                            <option value="2">Regular User</option>
                            <option value="3">Company Admin</option>
                            </select>
                        </c:when>
                        <c:when  test="${role_edit == '2'}">
                            <select name="status_edit" >
                            <option value="1">System Admin</option>
                            <option selected="selected" value="2">Regular User</option>
                            <option value="3">Company Admin</option>
                            </select>
                        </c:when>
                        <c:otherwise>
                            <select name="status_edit" >
                            <option value="1">System Admin</option>
                            <option  value="2">Regular User</option>
                            <option selected="selected"value="3">Company Admin</option>
                            </select>
                        </c:otherwise>
                    </c:choose>
                </div>
                
                <input type="hidden" name="user_email" value="${user.email}">
                <input type="hidden" name="action" value="update">
                <input type="submit" value="Update & Save">
            </form>
                
                
    </body>
</html>
