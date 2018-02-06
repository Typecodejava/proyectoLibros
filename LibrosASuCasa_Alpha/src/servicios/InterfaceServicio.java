package servicios;
import java.util.List;

import modelo.ColLibros;
public interface InterfaceServicio {
	
	public ColLibros BuscarTitulo(String string);
	public ColLibros BuscarAutor(String string);
	public ColLibros BuscarLibrosCategoria ();
	public List<String> BuscarCategorias ();
}
