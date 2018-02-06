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

public class Datos implements InterfaceDatos {
	
	private static final String BDDNAME = "librosasucasa";
	private static final String NOSSL = "?autoReconnect=true&useSSL=false";
	
	public Statement conectar(){
		Connection conex = null;
		Statement st = null;
		String driverClassName = "com.mysql.jdbc.Driver";
		String driverUrl = "jdbc:mysql://localhost/"+BDDNAME+NOSSL;
		String user = "root";
		String paswd = "1111";
		try{
			Class.forName(driverClassName);
			conex = DriverManager.getConnection(driverUrl, user, paswd);
			
			st = conex.createStatement();
		}catch (ClassNotFoundException e){
			System.out.println("ClassNotFound");
			
		}catch (SQLException e){
			System.out.println("SQLException");
		}
		return st;
	}

	
	public ColLibros BuscarAutor(String busqueda){
		String query ="SELECT * FROM "+BDDNAME+".libros WHERE libros.idautores IN (SELECT autores.idautores FROM "+BDDNAME+".autores WHERE nombre LIKE '%"+busqueda+"%' or apellido LIKE '%"+busqueda+"%');";

		return this.CrearColeccion (query);
		
	}
	
	public ColLibros CrearColeccion (String query){
		Statement st = null;
		ResultSet rs = null;
		ColLibros librosDeBusqueda = new ColLibros ();
		try{
			st = conectar();
			rs = st.executeQuery(query);
			

			while ( rs.next() ){
				Libro nuevoLibro = new Libro ( rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getInt(7) );
				librosDeBusqueda.add(nuevoLibro);
			} 
		}
			
		catch (SQLException e){
			System.out.println("SQLException");
		}
		return librosDeBusqueda;
	}
		
	public ColLibros BuscarTitulo (String busqueda){
		
		
		String query = "SELECT idLibros, isbn, titulo, descripcion, sinopsis, cantidad, precio FROM "+BDDNAME+".libros WHERE titulo LIKE '%"+busqueda+"%';";
		
		
		return this.CrearColeccion (query);
		
	}
	
	public List<String> BuscarCategorias (){
		List<String> misCategorias = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		String query = "SELECT nombre FROM categorias;";
		
		try{
			st = conectar();
			rs = st.executeQuery(query);
			
			while (rs.next()){
				misCategorias.add(rs.getString(1));
			}
		}
		catch (SQLException e){
			System.out.println("SQLException");
		}
		return misCategorias;
	}

	/** Metodo para busqueda de Libros por categoria*/
	
	public ColLibros BuscarLibrosCategoria (String busqueda){
		
		String query = "SELECT idLibros, isbn, titulo, libros.descripcion, sinopsis, cantidad, precio FROM "+BDDNAME+".libros, "+BDDNAME+".categorias WHERE categorias.nombre like '%"+busqueda+"%' AND libros.idCategorias=categorias.idCategorias;";
		return this.CrearColeccion (query);
	}


}
