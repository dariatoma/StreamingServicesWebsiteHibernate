<%-- 
    Document   : adauga_Pacient
    Created on : Nov 22, 2016, 6:19:27 PM
    Author     : vali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servicii de Streaming</title>
        <link href="css/services.css" rel="stylesheet" type="text/css">
    </head>
    <body>

        <div align="center" id="add">
            <h1> Adauga serviciul de streaming dorit </h1>
            <form action="ServicesController" method="GET">
                <table>
                    <tr>
                        <td> Numele serviciului de streaming: </td>
                        <td><input type="text" name="nume_serv"></td>
                    </tr>
                    <tr>
                        <td> Taxa serviciului de streaming: </td>
                        <td><input type="text" name="taxa_serv"></td>
                    </tr>
                    <tr>
    				<td colspan="2" align="center">
        				<input type="submit" name="adaugaServices" value="Adauga"></td>
    				</td>
					</tr>
                </table>
            </form>
        </div>

        <form action="ServicesController" method="POST">
            <p align="center"><input type="submit" name="afiseazaServices" value="Afiseaza"> &nbsp; &nbsp;<br>
        </form>
        <br>
        <p align="center"><a href="index.html"><b>Home</b></a>
    </body>
</html>
