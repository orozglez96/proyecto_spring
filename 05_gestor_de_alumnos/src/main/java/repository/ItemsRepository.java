package repository;

import java.util.List;

import model.Item;

public interface ItemsRepository {
	void save(Item item);
	List<Item> findByCurso(String curso);
	Item findByNombreAndCurso(String nombre, String curso);
	List<String> findAllCursos();
}

