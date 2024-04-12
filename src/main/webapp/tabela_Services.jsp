<%-- 
    Document   : tabela_Pacienti
    Created on : Nov 22, 2016, 6:20:29 PM
    Author     : vali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servicii de Streaming</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        
        <script>
            $(document).ready(function () {
                $("#stergeServices").hide();
                $("#modificaServices").hide();

                $("#update").click(function () {
                    $("#modificaServices").show();
                    $("#stergeServices").hide();
                });
                $("#delete").click(function () {
                    $("#stergeServices").show();
                    $("#modificaServices").hide();
                });
            });
        </script>
	<link href="css/services.css" rel="stylesheet" type="text/css">
    </head>
    <body>
    <div>
    <hr>
    <hr>
        <h1 align="center"> Tabela servicii de streaming:</h1> 
        <table border="1" align="center">
            <tr>
                <td><b>Id-ul serviciului de streaming:</b></td>
                <td><b>Numele serviciului de streaming:</b></td>
                <td><b>Taxa serviciului de streaming:</b></td>
            </tr>
            <c:forEach var="services" items="${listaServices}">
                <tr>
                    <td>${services.idservices}</td>
                    <td>${services.nume_serv}</td>
                    <td>${services.taxa_serv}</td>

                </tr>
            </c:forEach>
        </table>
        <form action="ServicesController" method="POST">
            <p align="center">
                Modifica: <input type="checkbox" id="update"> Sterge: <input type="checkbox" id="delete" onclick="document.getElementById('nume_serv').disabled = this.checked;
                        document.getElementById('taxa_serv').disabled = this.checked;"><br><br>
                <select name="idservices">
                    <c:forEach items="${listaServices}" var="services">
                        <option value="${services.idservices}">${services.idservices}</option>
                    </c:forEach>
                </select>
                <br><br>
                Modifica numele serviciului de streaming: <input id="nume_serv" type="text" name="nume_serv"><br><br>
                Modifica taxa serviciului de streaming: <input id="taxa_serv" type="text" name="taxa_serv"> <br><br>
                <button type="submit" id="modificaServices" name="modificaServices"> Modifica</button> <br> <br>
                <button type="submit" id="stergeServices" name="stergeServices"> Sterge </button>
            </p>
        </form>
        <p align="center">
            <a href="index.html"><b>Home</b></a>
        </p>
        <hr>
        <hr>
        </div>
    </body>
</html>
