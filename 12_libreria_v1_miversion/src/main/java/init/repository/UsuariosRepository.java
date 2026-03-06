package init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import init.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
	Usuario findFirstByUsuarioAndPassword(String usuario, String password);
	
	Usuario findFirstByUsuarioAndEmail(String usuario, String email);
	
	@Query("select l.tema from libros l")
	List<String> findAllTemas();
}
