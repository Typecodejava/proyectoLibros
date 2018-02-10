package modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ColLibros {
	private Set<Libro> libros;
	

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}
	
	
	public ColLibros() {
		this.libros = new HashSet<>();
	}
	
	public void add(Libro libro){
		
		this.libros.add(libro);
			
	}
	
	public Libro get(int i){
		int cont=0;
		for (Libro libro: this.libros){
			if (cont==i){
				return libro;
			}
			cont++;
			
		}
		return null;
	}

	public boolean NoTiene(Libro libro) {
		boolean a=true;
		for (Libro lib:this.getLibros()){
			if (lib.getTitulo().equals(libro.getTitulo())){
				a=false;
			}
		}
		return a;
	}
	
	
	
	
	
	
	
}
