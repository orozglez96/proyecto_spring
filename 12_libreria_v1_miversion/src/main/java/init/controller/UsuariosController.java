package init.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import init.model.Usuario;
import init.service.UsuariosService;

@Controller
public class UsuariosController {
	@Autowired
	UsuariosService usuariosService;
	@PostMapping("/alta")
	public String guardar(Model model, 
			@ModelAttribute Usuario usuario) {
		if(usuariosService.guardar(usuario)) {
			model.addAttribute("mensaje", "Usuario creado correctamente");
		}else {
			model.addAttribute("mensaje", "Usuario y email ya existe");
		}
		return "mensaje";
	}
	@GetMapping("login")
	public String login(Model model, @RequestParam("usuario") String usuario,@RequestParam("password") String password) {
		if(usuariosService.usuarioPwd(usuario, password)) {
			model.addAttribute("mensaje", "Usuario valido");
		}else {
			model.addAttribute("mensaje", "Usuario no existente");
		}
		return "mensaje";
	}
	
	@GetMapping({"/", "goLogin"})
	public String goLogin() {
		return "login";
	}
	@GetMapping("goRegistro")
	public String registro() {
		return "registro";
	}
	@GetMapping("goLibros")
	public String libros() {
		return "libros";
	}

}
