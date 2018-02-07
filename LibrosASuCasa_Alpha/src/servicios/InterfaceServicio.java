package servicios;
import java.util.List;

import modelo.ColLibros;
import modelo.Libro;
public interface InterfaceServicio {
	
	public ColLibros BuscarTitulo(String string);
	public ColLibros BuscarAutor(String string);
	public ColLibros BuscarLibrosCategoria (String string);
	public List<String> BuscarCategorias ();
	public void Alta(List<String> lista);
	public void Update(List<String> lista);
	public void Baja( String idLibro);
}
