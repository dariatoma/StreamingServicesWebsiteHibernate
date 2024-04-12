<%-- 
    Document   : adauga_Consultatie
    Created on : Nov 22, 2016, 6:19:27 PM
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
        <link href="css/abonam.css" rel="stylesheet" type="text/css">
    </head>
    <body>
    <div>
    <hr>
    <hr>
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
        <div align="center" id="add">
            <h1> Adauga un nou abonament </h1>
            <form action="AbonamentController" method="GET">
                <table>
                    <tr>
                        <td> Abonat: </td>
                        <td>
                            <select name="idabonati">
                                <c:forEach items="${listaAbonati}" var="abonati">
                                    <option value="${abonati.idabonati}">${abonati.idabonati}, ${abonati.nume}, ${abonati.prenume}, ${abonati.varsta}, ${abonati.data_nasterii}, ${abonati.tara}, ${abonati.adresa_mail}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td> Serviciul de streaming: </td>
                        <td>
                            <select name="idservices">
                                <c:forEach items="${listaServices}" var="services">
                                    <option value="${services.idservices}">${services.idservices}, ${services.nume_serv}, ${services.taxa_serv}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td> Tip: </td>
                        <td><input type="text" name="tip_abonament"></td>
                    </tr>
                    <tr>
                        <td> Data de inceput: </td>
                        <td><input type="text" name="data_inceput"></td>
                    </tr>
                    <tr>
                        <td> Data de expirare: </td>
                        <td><input type="text" name="data_expirare"></td>
                    </tr>
                    <tr>
                        <td> Taxa: </td>
                        <td><input type="text" name="taxa"></td>
                    </tr>
                    <tr>
    				<td colspan="2" align="center">
        				<input type="submit" name="adaugaAbonament" value="Adauga">
    				</td>
					</tr>

                </table>
            </form>
        </div>

        <form action="AbonamentController" method="POST">
            <p align="center"><input type="submit" name="afiseazaAbonament" value="Afiseaza"> &nbsp; &nbsp;<br>
        </form>
        <br>
        <p align="center"><a href="index.html"><b>Home</b></a>
        <hr>
        <hr>
        </div>
    </body>
</html>
