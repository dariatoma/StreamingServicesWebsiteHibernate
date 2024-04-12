<%-- 
    Document   : tabela_Consultatie
    Created on : Nov 22, 2016, 6:20:29 PM
    Author     : vali
--%>

<%@page import="DAOImpl.AbonatiDaoImpl"%>
<%@page import="DAOImpl.ServicesDaoImpl"%>
<%@page import="pojo.Abonati"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pojo.Services"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Abonament</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#stergeAbonament").hide();
                $("#modificaAbonament").hide();

                $("#update").click(function () {
                    $("#modificaAbonament").show();
                    $("#stergeAbonament").hide();
                });
                $("#delete").click(function () {
                    $("#stergeAbonament").show();
                    $("#modificaAbonament").hide();
                });
            });
        </script>
	<link href="css/services.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%
        AbonatiDaoImpl abonatDaoImpl = new AbonatiDaoImpl();
                                    ServicesDaoImpl servicesDaoImpl = new ServicesDaoImpl();
                                    List<Abonati> listaAbonati = new ArrayList();
                                    listaAbonati = abonatDaoImpl.afiseazaAbonat();
                                    List<Services> listaServices = new ArrayList();
                                    listaServices = servicesDaoImpl.afiseazaServices();
                                    request.setAttribute("listaAbonati", listaAbonati);
                                    request.setAttribute("listaServices", listaServices);
        %>
        <h1 align="center"> Tabela Abonament:</h1> 
        <table border="1" align="center">
            <tr>
                <td><b>IdAbonament:</b></td>
                <td><b>IdAbonat:</b></td>
                <td><b>Nume:</b></td>
                <td><b>Prenume:</b></td>
                <td><b>Varsta:</b></td>
                <td><b>Data de nastere:</b></td>
                <td><b>Tara:</b></td>
                <td><b>Adresa de mail:</b></td>
                <td><b>IdServServices:</b></td>
                <td><b>Nume:</b></td>
                <td><b>Taxa:</b></td>
                <td><b>Tip abonament:</b></td>
                <td><b>Data inceput:</b></td>
                <td><b>Data expirare:</b></td>
                <td><b>Taxa:</b></td>
            </tr>
            <c:forEach var="abonament" items="${listaAbonament}">
                <tr>
                    <td>${abonament.idabonament}</td>
                    <td>${abonament.abonati.idabonati}</td>
                    <td>${abonament.abonati.nume}</td>
                    <td>${abonament.abonati.prenume}</td>
                    <td>${abonament.abonati.varsta}</td>
                    <td>${abonament.abonati.data_nasterii}</td>
                    <td>${abonament.abonati.tara}</td>
                    <td>${abonament.abonati.adresa_mail}</td>
                    <td>${abonament.services.idservices}</td>
                    <td>${abonament.services.nume_serv}</td>
                    <td>${abonament.services.taxa_serv}</td>
                    <td>${abonament.tip_abonament}</td>
                    <td>${abonament.data_inceput}</td>
                    <td>${abonament.data_expirare}</td>
                    <td>${abonament.taxa}</td>
                </tr>
            </c:forEach>
        </table>
        <form action="AbonamentController" method="POST">
            <p align="center">
                Modifica: <input type="radio" id="update" onclick="document.getElementById('tip_abonament').disabled = false;
                        document.getElementById('idabonati').disabled = false;
                        document.getElementById('idservices').disabled = false;
                        document.getElementById('data_inceput').disabled = false;
                        document.getElementById('data_expirare').disabled = false;
                        document.getElementById('taxa').disabled = false;">
                Sterge: <input type="radio" id="delete" onclick="document.getElementById('tip_abonament').disabled = true;
                        document.getElementById('data_inceput').disabled = true;
                        document.getElementById('data_expirare').disabled = true;
                        document.getElementById('taxa').disabled = true;
                        document.getElementById('idabonati').disabled = true;
                        document.getElementById('idservices').disabled = true;"><br><br>
                idabonament:
                <select name="idabonament">
                    <c:forEach items="${listaAbonament}" var="abonament">
                        <option value="${abonament.idabonament}">${abonament.idabonament}</option>
                    </c:forEach>
                </select>
                <br><br>
                idabonat:
                <select name="idabonati">
                    <c:forEach items="${listaAbonati}" var="abonati">
                        <option value="${abonati.idabonati}">${abonati.idabonati}, ${abonati.nume}, ${abonati.prenume}, ${abonati.varsta}, ${abonati.data_nasterii}, ${abonati.tara}, ${abonati.adresa_mail}</option>
                    </c:forEach>
                </select>
                <br><br>
                idservices:
                <select name="idservices">
                    <c:forEach items="${listaServices}" var="services">
                        <option value="${services.idservices}">${services.idservices}, ${services.nume_serv}, ${services.taxa_serv}</option>
                    </c:forEach>
                </select>
                <br><br>
                Modifica tipul abonamentului: <input id="tip_abonament" type="text" name="tip_abonament"><br><br>
                Modifica data de incepere a abonamentului: <input id="data_inceput" type="text" name="data_inceput"><br><br>
                Modifica data de expirare a abonamentului: <input id="data_expirare" type="text" name="data_expirare"> <br><br>
                Modifica taxa: <input id="taxa" type="text" name="taxa"> <br><br>
                <button type="submit" id="modificaAbonament" name="modificaAbonament"> Modifica</button> <br> <br>
                <button type="submit" id="stergeAbonament" name="stergeAbonament"> Sterge </button>
            </p>
        </form>
        <br>
        <p align="center">
            <a href="index.html"><b>Home</b></a>
        </p>
    </body>
</html>
