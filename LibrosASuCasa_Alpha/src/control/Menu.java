package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ColLibros;
import servicios.Servicio;
import servicios.InterfaceServicio;


@WebServlet("/Menu")
public class Menu extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("--- dentro del servlet Menu ---");
		InterfaceServicio serv=new Servicio();
		ColLibros libros = new ColLibros ();
		
		if ( request.getParameter("lib_titulo") != null ){
			// Paso 01
			// - Recoger informacion
			// - Guardarla en objeto
			libros=serv.BuscarTitulo(request.getParameter("lib_titulo"));
		}
		if ( request.getParameter("lib_autor") != null ){
			// Paso 01
			// - Recoger informacion
			// - Guardarla en objeto
			libros=serv.BuscarAutor(request.getParameter("lib_autor"));
		}
		
		try {


			//String titulo=request.getParameter("lib_titulo");
			//request.setAttribute("titulo", titulo);
	/*
			 * //-------------------------------------- // Paso 2 // - Hablar
			 * con el "Experto" y buscar en BBDDD // - Recoger información // -
			 * Guardarla MenuDia menu = new DAO().consultarMenuDia(); //DAO,
			 * data access object request.setAttribute("menuDia", menu); //se
			 * guarda en request y se llama menuDia
			 */
			// ---------Buscar en BBDD-----------//
			request.setAttribute("Listalibros", libros.getLibros());

			// --------------------------------------
			// Paso 3
			// - Ceder control
			mostrarBusquedaTitulo(request, response);

		} catch (Exception e) {
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

	protected void mostrarBusquedaTitulo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("resultadoBusqueda.jsp");
		view.forward(request, response);

	}

}
