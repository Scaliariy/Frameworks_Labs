<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Students</title>
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
        </style>
    </head>
        <h1><%= (new java.util.Date()).toLocaleString()%></h1>
        <form  action="StudentAdd">
            <table>
                <tbody>
                    <tr>
                        <td><label for="name">Name</label></td>
                        <td><input id="name" type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td><label for="surname">Surname</label></td>
                        <td><input id="surname" type="text" name="surname"></td>
                    </tr>
                    <tr>
                        <td><label for="age">Age</label></td>
                        <td><input id="age" type="text" name="age"></td>
                    </tr>
                    <tr>
                        <td><label for="email">Email</label></td>
                        <td><input id="email" type="text" name="email"></td>
                    </tr>
                    <tr>
                        <td><label for="group">Group</label></td>
                        <td><input id="group" type="text" name="group"></td>
                    </tr>
                    <tr>
                        <td><label for="faculty">Faculty</label></td>
                        <td><input id="faculty" type="text" name="faculty"></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" name="send" value="Відправити">
        </form>
        
        <c:if test="${students.size() > 0}">
            <table class="list">
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Age</th>
                    <th>Email</th>
                    <th>Group</th>
                    <th>Faculty</th>
                </tr>
                <c:forEach var="student" items="${students}">
                    <tr>
                        <td><c:out value="${student.getName()}"/></td>
                        <td><c:out value="${student.getSurname()}"/></td>
                        <td><c:out value="${student.getAge()}"/></td>
                        <td><c:out value="${student.getEmail()}"/></td>
                        <td><c:out value="${student.getGroup()}"/></td>
                        <td><c:out value="${student.getFaculty()}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
</html>
