package datos;

import modelo.ColLibros;
import modelo.Libro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Datos implements InterfaceDatos {

	private static final String BDDNAME = "librosasucasa";
	private static final String NOSSL = "?autoReconnect=true&useSSL=false";

	public Statement conectar() {
		Connection conex = null;
		Statement st = null;
		String driverClassName = "com.mysql.jdbc.Driver";
		String driverUrl = "jdbc:mysql://localhost/" + BDDNAME + NOSSL;
		String user = "root";
		String paswd = "1111";
		try {
			Class.forName(driverClassName);
			conex = DriverManager.getConnection(driverUrl, user, paswd);

			st = conex.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFound");

		} catch (SQLException e) {
			System.out.println("SQLException en el conectar");

		}
		return st;
	}

	public ColLibros BuscarAutor(String busqueda) {
		String query = "SELECT idLibros, isbn, titulo, descripcion, sinopsis, precio, cantidad, imagen, nombre FROM " + BDDNAME
				+ ".libros, "+BDDNAME+".autores WHERE autores.idautores = libros.idautores AND LIKE '%" + busqueda + "%' or apellido LIKE '%" + busqueda + "%');";

		return this.CrearColeccion(query);

	}

	
	//metodo que llama BD y devuelve un libro
	public ColLibros BuscarLibro(String busqueda){

		//String query ="SELECT idLibros, isbn, titulo, descripcion, sinopsis, precio, cantidad, imagen, nombre FROM "+BDDNAME+".libros, "+BDDNAME+".autores "
		//		+ "WHERE libros.idLibros LIKE '%"+busqueda+"% AND autores.idautores = libros.idautores';";  
		String query="SELECT idLibros, isbn, titulo, descripcion, sinopsis, precio, cantidad, imagen, nombre FROM libros, autores WHERE libros.idLibros LIKE'"+busqueda+"'  AND autores.idautores = libros.idautores;";
		return this.CrearColeccion (query);
		
	}
	


	public ColLibros CrearColeccion(String query) {
		Statement st = null;
		ResultSet rs = null;
		ColLibros librosDeBusqueda = new ColLibros();

		try {
			st = conectar();

			rs = st.executeQuery(query);

			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getDouble(6));
				System.out.println(rs.getInt(7));
				System.out.println(rs.getString(8));
				System.out.println(rs.getString(9));
				Libro nuevoLibro = new Libro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getDouble(6), rs.getInt(7), rs.getString(8), rs.getString(9));
				
				
				
				librosDeBusqueda.add(nuevoLibro);
			}
		}

		catch (SQLException e) {
			System.out.println("SQLException en crear coleccion");
		}
		return librosDeBusqueda;
	}

	public ColLibros BuscarTitulo(String busqueda) {

		String query = "SELECT idLibros, isbn, titulo, descripcion, sinopsis, precio, cantidad, imagen, nombre FROM " + BDDNAME
				+ ".libros, " + BDDNAME + ".autores WHERE libros.idautores = autores.idautores AND titulo LIKE '%" + busqueda + "%';";

		return this.CrearColeccion(query);

	}

	public List<String> BuscarCategorias() {
		List<String> misCategorias = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		String query = "SELECT nombre FROM categorias;";

		try {
			st = conectar();
			rs = st.executeQuery(query);

			while (rs.next()) {
				misCategorias.add(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println("SQLException en buscar categorias");
		}
		return misCategorias;
	}

	/** Metodo para busqueda de Libros por categoria */

	public ColLibros BuscarLibrosCategoria(String busqueda) {

		String query = "SELECT idLibros, isbn, titulo, libros.descripcion, sinopsis, precio, cantidad, imagen, autores.nombre FROM " + BDDNAME
				+ ".libros, " + BDDNAME + ".categorias, " + BDDNAME + ".autores WHERE categorias.nombre like '%" + busqueda
				+ "%' AND libros.idCategorias=categorias.idCategorias AND autores.idautores = libros.idautores;";
		return this.CrearColeccion(query);
	}

	public void Alta(Libro libro) {
		Statement st = null;
		try {

			st = conectar();
			String q = "INSERT INTO `libros` VALUES ('" + libro.getIdLibro() + "','" + libro.getIsbn() + "','"
					+ libro.getTitulo() + "','" + libro.getDescripcion() + "','" + libro.getSinopsis() + "','"
					+ libro.getImagen() + "','" + libro.getCantidad() + "','" + libro.getPrecio() + "')";
			int i = st.executeUpdate(q);

		} catch (SQLException ex) {
			System.out.println("SQLException");
		}
	}

	public void Update(Libro libro) {
		Statement st = null;
		try {
			st = conectar();
			String q = "UPDATE `libros` SET isbn ='" + libro.getIsbn() + "',titulo ='" + libro.getTitulo()
					+ "',descripcion'" + libro.getDescripcion() + "',sinopsis'" + libro.getSinopsis() + "',imagen'"
					+ libro.getImagen() + "',cantidad'" + libro.getCantidad() + "',precio'" + libro.getPrecio()
					+ "' WHERE code='" + libro.getIdLibro() + "'";
			System.out.println(q);
			int i = st.executeUpdate(q);

		} catch (SQLException ex) {
			Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void Baja(String idlibro) {
		Statement st = null;
		try {
			System.out.println("--- Dando de baja el codigo " + idlibro);
			st = conectar();
			String q = "delete from libros where idLibros ='" + idlibro + "'";

			int i = st.executeUpdate(q);
			System.out.println(q + i);

		} catch (SQLException ex) {
			Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
		}

	}	
	
	@Override
	public ColLibros ListaLibrosBBDD() {

		String query = "SELECT idLibros, isbn, titulo, descripcion, sinopsis, precio, cantidad, imagen, nombre FROM " + BDDNAME
				+ ".libros, " + BDDNAME + ".autores WHERE libros.idautores = autores.idautores;";

		return this.CrearColeccion(query);
	}
	
	
	
	

}
