package repository;

import java.util.List;

import model.Alumno;

public interface AlumnosRepository {
	void save(Alumno alumno);
	void eliminar(int idAlumno);
	List<Alumno> findByCurso(String curso);
	Alumno findByNombreAndCurso(String nombre, String curso);
	List<String> findAllCursos();
}
