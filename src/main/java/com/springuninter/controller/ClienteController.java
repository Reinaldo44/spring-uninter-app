package com.springuninter.controller;

import com.springuninter.bo.ClienteBO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.springuninter.model.Cliente;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteBO clienteBo;


	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelMap model) {

		model.addAttribute("cliente", new Cliente());
		return new ModelAndView("/cliente/formulario", model);

	}

	@RequestMapping(value = "/edita/{id}", method = RequestMethod.GET)
	public ModelAndView edita(@PathVariable("id") Long id, ModelMap model) {

		model.addAttribute("cliente", clienteBo.pesquisapeloId(id));

		return new ModelAndView("/cliente/formulario", model);

	}
	@RequestMapping(method = RequestMethod.POST)
	public String salvaCliente(@Valid @ModelAttribute Cliente cliente, BindingResult result, RedirectAttributes attr){

		if (result.hasErrors())
			return "cliente/formulario";

		if (cliente.getId() == null) {
			clienteBo.insere(cliente);
			attr.addFlashAttribute("feedback", "Cliente foi cadastrado com sucesso");
		}
		else {
			clienteBo.atualiza(cliente);
			attr.addFlashAttribute("feedback", "Cliente foi atualizado com sucesso");
		}
		return "redirect:/clientes";

	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView lista(ModelMap model) {

		model.addAttribute("clientes", clienteBo.lista());

		return new ModelAndView("/cliente/lista", model);

	}

	@RequestMapping(value = "/deletar")
	public String deletar(Long id) {

		Cliente clienteId = clienteBo.pesquisapeloId(id);

		clienteBo.remove(clienteId);

		return "redirect:/clientes";

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
