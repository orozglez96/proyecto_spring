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
	@GetMapping(value="buscar") //esta anotación nos permite dirigir este metodo cuando llegue una petición que termine en la palabra buscar
	public String buscarItems(Model model,@RequestParam("tematica") String tematica) { //Nota: anotar em MD para qué sirve el model //@RequestParam sirve para indicar que la tematica la tiene que buscar aquí
		List<Item> items=itemsService.buscarPorTematica(tematica);
		//guardar la lista en algún lugar donde pueda recogerlo la página que va a generar la red
		model.addAttribute("listado", items);
		return "resultados";
	}
	@PostMapping(value="alta") 
	public String altaItems(Model model, 
			@RequestParam("url") String url, 
			@RequestParam("tematica") String tematica, 
			@RequestParam("descripcion") String descripcion) { 
		Item item= new Item(url, tematica, descripcion);
		if(itemsService.nuevoItem(item)) {
			model.addAttribute("mensaje", "Item añadido correctamente");
		}else {
			model.addAttribute("mensaje", "Item repetido");
		}
		return "mensaje";
	}
	@GetMapping({"inicio"})
	public String inicio() {
		return "inicio";
	}
	@GetMapping({"nuevo"})
	public String nuevo() {
		return "nuevo";
	}
	@GetMapping({"/","menu"})
	public String menu() {
		return "menu";
	}
}
