package init.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import init.model.Usuario;
import init.repository.UsuariosRepository;

@Service
public class UsuariosServiceImpl implements UsuariosService {
	@Autowired
	UsuariosRepository usuariosRepository;
	@Override
	public boolean guardar(Usuario usuario) {
		if(usuariosRepository.findFirstByUsuarioAndEmail(usuario.getUsuario(), usuario.getEmail())==null) {
			usuariosRepository.save(usuario);
			return true;
		}
		return false;
	}
	@Override
	public boolean usuarioEmail(String usuario, String email) {
		if(usuariosRepository.findFirstByUsuarioAndEmail(usuario, email)!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean usuarioPwd(String usuario, String password) {
		if(usuariosRepository.findFirstByUsuarioAndPassword(usuario, password)!=null) {
			return true;
		}
		return false;
	}
	@Override
	public List<String> temas() {
		return usuariosRepository.findAllTemas();
	}

}
