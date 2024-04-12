<%-- 
    Document   : adauga_Medic
    Created on : Nov 22, 2016, 6:19:27 PM
    Author     : vali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Abonati</title>
        <link href="css/services.css" rel="stylesheet" type="text/css">
    </head>
    <body>

        <div align="center" id="add">
            <h1> Adauga abonat </h1>
            <form action="AbonatiController" method="GET">
                <table>
                    <tr>
                        <td> Numele abonatului: </td>
                        <td><input type="text" name="nume"></td>
                    </tr>
                    <tr>
                        <td> Prenumele abonatului: </td>
                        <td><input type="text" name="prenume"></td>
                    </tr>
                    <tr>
                        <td> Varsta abonatului: </td>
                        <td><input type="text" name="varsta"></td>
                    </tr>
                    <tr>
                        <td> Data de nastere a abonatului: </td>
                        <td><input type="text" name="data_nasterii"></td>
                    </tr>
                    <tr>
                        <td> Tara de provenienta a abonatului: </td>
                        <td><input type="text" name="tara"></td>
                    </tr>
                    <tr>
                        <td> Adresa de Mail a abonatului: </td>
                        <td><input type="text" name="adresa_mail"></td>
                    </tr>
                    <tr>
    				<td colspan="2" align="center">
        				<input type="submit" name="adaugaAbonat" value="Adauga"></td>
    				</td>
					</tr>
                </table>
            </form>
        </div>

        <form action="AbonatiController" method="POST">
            <p align="center"><input type="submit" name="afiseazaAbonat" value="Afiseaza"> &nbsp; &nbsp;<br>
        </form>
        <br>
        <p align="center"><a href="index.html"><b>Home</b></a>
    </body>
</html>
