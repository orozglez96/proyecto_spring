package service;

import model.Libro;

public interface LibroService {
	boolean nuevoLibro(Libro libro);
	Libro buscarPorIsbn(String isbn);
	boolean eliminarLibro(String isbn);
}
