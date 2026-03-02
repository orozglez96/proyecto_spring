package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Libro;
import service.LibroService;

@Controller
public class LibrosController {
	@Autowired
	LibroService libroService;
	
	@PostMapping("alta")
	public String alta(Model model, 
			@RequestParam("isbn") String isbn, 
			@RequestParam("titulo") String titulo, 
			@RequestParam("autor") String autor, 
			@RequestParam("precio") double precio) {
		Libro libro=new Libro(isbn, titulo, autor, precio);
		if(libroService.nuevoLibro(libro)) {
			model.addAttribute("mensaje", "Libro añadido");
		}else {
			model.addAttribute("mensaje", "Libro no añadido");
		}
		return "mensaje";
	}

	@GetMapping(value="buscar")
    public String buscarLibros(Model model, @RequestParam("isbn") String isbn) {
        Libro libro = libroService.buscarPorIsbn(isbn);
        if(libro!=null) {
        	model.addAttribute("libro", libro);
            return "datos";
        }else {
        	model.addAttribute("mensaje", "isbn no existe");
            return "mensaje";
        }
        
    }
	@PostMapping(value="eliminar")
	public String eliminar(Model model, 
			@RequestParam("isbn") String isbn) {
		if(libroService.eliminarLibro(isbn)) {
			model.addAttribute("mensaje", "Libro eliminado");
		}else {
			model.addAttribute("mensaje", "Isbn no existe!");
		}
		return "mensaje";
	}
	@GetMapping("goNuevo")
	public String goNuevo() {
		return "nuevo";
	}
	@GetMapping("goBuscar")
	public String goBuscar() {
		return "buscar";
	}
	@GetMapping("goEliminar")
	public String goEliminar() {
		return "eliminar";
	}
	@GetMapping({"/","goMenu"})
	public String goMenu() {
		return "menu";
	}

}
