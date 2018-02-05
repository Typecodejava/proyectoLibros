package datos;
import modelo.ColLibros;
import modelo.Libro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Datos implements InterfaceDatos {
	
	private static final String BDDNAME = "librosasucasa";
	private static final String NOSSL = "?autoReconnect=true&useSSL=false";
	
	public ColLibros BuscarTitulo (String busqueda){
		
		Connection conex = null;
		Statement st = null;
		ResultSet rs = null;
		
		String driverClassName = "com.mysql.jdbc.Driver";
		String driverUrl = "jdbc:mysql://localhost/"+BDDNAME+NOSSL;
		String user = "root";
		String paswd = "1111";
		ColLibros librosDeBusqueda = new ColLibros ();
		String query = "SELECT idLibros, isbn, titulo, descripcion, sinopsis, precio, cantidad FROM "+BDDNAME+".libros WHERE titulo LIKE '%"+busqueda+"%';";

		try{
			Class.forName(driverClassName);
			conex = DriverManager.getConnection(driverUrl, user, paswd);
			
			st = conex.createStatement();
			rs = st.executeQuery(query);
			

			while ( rs.next() ){
				//System.out.println("aqui entra");
				//System.out.println(rs.getInt(1)+" "+rs.getString(2));
				Libro nuevoLibro = new Libro ( rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getInt(7) );
				//System.out.println(nuevoLibro.getTitulo());
				//System.out.println(rs.getString(2)+rs.getString(3) );
				librosDeBusqueda.add(nuevoLibro);
			} 
		}
		catch (ClassNotFoundException e){
			System.out.println("ClassNotFound");
			
		}catch (SQLException e){
			System.out.println("SQLException");
			System.out.println(e.getErrorCode()+" "+e.getMessage());
		}
		return librosDeBusqueda;
		
	}

}
