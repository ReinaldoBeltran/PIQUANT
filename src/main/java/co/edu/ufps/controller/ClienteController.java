package co.edu.ufps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.edu.ufps.model.Administrador;
import co.edu.ufps.model.Cliente;
import co.edu.ufps.model.Direccion;
import co.edu.ufps.service.IClienteService;
import co.edu.ufps.service.IDireccionService;


@Controller
@RequestMapping
public class ClienteController {
	
	
	@Autowired
	private  IClienteService clienteService;
	
	@Autowired
	private IDireccionService direccionService;
	

	
	@GetMapping("/formRegistro")
	public String registrarCliente(Model model) {
		Cliente cliente= new Cliente();	
		Direccion direccion = new Direccion();
		model.addAttribute(cliente);
		model.addAttribute(direccion);
		return "registro";
	}
	
	@PostMapping("/formRegistro/insertar")
	public String registrarCliente(@ModelAttribute Cliente cliente, @ModelAttribute Direccion direccion) {
		direccionService.insertar(direccion);
		cliente.setDireccion(direccion);
		clienteService.insertar(cliente);
		
		return "redirect:/";
	}	
	
	
	
	//prueba
	
	@GetMapping("/formIngresar")
	public String validarIngreso(Model model) {
		
		Cliente c1= new Cliente();
		Administrador a1= new Administrador();
		model.addAttribute("cliente",c1);
		
		return "login";
	}
	
	@PostMapping("/formIngresar/validar")
	public String logear(@ModelAttribute Cliente cliente) {
		
		
			
			if(cliente.getClave().equals("123") && cliente.getCorreo().equals("reinaldo@gmail.com")) {
				System.out.println("son iguales........................");
				return "redirect:/";
				
			}
		
		
		return "redirect:/";
	}	
	
	
}
