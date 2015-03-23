package com.certificatic.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.certificatic.practica1.ejb.SaludaEJB;

/**
 * Servlet implementation class SaludaServlet
 */
@WebServlet("/SaludaServlet")
public class SaludaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	SaludaEJB saludaEJB; 
       
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String saludo=request.getParameter("nombre");
		request.setAttribute("saludoHola", "Hola "+saludo+"!!");
		request.getRequestDispatcher("salida.jsp").forward(request, response);
	}


}
