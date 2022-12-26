<%-- 
    Document   : statistics
    Created on : Dec 25, 2022, 7:22:49 AM
    Author     : NIkol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Students Statistics</title>
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
                background-image: url('https://scontent.fiev6-1.fna.fbcdn.net/v/t39.30808-6/241828028_4308523742568048_1634668619554043978_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=730e14&_nc_ohc=wAfCWeEk7tUAX-zcRd0&_nc_ht=scontent.fiev6-1.fna&oh=00_AfDGTnck5WJmLGWLZyLoGdee9Y-OCbW6agBapCr4GOpceg&oe=639C5E5D');
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
        <h1>Statistics</h1>
        <table>
                <tbody>
                    <tr>
                        <td><label for="name">Mean Age:</label></td>
                        <td>${stat.getMeanAge()}</td>
                    </tr>
                    <tr>
                        <td><label for="surname">Popular mail domain:</label></td>
                        <td>${stat.getPopularMailDomain()}</td>
                    </tr>
                    <tr>
                        <td><label for="surname1">"sumdu" mail domain:</label></td>
                        <td>${stat.getSumduMails()}</td>
                    </tr>
                    <tr>
                        <td><label for="surname2">Min Age:</label></td>
                        <td>${stat.getMinAge()}</td>
                    </tr>
                    <tr>
                        <td><label for="surname3">Max Age:</label></td>
                        <td>${stat.getMaxAge()}</td>
                    </tr>
                    <tr>
                        <td><label for="surname4">Number of students from different faculties:</label></td>
                        <td>${stat.getNumberStudentsFromDifferentFaculties()}</td>
                    </tr>
                    <tr>
                        <td><label for="surname5">Number of different groups:</label></td>
                        <td>${stat.getNumberDifferentGroups()}</td>
                    </tr>
                </tbody>
            </table>
    </body>
</html>