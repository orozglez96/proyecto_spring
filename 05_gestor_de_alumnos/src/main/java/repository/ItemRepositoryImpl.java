package repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import model.Item;

@Repository
public class ItemRepositoryImpl implements ItemsRepository {
	@PersistenceContext
	EntityManager eManager;
	@Transactional
	@Override
	public void save(Item item) {
		eManager.persist(item);
	}

	@Override
	public List<Item> findByCurso(String curso) {
		String jpql="select i from Item i where i.curso=?1";
		TypedQuery<Item> query=eManager.createQuery(jpql, Item.class);
		query.setParameter(1, curso);
		List<Item> resultado=query.getResultList();
		return resultado.size()>0?resultado:null;
	}


	@Override
	public Item findByNombreAndCurso(String nombre, String curso) {
		String jpql = "SELECT i FROM Item i WHERE i.nombre = ?1 AND i.curso = ?2";
		TypedQuery<Item> query=eManager.createQuery(jpql, Item.class);
		query.setParameter(1, nombre);
		query.setParameter(2, curso);
		List<Item> resultado=query.getResultList();
		return resultado.size()>0?resultado.get(0):null;
	}
	

	@Override
	public List<String> findAllCursos() {
		String jpql="select distinct(i.curso) from Item i";
		TypedQuery<String> query=eManager.createQuery(jpql, String.class);
		return query.getResultList();
	}
	


}
