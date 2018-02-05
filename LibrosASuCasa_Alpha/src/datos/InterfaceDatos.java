package datos;

import modelo.ColLibros;

public interface InterfaceDatos {
	
	public ColLibros BuscarTitulo (String string);
	public ColLibros BuscarAutor (String string);
	
}
