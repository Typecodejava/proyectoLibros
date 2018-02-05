package servicios;
import modelo.ColLibros;
import datos.*;
public class Servicio implements InterfaceServicio{
	
	private InterfaceDatos datos=new Datos();
	
	public ColLibros BuscarTitulo(String busqueda){
		return datos.BuscarTitulo(busqueda);
	}
}
