package co.edu.ufps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.ufps.model.Producto;
import co.edu.ufps.service.IProductoService;

@Controller
@RequestMapping
public class VistasController {
	
	@Autowired
	private IProductoService productoSerive;

	@GetMapping("/home")
	public String inicio() {
		
		return "index";
	}
	
	@GetMapping("/menu")
	public String menu(Model model) {
		List<Producto>productos= productoSerive.findAll();
		model.addAttribute("productos",productos);
		System.out.println(productos.toString());
		return "menu";
	}
	
	@GetMapping("/admincate")
	public String admincate() {
		
		return "admincategoria";
	}
	
	@GetMapping("/adminproduc")
	public String adminproduc() {
		
		return "adminproducto";
	}
	
	@GetMapping("/estadisticas")
	public String estadisticas() {
		
		return "estadisticas";
	}
	
	@GetMapping("/carrito")
	public String carrito() {
		
		return "carrito";
	}
	
	
}
