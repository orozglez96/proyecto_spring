package init.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.mappers.Mapeador;
import init.dtos.LibroDto;
import init.dtos.TemaDto;
import init.repository.LibrosRepository;
import init.repository.TemasRepository;
@Service
public class LibrosServiceImpl implements LibrosService {
	@Autowired
	TemasRepository temasRepository;
	@Autowired
	LibrosRepository librosRepository;
	@Autowired
	Mapeador mapeador;
	@Override
	public List<TemaDto> temas() {
		return temasRepository.findAll() //List<Tema>
				.stream() //Stream<tema>
				.map(t->mapeador.temaEntityToDto(t))
				.toList();
	}
	
	@Override
	public List<LibroDto> librosTema(int idTema) {
		if(idTema==0) {
			return librosRepository.findAll()
					.stream() //Stream<tema>
					.map(l->mapeador.libroEntityToDto(l))
					.toList();
		}
		return librosRepository.findByTemaRelacionadoIdTema(idTema)
				.stream() //Stream<tema>
				.map(l->mapeador.libroEntityToDto(l))
				.toList();
	}
	@Override
	public LibroDto buscarLibroPorIsbn(int isbn) {
		return librosRepository.findById(isbn)
				.map(l->mapeador.libroEntityToDto(l))
				.orElse(null); //Optional<Libro>
	}
}
