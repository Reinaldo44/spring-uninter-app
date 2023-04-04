package com.springuninter.controller;

import com.springuninter.bo.ClienteBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.springuninter.model.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteBo clienteBo;

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelMap model) {
		
		model.addAttribute("cliente", new Cliente());	
		return new ModelAndView("/cliente/formulario", model);
		
	}
	@RequestMapping(method = RequestMethod.POST)
	public String salvaCliente(@ModelAttribute Cliente cliente){

          clienteBo.insere(cliente);

		return "/cliente/formulario";

	}


}
