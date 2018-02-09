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

/**
 * Servlet implementation class pruebaSession
 */
@WebServlet("/LoginServlet2")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("--- dentro del servlet session 2");

		InterfaceServicio serv = new Servicio();

		try {
			// Vienes de la pagina 2 y vas a la 3

			HttpSession session = request.getSession(false);

			if (session == null) {
				System.out.println("sesion nula");
				response.sendRedirect("login.jsp");
				return;
			} else {
				String nombreUsuario = (String) session.getAttribute("password");

				if (nombreUsuario.equals("admin123")) {
					System.out.println("-------usuarios validado");

					//String name = (String) session.getAttribute("password");

					System.out.println("Hello, " + nombreUsuario + " Welcome to Profile");

					if (request.getParameter("operacion") != null) {
						if (request.getParameter("operacion").equals("alta")) {
							List<String> lista = new ArrayList<>();

							lista.add(request.getParameter("isbn"));
							lista.add(request.getParameter("titulo"));
							lista.add(request.getParameter("descripcion"));
							lista.add(request.getParameter("sinopsis"));
							lista.add(request.getParameter("precio"));
							lista.add(request.getParameter("cantidad"));
							serv.Alta(lista);
						} else if (request.getParameter("operacion").equals("mostraralta")) {
							mostrar(request, response, "altaLibro.jsp");
						}

						else if (request.getParameter("operacion").equals("mostrarupdate")) {
							String idlibros = request.getParameter("idlibro");
							Libro libro = serv.BuscarLibro(idlibros);
							request.setAttribute("libro", libro);
							mostrar(request, response, "UpdateLibro.jsp");
						} else if (request.getParameter("operacion").equals("update")) {
							List<String> lista1;
							lista1 = new ArrayList<>();
							lista1.add(request.getParameter("isbn"));
							lista1.add(request.getParameter("titulo"));
							lista1.add(request.getParameter("descripcion"));
							lista1.add(request.getParameter("sinopsis"));
							lista1.add(request.getParameter("precio"));
							lista1.add(request.getParameter("cantidad"));
							serv.Update(lista1);
						}else if(request.getParameter("operacion").equals("baja")){
							//elimino una fila de la BBDD libro
							String idlibros = request.getParameter("idlibro");
							serv.Baja(idlibros);
						}
					}

					ColLibros libros = serv.MostrarLibrosBBDD();
					request.setAttribute("libros", libros.getLibros());

					mostrar(request, response, "mainBackOff.jsp");
					// --->(IF)COMPROBACION DE LA OPERACION A REALIZAR
					// (LO SIGUIENTE SIEMPRE SUCEDE)
					// BUSCA LIBROS EN LA BASE DE DATOS
					// VA A MAINBACKOFF.JSP
				}
			}

		} catch (

		Exception e) {
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
