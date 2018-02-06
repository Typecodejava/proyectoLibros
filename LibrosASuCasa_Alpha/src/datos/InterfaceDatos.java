package datos;

import java.util.List;

import modelo.ColLibros;

public interface InterfaceDatos {
	
	public ColLibros BuscarTitulo (String string);
	public ColLibros BuscarAutor (String string);
	public ColLibros BuscarLibrosCategorias ();
	public List<String> BuscarCategorias ();

	
}
