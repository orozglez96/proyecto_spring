package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Libro;
@Service
public class LibroServiceImpl implements LibroService {
	
	static List<Libro> libros=new ArrayList<>(Arrays.asList(new Libro("9780747532743", "Harry Potter", "JK Rowling", 22.2),
			new Libro("5643541353532", "Java Básico", "varios", 30.5),
			new Libro("3765467453453", "Springboot", "Antonio", 15.3),
			new Libro("0032302323023", "Lord of the Rings", "JRR Tolkien", 20.32)
			));


	@Override
	public Libro buscarPorIsbn(String isbn) {
		return libros.stream()
				.filter(l->l.getIsbn().equals(isbn))
				.findFirst()
				.orElse(null);
	}
	
	@Override
	public boolean nuevoLibro(Libro libro) {
	    if (buscarPorIsbn(libro.getIsbn()) != null) {
	        return false; 
	    }
	    libros.add(libro);
	    return true; 
	}

	@Override
	public boolean eliminarLibro(String isbn) {
		if(buscarPorIsbn(isbn)==null) {
			return false;
		}
		
		libros.removeIf(l->l.getIsbn().equals(isbn));
		return true;
	}
	

	
	
	
}
