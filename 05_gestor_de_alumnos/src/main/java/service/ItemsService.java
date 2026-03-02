package service;

import java.util.List;

import model.Item;

public interface ItemsService {
	boolean guardar(Item item);
	List<Item> alumnosCurso(String curso);
	List<String> cursos();
}
