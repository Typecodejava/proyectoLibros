package servicios;
import modelo.ColLibros;
import datos.*;
public class Servicio implements InterfaceServicio{
	
	private InterfaceDatos datos=new Datos();
	
	public ColLibros BuscarTitulo(String string){
		return datos.BuscarTitulo(string);
	}

	public ColLibros BuscarAutor(String string){
		return datos.BuscarAutor(string);
}}
