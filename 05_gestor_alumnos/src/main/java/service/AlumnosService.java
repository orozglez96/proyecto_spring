package service;

import java.util.List;

import model.Alumno;

public interface AlumnosService {
	boolean guardar(Alumno alumno);
	void eliminar(int idAlumno);
	List<Alumno> alumnosCurso(String curso);
	List<String> cursos();
}
