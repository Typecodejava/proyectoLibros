package servicios;

import modelo.ColLibros;
import modelo.Libro;

import java.util.List;

import datos.*;

public class Servicio implements InterfaceServicio {

	private InterfaceDatos datos = new Datos();

	public ColLibros BuscarTitulo(String string) {
		return datos.BuscarTitulo(string);
	}

	public ColLibros BuscarAutor(String string) {
		return datos.BuscarAutor(string);
	}

	public ColLibros BuscarLibrosCategoria(String string) {
		return datos.BuscarLibrosCategoria(string);
	}

	public List<String> BuscarCategorias() {
		return datos.BuscarCategorias();
	}

	public void Alta(List<String> list) {
		Libro libro = new Libro(Integer.parseInt(list.get(0)), list.get(1), list.get(2), list.get(3), list.get(4),
				Double.parseDouble(list.get(5)), Integer.parseInt(list.get(6)));
		datos.Alta(libro);
	}

	public void Update(List<String> list) {
		Libro libro = new Libro(Integer.parseInt(list.get(0)), list.get(1), list.get(2), list.get(3), list.get(4),
				Double.parseDouble(list.get(5)), Integer.parseInt(list.get(6)));
		datos.Update(libro);
	}

	public void Baja(String idLibro) {
		datos.Baja(idLibro);

	}
	
	//devuelve toda la coleccion de libros en la BBDD
	public ColLibros MostrarLibrosBBDD(){
		return datos.ListaLibrosBBDD();};


}
