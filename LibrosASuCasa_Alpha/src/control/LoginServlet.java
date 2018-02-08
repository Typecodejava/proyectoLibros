package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("--- dentro del servlet Login");
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
				//--->(IF)COMPROBACION DE LA OPERACION A REALIZAR
				//(LO SIGUIENTE SIEMPRE SUCEDE)
				//BUSCA LIBROS EN LA BASE DE DATOS
				//VA A MAINBACKOFF.JSP
				response.sendRedirect("AdminMenu");
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

}
