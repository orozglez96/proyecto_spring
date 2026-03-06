package init.service;

import java.util.List;

import init.model.Item;

public interface ItemsService {
	List<Item> buscarPorTematica(String tematica);
	boolean nuevoItem(Item item);
}
