package servicios;
import modelo.ColLibros;
public interface InterfaceServicio {
	
	public ColLibros BuscarTitulo(String string);
	public ColLibros BuscarAutor(String string);
}
