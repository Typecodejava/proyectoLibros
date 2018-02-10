package datos;

import modelo.ColLibros;
import modelo.Libro;
import util.ConectorBBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Datos implements InterfaceDatos {

	private static final String BDDNAME = "librosasucasa";

	public void Conectar3(String query) {
		Statement st = null;
		try {
			ConectorBBDD con = new ConectorBBDD();
			st = con.getConnection().createStatement();
			int i = st.executeUpdate(query);
			con.getConnection().close();
		} catch (SQLException ex) {
			Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public List<String> Conectar2(String query) {
		Statement st = null;
		ResultSet rs = null;
		List<String> misCategorias = new ArrayList<>();
		try {
			ConectorBBDD con = new ConectorBBDD();
			st = con.getConnection().createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				misCategorias.add(rs.getString(1));
			}
			con.getConnection().close();
		} catch (SQLException ex) {
			Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
		}

		return misCategorias;
	}

	public ColLibros Conectar(String query) {
		Statement st = null;
		ColLibros librosDeBusqueda = new ColLibros();
		try {
			ConectorBBDD con = new ConectorBBDD();
			st = con.getConnection().createStatement();
			librosDeBusqueda = CrearColeccion(query, st);
			con.getConnection().close();
		} catch (SQLException ex) {
			Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
		}
		return librosDeBusqueda;
	}

	public ColLibros BuscarAutor(String busqueda) {

		
		String query = "SELECT idLibros, isbn, titulo, descripcion, sinopsis, precio, cantidad, imagen, nombre FROM "
				+ BDDNAME + ".libros, " + BDDNAME + ".autores WHERE autores.idautores = libros.idautores AND autores.nombre LIKE '%"
				+ busqueda + "%' or apellido LIKE '%" + busqueda + "%';";

		return this.Conectar(query);

	}

	// metodo que llama BD y devuelve un libro
	public ColLibros BuscarLibro(String busqueda) {

		// String query ="SELECT idLibros, isbn, titulo, descripcion, sinopsis,
		// precio, cantidad, imagen, nombre FROM "+BDDNAME+".libros,
		// "+BDDNAME+".autores "
		// + "WHERE libros.idLibros LIKE '%"+busqueda+"% AND autores.idautores =
		// libros.idautores';";
		String query = "SELECT idLibros, isbn, titulo, descripcion, sinopsis, precio, cantidad, imagen, nombre FROM libros, autores WHERE libros.idLibros LIKE'"
				+ busqueda + "'  AND autores.idautores = libros.idautores;";
		return this.Conectar(query);

	}

	public ColLibros CrearColeccion(String query, Statement st) {
		ResultSet rs = null;
		ColLibros librosDeBusqueda = new ColLibros();
		try {
			rs = st.executeQuery(query);
			while (rs.next()) {
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

		
		String query = "SELECT idLibros, isbn, titulo, descripcion, sinopsis, precio, cantidad, imagen, nombre FROM "
				+ BDDNAME + ".libros, " + BDDNAME
				+ ".autores WHERE libros.idautores = autores.idautores AND titulo LIKE '%" + busqueda + "%';";

		return this.Conectar(query);

	}

	public List<String> BuscarCategorias() {

		String query = "SELECT nombre FROM categorias;";

		return this.Conectar2(query);
	}

	/** Metodo para busqueda de Libros por categoria */

	public ColLibros BuscarLibrosCategoria(String busqueda) {

		String query = "SELECT idLibros, isbn, titulo, libros.descripcion, sinopsis, precio, cantidad, imagen, autores.nombre FROM "
				+ BDDNAME + ".libros, " + BDDNAME + ".categorias, " + BDDNAME
				+ ".autores WHERE categorias.nombre like '%" + busqueda
				+ "%' AND libros.idCategorias=categorias.idCategorias AND autores.idautores = libros.idautores;";
		return this.Conectar(query);
	}
	
	public ColLibros BuscarSemejanza (String busqueda){
		
		String query = "SELECT idLibros, isbn, titulo, libros.descripcion, sinopsis, precio, cantidad, imagen, autores.nombre "
				+ "FROM " + BDDNAME + ".libros, " + BDDNAME + ".autores "
				+ "WHERE ( titulo LIKE '%"+busqueda+"%' OR autores.nombre LIKE '%"+busqueda+"%' OR autores.apellido LIKE '%"+busqueda+"%' ) "
						+ "AND libros.idautores = autores.idautores;";
		
		return this.Conectar(query);
	}

	public void Alta(Libro libro) {
		String q = "INSERT INTO libros VALUES (NULL ,'" + libro.getIsbn() + "','" + libro.getTitulo() + "','"
				+ libro.getDescripcion() + "','" + libro.getSinopsis() + "','" + libro.getImagen() + "','"
				+ libro.getCantidad() + "','" + libro.getPrecio() + "',2	,NULL);";
		this.Conectar3(q);
	}

	public void Update(Libro libro) {
		String q = "UPDATE libros SET isbn ='" + libro.getIsbn() + "',titulo ='" + libro.getTitulo()
				+ "',descripcion ='" + libro.getDescripcion() + "',sinopsis ='" + libro.getSinopsis() + "',imagen ='"
				+ libro.getImagen() + "',cantidad ='" + libro.getCantidad() + "',precio ='" + libro.getPrecio()
				+ "' WHERE idLibros='" + libro.getIdLibro() + "';";
		this.Conectar3(q);
	}

	public void Baja(String idlibro) {
		String q = "delete from libros where idLibros ='" + idlibro + "'";
		this.Conectar3(q);
	}

	@Override
	public ColLibros ListaLibrosBBDD() {

		String query = "SELECT idLibros, isbn, titulo, descripcion, sinopsis, precio, cantidad, imagen, nombre FROM "
				+ BDDNAME + ".libros, " + BDDNAME + ".autores WHERE libros.idautores = autores.idautores;";

		return this.Conectar(query);
	}

}
