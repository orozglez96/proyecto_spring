package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Item;
import repository.ItemsRepository;

@Service
public class ItemsServiceImpl implements ItemsService {
	@Autowired
	ItemsRepository itemsRepository;
	@Override
	public boolean guardar(Item item) {
		if(itemsRepository.findByNombreAndCurso(item.getNombre(), item.getCurso())==null) {
			itemsRepository.save(item);
			return true;
		}

		return false;
	}

	@Override
	public List<Item> alumnosCurso(String curso) {
		return itemsRepository.findByCurso(curso);
	}

	@Override
	public List<String> cursos() {
		return itemsRepository.findAllCursos();
	}

}
