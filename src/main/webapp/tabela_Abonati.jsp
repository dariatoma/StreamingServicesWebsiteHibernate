<%-- 
    Document   : tabela_Medici
    Created on : Nov 22, 2016, 6:20:29 PM
    Author     : vali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Abonati</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#stergeAbonat").hide();
                $("#modificaAbonat").hide();

                $("#update").click(function () {
                    $("#modificaAbonat").show();
                    $("#stergeAbonat").hide();
                });
                $("#delete").click(function () {
                    $("#stergeAbonat").show();
                    $("#modificaAbonat").hide();
                });
            });
        </script>
		<link href="css/services.css" rel="stylesheet" type="text/css">
    </head>
    <body>
    <div>
    <hr>
    <hr>
        <h1 align="center"> Tabela Abonati:</h1> 
        <table border="1" align="center">
            <tr>
                <td><b>Id:</b></td>
                <td><b>Nume:</b></td>
                <td><b>Prenume:</b></td>
                <td><b>Varsta:</b></td>
                <td><b>Data de nastere:</b></td>
                <td><b>Tara de provenienta:</b></td>
                <td><b>Adresa de mail:</b></td>
            </tr>
            <c:forEach var="abonati" items="${listaAbonati}">
                <tr>
                    <td>${abonati.idabonati}</td>
                    <td>${abonati.nume}</td>
                    <td>${abonati.prenume}</td>
                    <td>${abonati.varsta}</td>
                    <td>${abonati.data_nasterii}</td>
                    <td>${abonati.tara}</td>
                    <td>${abonati.adresa_mail}</td>

                </tr>
            </c:forEach>
        </table>
        <form action="AbonatiController" method="POST">
            <p align="center">
                Modifica: <input type="radio" id="update" name="modifica_sterge"onclick="document.getElementById('nume').disabled = false;
                        document.getElementById('prenume').disabled = false;
                        document.getElementById('varsta').disabled = false;
                        document.getElementById('data_nasterii').disabled = false;
                        document.getElementById('tara').disabled = false;
                        document.getElementById('adresa_mail').disabled = false;"> 
                Sterge: <input type="radio" id="delete" 
                        name="modifica_sterge" onclick="document.getElementById('nume').disabled = true;
                        document.getElementById('prenume').disabled = true;
                        document.getElementById('varsta').disabled = true;
                        document.getElementById('data_nasterii').disabled = true;	
                        document.getElementById('tara').disabled = this.checked;
                        document.getElementById('adresa_mail').disabled = true;"><br><br>
                <select name="idabonati">
                    <c:forEach items="${listaAbonati}" var="abonati">
                        <option value="${abonati.idabonati}">${abonati.idabonati}</option>
                    </c:forEach>
                </select>
                <br><br>
                Modifica numele abonatului: <input id="nume" type="text" name="nume"><br><br>
                Modifica prenumele abonatului: <input id="prenume" type="text" name="prenume"> <br><br>
                Modifica varsta abonatului: <input id="varsta" type="text" name="varsta"> <br><br>
                Modifica data de nastere a abonatului: <input id="data_nasterii" type="text" name="data_nasterii"><br><br>
                Modifica tara de provenienta a abonatului: <input id="tara" type="text" name="tara"> <br><br>
                Modifica adresa de mail a abonatului: <input id="adresa_mail" type="text" name="adresa_mail"> <br><br>
                <button type="submit" id="modificaAbonat" name="modificaAbonat"> Modifica</button> <br> <br>
                <button type="submit" id="stergeAbonat" name="stergeAbonat"> Sterge </button>
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
