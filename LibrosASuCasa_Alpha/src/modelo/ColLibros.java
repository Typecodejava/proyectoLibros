package modelo;

import java.util.ArrayList;

import java.util.List;


public class ColLibros {
	private List<Libro> libros;
	

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	
	public ColLibros() {
		this.libros = new ArrayList<>();
	}
	
	public void add(Libro libro){
		this.libros.add(libro);
	}
	
	
	
	
	
	
	
}
