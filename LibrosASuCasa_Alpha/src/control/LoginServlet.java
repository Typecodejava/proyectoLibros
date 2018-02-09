package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.ColLibros;
import modelo.Libro;
import servicios.InterfaceServicio;
import servicios.Servicio;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("--- dentro del servlet Login");

		InterfaceServicio serv = new Servicio();

		try {

			
			
			System.out.println("consigo sesion false"+request.getSession());
			// Paso 01
			// - Recoger informacion
			// - Guardarla en objeto

			String name = request.getParameter("name");
			String password = request.getParameter("password");

			if (password.equals("admin123")) {
				// inicio sesion como admin

				HttpSession miSesion = request.getSession(true);
				miSesion.setAttribute("password", password);
			

				ColLibros libros = serv.MostrarLibrosBBDD();
				request.setAttribute("libros", libros.getLibros());

				mostrar(request, response, "mainBackOff.jsp");
			} else {
				String error = "Error, has introducido mal la Contraseña o Usuario!! Vuelve a intentarlo...";
				request.setAttribute("Error", error);
				mostrar(request, response, "login.jsp");
				
			}
		}catch(

	Exception e)
	{
		System.out.println("--------------------  FALLO  -----------------------------");
		System.out.println(e.getMessage());
		System.out.println("----------------------------------------------------------");
	}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

	protected void mostrar(HttpServletRequest request, HttpServletResponse response, String pagina)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher(pagina);
		view.forward(request, response);
	}
}
