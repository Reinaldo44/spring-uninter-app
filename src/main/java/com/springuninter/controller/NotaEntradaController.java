package com.springuninter.controller;

import com.springuninter.bo.FornecedorBO;
import com.springuninter.bo.NotaEntradaBO;
import com.springuninter.bo.ProdutoBO;
import com.springuninter.model.NotaEntrada;
import com.springuninter.model.NotaEntradaItem;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/nota-entrada")
public class NotaEntradaController {

    @Autowired
    private NotaEntradaBO notaEntradaBO;

    @Autowired
    private FornecedorBO fornecedorBO;

    @Autowired
    private ProdutoBO produtoBO;

    @RequestMapping(value="/novo", method=RequestMethod.GET)
    public ModelAndView novo(ModelMap model) {
        model.addAttribute("notaEntrada", new NotaEntrada());
        model.addAttribute("fornecedores", fornecedorBO.lista());
        return new ModelAndView("/nota-entrada/formulario", model);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public String salva(@Valid @ModelAttribute NotaEntrada notaEntrada,
                        BindingResult result,
                        RedirectAttributes attr,
                        ModelMap model) {

        if (notaEntrada.getFornecedor().getId() == null)
            result.rejectValue("fornecedor", "field.required");

        if (result.hasErrors()) {
            model.addAttribute("fornecedores", fornecedorBO.lista());
            return "/nota-entrada/formulario";
        }

        if (notaEntrada.getId() == null) {
            notaEntradaBO.insere(notaEntrada);
            attr.addFlashAttribute("feedback", "A nota de entrada foi cadastrada com sucesso");
        } else {
            notaEntradaBO.atualiza(notaEntrada);
            attr.addFlashAttribute("feedback", "Os dados da nota de entrada foram atualizados com sucesso");
        }

        return "redirect:/nota-entrada";
    }

    @RequestMapping(value="", method=RequestMethod.GET)
    public ModelAndView lista(ModelMap model) {
        model.addAttribute("notas", notaEntradaBO.lista());
        return new ModelAndView("/nota-entrada/lista", model);
    }


    @RequestMapping(value="/{id}/item", method=RequestMethod.GET)
    public ModelAndView produto(@PathVariable("id") Long id, ModelMap model) {
        NotaEntradaItem nei = new NotaEntradaItem();
        NotaEntrada ne = notaEntradaBO.pesquisapeloId(id);
        nei.setNotaEntrada(ne);
        model.addAttribute("notaEntradaItem", nei);
        model.addAttribute("produtos", produtoBO.lista());
        return new ModelAndView("/nota-entrada-item/formulario", model);
    }

    @RequestMapping(value="/edita/{id}", method=RequestMethod.GET)
    public ModelAndView edita(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("notaEntradaItem", new NotaEntradaItem());
        model.addAttribute("fornecedores", fornecedorBO.lista());
        model.addAttribute("notaEntrada", notaEntradaBO.pesquisapeloId(id));
        return new ModelAndView("/nota-entrada/formulario", model);
    }

    @RequestMapping(value="/remove/{id}", method=RequestMethod.GET)
    public String remove(@PathVariable("id") Long id, RedirectAttributes attr) {
        NotaEntrada ne = notaEntradaBO.pesquisapeloId(id);
        notaEntradaBO.remove(ne);
        attr.addFlashAttribute("feedback", "Nota entrada removida com sucesso");
        return "redirect:/nota-entrada";
    }
}


