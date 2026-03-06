package init.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import init.model.Alumno;

public interface AlumnosRepository extends JpaRepository<Alumno, Integer> {
	List<Alumno> findByCurso(String curso);
	
	Alumno findFirstByNombreAndCurso(String nombre, String curso);
	
	
	@Query("select distinct(a.curso) from Alumno a")
	List<String> findAllCursos();
	
	@Query(value="select AVG(nota) from alumnos a where curso=?", nativeQuery = true)
	double findAllCursos(String curso);
}
