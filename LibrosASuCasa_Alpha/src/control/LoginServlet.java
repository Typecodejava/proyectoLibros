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

			// Paso 01
			// - Recoger informacion
			// - Guardarla en objeto

			String name = request.getParameter("name");
			String password = request.getParameter("password");

			if (password.equals("admin123")) {
				// inicio sesion como admin
				HttpSession session = request.getSession();
				session.setAttribute("name", name); // en vez de name, se manda
													// los datos de
													// usuario.admin
				
			
			if(request.getParameter("operacion").equals("alta")){
				List<String> lista = new ArrayList<>(); 
				
				lista.add(request.getParameter("isbn"));
				lista.add(request.getParameter("titulo"));
				lista.add(request.getParameter("descripcion"));
				lista.add(request.getParameter("sinopsis"));
				lista.add(request.getParameter("precio"));
				lista.add(request.getParameter("cantidad"));
				serv.Alta(lista);
			}else if(request.getParameter("operacion").equals("mostraralta")){
				mostrar( request,  response, "altaLibro.jsp");
			}
			
			else if(request.getParameter("operacion").equals("mostrarupdate"))	{
				String idlibros = request.getParameter("idlibro");
				Libro libro=serv.BuscarLibro(idlibros);
				request.setAttribute("libro", libro);
				mostrar( request,  response, "UpdateLibro.jsp");
			}
			else if (request.getParameter("operacion").equals("update")){
				List<String> lista1;
				lista1 = new ArrayList<>(); 
				lista1.add(request.getParameter("isbn"));
				lista1.add(request.getParameter("titulo"));
				lista1.add(request.getParameter("descripcion"));
				lista1.add(request.getParameter("sinopsis"));
				lista1.add(request.getParameter("precio"));
				lista1.add(request.getParameter("cantidad"));
				serv.Update(lista1);
			}
			
			ColLibros libros =serv.MostrarLibrosBBDD();
			
			
			mostrar( request,  response, "mainBackOff.jsp");
				//--->(IF)COMPROBACION DE LA OPERACION A REALIZAR
				//(LO SIGUIENTE SIEMPRE SUCEDE)
				//BUSCA LIBROS EN LA BASE DE DATOS
				//VA A MAINBACKOFF.JSP
			} else {

				String mensaje = "error loco, has metido mal la contra!!";
				request.setAttribute("Error", mensaje);

				request.getRequestDispatcher("login.jsp").include(request, response);

			}

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
	protected void mostrar(HttpServletRequest request, HttpServletResponse response, String pagina)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher(pagina);
		view.forward(request, response);
	}
}
