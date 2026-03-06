package init.service;

import java.util.List;

import init.model.Cliente;

public interface ClientesService {
	
	Cliente autenticarUsuario(String usuario, String password);
	boolean guardar(Cliente cliente);
}
