package servicios;

import modelo.ColLibros;
import modelo.Libro;

import java.util.List;
import java.util.Set;

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
		
		Libro libro = new Libro(0, list.get(0), list.get(1), list.get(2), list.get(3), Double.parseDouble(list.get(4)),
				Integer.parseInt(list.get(5)), list.get(6));
		
		datos.Alta(libro);
	}

	public void Update(List<String> list) {
		Libro libro = new Libro(Integer.parseInt(list.get(0)), list.get(1), list.get(2), list.get(3), list.get(4),
				Double.parseDouble(list.get(5)), Integer.parseInt(list.get(6)), list.get(7));
		datos.Update(libro);
		
	}

	public void Baja( String idLibro){
		datos.Baja(idLibro);	
	}
	
	public Libro BuscarLibro (String idLibros){
		Libro libro;
		ColLibros collibro=datos.BuscarLibro(idLibros);
		libro=collibro.get(0);
		return libro;
	}
	
	public ColLibros BuscarSemejanza (String string){
		return datos.BuscarSemejanza(string);
	}
	
	public boolean ComprobarAdmin (String user, String psswd){
		return datos.ComprobarAdmin(user, psswd);
	}
	
	//devuelve toda la coleccion de libros en la BBDD
	public ColLibros MostrarLibrosBBDD(){
		return datos.ListaLibrosBBDD();
		}



}
