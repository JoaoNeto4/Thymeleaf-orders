package br.com.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;

import br.com.mvc.mudi.dto.UserDto;
import br.com.mvc.mudi.model.Pedido;
import br.com.mvc.mudi.model.StatusPedido;
import br.com.mvc.mudi.repository.PedidoRepository;
import br.com.mvc.mudi.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {


	@Autowired
	private PedidoRepository pedidoRepository;

	private final UserService userService;


	@GetMapping
	public String home(Model model, Authentication authentication) {
		if (authentication != null) {
			UserDto user = userService.getLoginUser();
			model.addAttribute("user", user);
		}
		model.addAttribute("title", "Home");

		List<Pedido> pedidos = pedidoRepository.findAll();
		model.addAttribute("pedidos", pedidos);

		return "home";
	}


	@GetMapping("/{status}")
	public String porStatus(@PathVariable String status, Model model, Authentication authentication) {

		if (authentication != null) {
			UserDto user = userService.getLoginUser();
			model.addAttribute("user", user);
		}
		model.addAttribute("title", "Home");

		// /home/aguardado 
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);

		return "home";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onErrString(){
		return "redirect:/home";
	}



	/*
	@Autowired
	private PedidoRepository pedidoRepository;


	@GetMapping
	public String home(Model model) {

		List<Pedido> pedidos = pedidoRepository.findAll();
		model.addAttribute("pedidos", pedidos);

		return "home";
	}
	
	@GetMapping("/{status}")
	public String porStatus(@PathVariable String status, Model model) {
		// /home/aguardado 
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);

		return "home";
	}
	
	// @GetMapping("/aguardando}")
	// public String aguardando(Model model) {
	//
	//	List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.AGUARDADO);
	//	model.addAttribute("pedidos", pedidos);
	//
	//	return "home";
	// }
	//

	@ExceptionHandler(IllegalArgumentException.class)
	public String onErrString(){
		return "redirect:/home";
	}
	 */
}