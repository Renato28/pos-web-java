package br.com.devmedia.controller;


import br.com.devmedia.domain.Produto;
import br.com.devmedia.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/listar")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("produtos", produtoService.recuperar());
        return new ModelAndView("/produto/list", model);
    }

    @GetMapping("/cadastro")
    public String preSalvar(@ModelAttribute("produto") Produto produto) {
        return "/produto/add";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("produto") Produto produto, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/produto/add";
        }

        produtoService.salvar(produto);
        attr.addFlashAttribute("mensagem", "Produto criado com sucesso.");
        return "redirect:/produtos/listar";
    }

    @GetMapping("/{id}/atualizar")
    public ModelAndView preAtualizar(@PathVariable("id") long id, ModelMap model) {
        Produto produto = produtoService.recuperarPorId(id);
        model.addAttribute("produto", produto);
        return new ModelAndView("/produto/add", model);
    }

    @PutMapping("/salvar")
    public String atualizar(@Valid @ModelAttribute("produto") Produto produto, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/produto/add";
        }

        produtoService.atualizar(produto);
        attr.addFlashAttribute("mensagem", "Produto atualizado com sucesso.");
        return "redirect:/produtos/listar";
    }

    @GetMapping("/{id}/remover")
    public String remover(@PathVariable("id") long id, RedirectAttributes attr) {
        produtoService.excluir(id);
        attr.addFlashAttribute("mensagem", "Produto excluído com sucesso.");
        return "redirect:/produtos/listar";
    }

}
