<%@ page language="java" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Carrito de fruta</title>
</head>
<body>
	<h1>Carrito de JSP</h1>
	<form action="http://localhost:8080/PL-TEW-Sesion2/CarritoCompraServlet" method="post">
		<table>
		<tr>
			<td>Escoga una fruta:</td>
		</tr>
		<tr>
			<td><select name="productos" size="1">
					<option value=01>Manzana</option>
					<option value=02>Platano</option>
					<option value=03>Pera</option>
					<option value=04>Naranja</option>
					<option value=05>Kiwi</option>
					<option value=06>Caqui</option>
					<option value=07>Uva</option>
					<option value=08>Melocoton</option>
					<option value=09>Lechuga</option>
					<option value=10>Ajo</option>
				</select></td>
			</tr>
			<tr>
				<td><input type=submit value="Añadir al carrito"></td>
			</tr>
		</table>
	</form>
	<h2>Carrito de la compra: </h2>
	<br>
	<jsp:useBean id="carrito" class="java.util.HashMap"
        scope="session" />
	<ul>
		<c:forEach var="entry" items="${Carrito}">
			<li>
			<c:out value="Producto: ${entry.key}, ${entry.value} unidades"/>
			</li>
		</c:forEach>
	</ul>
	<br>
</body>
<html>