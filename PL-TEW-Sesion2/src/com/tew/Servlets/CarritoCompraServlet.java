package com.tew.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarritoCompraServlet
 */
@WebServlet("/CarritoCompraServlet")
public class CarritoCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoCompraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: Carrito para la compra").append(request.getContextPath());
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Fruta</TITLE></HEAD>");
		out.println("<BODY>");
		
		//Comprobamos si existe el objeto "carrito" en sesión.
		//Si no existe, lo creamos vacío. Será de tipo HashMap
		@SuppressWarnings("unchecked")
		HashMap <String,Integer> carrito = (HashMap <String,Integer>) request.getSession().getAttribute("carrito");
		if(carrito==null) {
			carrito = new HashMap<String, Integer>();
		}
		
		//Formulario
		out.println("<tr>");
		out.println("<td>");
		out.println("<form action=/PL-TEW-Sesion2/CarritoCompraServlet> ");
		out.println("<SELECT NAME=\"productos\" SIZE=\"1\">");
		out.println("<OPTION VALUE=\"01\">Manzana</OPTION>");
		out.println("<OPTION VALUE=\"02\">Platano</OPTION>");
		out.println("<OPTION VALUE=\"03\">Pera</OPTION>");
		out.println("<OPTION VALUE=\"04\">Naranja</OPTION>");
		out.println("<OPTION VALUE=\"05\">Kiwi</OPTION>");
		out.println("<OPTION VALUE=\"06\">Caqui</OPTION>");
		out.println("<OPTION VALUE=\"07\">Uva</OPTION>");
		out.println("<OPTION VALUE=\"08\">Melocoton</OPTION>");
		out.println("<OPTION VALUE=\"09\">Lechuga</OPTION>");
		out.println("<OPTION VALUE=\"10\">Ajo</OPTION>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("<input type=\"submit\" value=\"Añadir al carrito\">");
		out.println("</td>");
		out.println("</tr>");
		out.println("</SELECT>");
		out.println("</form>");
		
		

		//Añadimos el producto recibido al carrito de la compra (en caso de que no sea nulo!)
		String producto = request.getParameter("productos");

		if(producto != null) {
			Integer cant = carrito.get(producto);
			if(cant==null) {
				carrito.put(producto, new Integer(1));
			}else {
				carrito.put(producto, new Integer(cant+1));
			}
		}
		//Añadimos el carrito a la sesión
		request.getSession().setAttribute("carrito",carrito);
		
		out.println("<h2>Carrito</h2>");
		Set<Entry<String,Integer>> elemento = carrito .entrySet();
		for(Entry<String, Integer> i: elemento) {
			out.println("<br>Producto: " +i.getKey()+", "+i.getValue()+"unidades</br>");
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
