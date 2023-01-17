<%-- 
    Document   : listed
    Created on : Dec 27, 2022, 12:21:29 AM
    Author     : Oksana
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Students List</title>
        <style>
            h1{
                text-align: center;
            }
            #page {
                width: 800px;
                margin: auto;
            }
            form {
                width: 400px;
                margin: 20px auto;
            }
            input[type=submit] {
                margin: auto;
            }
            .list, .list td, .list th {
                margin: auto;
                border: 1px solid black;
                border-collapse: collapse;
            }
            .list td, .list th {
                padding:10px;
            }
            body {
                background-image: url('https://scontent.fiev6-1.fna.fbcdn.net/v/t1.6435-9/62438892_2289774424673370_1817711682441445376_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=730e14&_nc_ohc=oMnZR8dPLhgAX9fFFNk&_nc_ht=scontent.fiev6-1.fna&oh=00_AfBZaskOmTOMpMyowejNlBYh-J4swyrcihAZ6qkrORxIFQ&oe=63BF2CC2');
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: 100% 100%;
            }
            #content{
                background-color: lightblue;
                width: 400px;
                margin: 20px auto;
            }
        </style>
    </head>
    <body>
        <h1>Grouped by ${filter}</h1>
        <div id="content">
        <c:if test="${filtered.size() > 0}">
            <table class="list">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Surname</th>
                </tr>
                <c:forEach var="student" items="${filtered}">
                    <tr>
                        <td><c:out value="${student.getDoc().getId()}"/></td>
                        <td><c:out value="${student.getName()}"/></td>
                        <td><c:out value="${student.getSurname()}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
    </body>
</html>
