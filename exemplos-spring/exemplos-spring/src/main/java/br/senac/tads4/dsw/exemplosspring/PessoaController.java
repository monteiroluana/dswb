package br.senac.tads4.dsw.exemplosspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    @GetMapping("/form")
    public ModelAndView abrirForm() {
        return new ModelAndView("pessoa/formulario").addObject("pessoa", new Pessoa());
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@ModelAttribute("pessoa") Pessoa pessoa, RedirectAttributes redirectAttributes) {
        ModelAndView retorno = new ModelAndView("redirect:/pessoa/resultado");
        //ModelAndView retorno = new ModelAndView ("pessoa/resultado").addObject("pessoa",pessoa);
        return retorno;
    }

    @GetMapping("/resultado")
    public ModelAndView mostrarResultado() {
        return new ModelAndView("pessoa/resultado");
    }
}
