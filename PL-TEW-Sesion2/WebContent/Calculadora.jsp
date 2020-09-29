<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculadora</title>
</head>
<body>
	<h1>Calculadora</h1>
	<form action="http://localhost:8080/PL-TEW-Sesion2/faces/Calculadora.jsp" method="post">
		<table>
		<tr>
			<td>Parametros:
				<br>
				<br>
				Primer parametro: <input name="n1" type="text">
				Segundo parametro: <input name="n2" type="text">
				<br>
				<br>
			</td>
		</tr>
		<tr>
			<td><select name="Calculo" id="Calculo" size="1">
				<option value="Sumar">Sumar</option>
				<option value="Restar">Restar</option>
				<option value="Multiplicar">Multiplicar</option>
				<option value="Dividir">Dividir</option>
		    </select></td>
		</tr>
		<tr>
			<td><input type="submit" value="Calcular"></td>
        </tr>
        </table>
	</form>
	<H2>Calculo:</h2>
	<% 
		String calculo = null;
	    calculo=request.getParameter("Calculo");
		String p1 = request.getParameter("n1");
		String p2 = request.getParameter("n1");
		double resultado=0;
		if(p1 != null && p2 != null){
			if(calculo.equals("Sumar")){
				resultado = Integer.parseInt(p1) + Integer.parseInt(p2);
			}if(calculo.equals("Restar")){
				resultado = Integer.parseInt(p1) - Integer.parseInt(p2);
			}if(calculo.equals("Multiplicar")){
				resultado = Integer.parseInt(p1) * Integer.parseInt(p2);
			}if(calculo.equals("Dividir")){
				resultado = Integer.parseInt(p1) / Integer.parseInt(p2);
			}
		}
		request.getSession().setAttribute("Resultado",resultado);
		request.getSession().setAttribute("calculo",calculo);
	%>
	<c:out value="Resultado: ${Resultado}, ${calculo}"/>
</body>
</html>