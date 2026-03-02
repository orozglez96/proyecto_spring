package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Item;
import service.ItemsService;

@Controller
public class ItemsController {
	@Autowired
	ItemsService itemsService;
	
	@GetMapping("consulta")
	public String consultar(Model model) {
		model.addAttribute("cursos", itemsService.cursos());
		return "consulta";
	}
	
	@GetMapping("alumnos")
	public String verAlumnos(Model model, @RequestParam("curso") String curso) {
		// falta algo
		model.addAttribute("alumnos", itemsService.alumnosCurso(curso));
		return "consulta";
	}
	
	@GetMapping("nuevo")
	public String nuevo(Model model,@RequestParam("curso") String curso) {
		model.addAttribute("cursos", itemsService.alumnosCurso(curso));
		return "nuevo";
		
	}
	
	@PostMapping("alta")
	public String alta(Model model, 
			@RequestParam("nombre") String nombre,
			@RequestParam("curso") String curso,
			@RequestParam("curso") String email,
			@RequestParam("email") double nota) {
		Item item=new Item(nombre,curso, email, nota);
		if(itemsService.guardar(item)) {
			model.addAttribute("mensaje", "Alumno añadido correctamente!");
		}else {
			model.addAttribute("mensaje", "Nombre y curso repetido");
		}
		return "mensaje";
	}
	
	
	
	@GetMapping({"/", "goMenu"})
	public String menu() {
		return "menu";
	}
	@GetMapping("goConsulta")
	public String consulta() {
		return "consulta";
	}

	@GetMapping("goNuevo")
	public String nuevo() {
		return "nuevo";
	}
	@GetMapping("goMensaje")
	public String mensaje() {
		return "mensaje";
	}
	
}
