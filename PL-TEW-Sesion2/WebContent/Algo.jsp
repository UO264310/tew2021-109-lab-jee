<%@ page language="java" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>Carrito de fruta</title>
</head>
<body>
    <h1>Carrito de JSP</h1>
    <form action="http://localhost:8080/PL-TEW-Sesion2/Algo.jsp" method="post">
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
                <td>Escoja el artículo que desea:</td>
            </tr>
            <tr>
                <td><select name="productos" size="1">
                        <option value="sumar">Suma</option>
                        <option value="restar">Resta</option>
                        <option value="multiplicar">Multiplicar</option>
                        <option value="dividir">Dividir</option>
                </select></td>
            </tr>
            <tr>
                <td><input type="submit" value="Añadir al carrito"></td>
            </tr>
        </table>
    </form>
    <H2>Carrito de la compra:</h2>
    <H2>Calculo:</h2>
	<% 
		String calculo = ((String)request.getParameter("Calculo"));
		String p1 = ((String)request.getParameter("n1"));
		String p2 = ((String)request.getParameter("n1"));
		Integer resultado=0;
		if(calculo=="sumar"){
			resultado = Integer.parseInt(p1) + Integer.parseInt(p2);
		}if(calculo=="restar"){
			resultado = Integer.parseInt(p1) - Integer.parseInt(p2);
		}if(calculo=="multiplicar"){
			resultado = Integer.parseInt(p1) * Integer.parseInt(p2);
		}if(calculo=="dividir"){
			resultado = Integer.parseInt(p1) / Integer.parseInt(p2);
		}
		System.out.print(resultado);
		request.getSession().setAttribute("resultado",resultado);
	%>
	<c:out value="Resultado: ${resultado}"/>
	<c:out value="P1: ${n1}"/>
	<c:out value="P2: ${n2}"/>
</body>
<html>