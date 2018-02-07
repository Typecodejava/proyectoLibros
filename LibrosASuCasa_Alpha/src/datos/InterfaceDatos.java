package datos;

import java.util.List;

import modelo.ColLibros;
import modelo.Libro;

public interface InterfaceDatos {
	
	public ColLibros BuscarTitulo (String string);
	public ColLibros BuscarAutor (String string);
	public ColLibros BuscarLibrosCategoria (String string);
	public List<String> BuscarCategorias ();
	public void Alta(Libro libro);
	public void Update(Libro libro);
	public void Baja( String idLibro);

	
}
