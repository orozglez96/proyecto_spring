package init.service;

import java.util.List;

import init.model.Usuario;

public interface UsuariosService {
	boolean guardar(Usuario usuario);
	boolean usuarioPwd(String usuario, String password);
	boolean usuarioEmail(String usuario, String email);
	List<String> temas();
}
