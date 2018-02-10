package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ColLibros;
import modelo.Libro;
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
		InterfaceServicio serv = new Servicio();

		if ((request.getParameter("operacion").equals("busqueda"))) {
			ColLibros libros = new ColLibros();
			ColLibros libros2 = new ColLibros();
			if (request.getParameter("lib_titulo") != null) {
				
				libros = serv.BuscarSemejanza(request.getParameter("lib_titulo"));
				/*
				libros = serv.BuscarTitulo(request.getParameter("lib_titulo"));
				libros2 = serv.BuscarAutor(request.getParameter("lib_titulo"));
				for (Libro libro:libros2.getLibros()){
					if (libros.NoTiene(libro)){
						libros.add(libro);
					}
					
				}
				
				*/
			} 

			// guardo la informacion lib_categoria
			else if (request.getParameter("lib_categoria") != null) {
				libros = serv.BuscarLibrosCategoria(request.getParameter("lib_categoria"));
			}
			request.setAttribute("Listalibros", libros.getLibros());

			// - Ceder control
			List<String> categorias = serv.BuscarCategorias();
			request.setAttribute("categorias", categorias);
			mostrar(request, response, "resultadoBusqueda.jsp");

		} else if (request.getParameter("operacion").equals("mostrarlibro")) {
			Libro libro = serv.BuscarLibro(request.getParameter("idlibro"));
			request.setAttribute("libro", libro);
			List<String> categorias;
			categorias = serv.BuscarCategorias();
			request.setAttribute("categorias", categorias);
			mostrar(request, response, "detalleLibro.jsp");
		}

		System.out.println("--- esta dentro de senredirectu ---");
		List<String> categorias;
		categorias = serv.BuscarCategorias();
		request.setAttribute("categorias", categorias);
		mostrar(request, response, "paginaprincipal.jsp");
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
