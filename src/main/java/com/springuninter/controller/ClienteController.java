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

	@RequestMapping(value = "/edita/{id}", method = RequestMethod.PUT)
	public ModelAndView edita(@PathVariable("id") Long id, ModelMap model) {

		model.addAttribute("cliente", clienteBo.pesquisapeloId(id));
		return new ModelAndView("/cliente/formulario", model);

	}
	@RequestMapping(method = RequestMethod.POST)
	public String salvaCliente(@ModelAttribute Cliente cliente){

          clienteBo.insere(cliente);

		return "/cliente/formulario.html";

	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView lista(ModelMap model) {

		model.addAttribute("clientes", clienteBo.lista());

		return new ModelAndView("/cliente/lista", model);

	}

	@RequestMapping("/deletar")
	public String deletar(Long id) {

		Cliente clienteId = clienteBo.pesquisapeloId(id);

		clienteBo.remove(clienteId);

		return "redirect:/cliente/lista";

	}
    @RequestMapping(value = "/inativa/{id}", method = RequestMethod.GET)
    public String inativa(@PathVariable("id") Long id, ModelMap model) {


        Cliente clienteId = clienteBo.pesquisapeloId(id);

        clienteBo.inativa(clienteId);

        return "redirect:/clientes";

    }
    @RequestMapping(value = "/ativa/{id}", method = RequestMethod.GET)
    public String ativa(@PathVariable("id") Long id, ModelMap model) {


        Cliente clienteId = clienteBo.pesquisapeloId(id);

        clienteBo.ativa(clienteId);

        return "redirect:/clientes";

    }


}
