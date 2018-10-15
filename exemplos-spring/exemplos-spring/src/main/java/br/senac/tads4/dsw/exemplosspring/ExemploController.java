package br.senac.tads4.dsw.exemplosspring;

import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/exemplo")
public class ExemploController {
    
    @GetMapping("/ex1")
    public String exemplo1() {
        return "view-exemplo1";
    }

    @GetMapping("/ex2")
    public String exemplo2(Model modelo) {
        modelo.addAttribute("info1","fulano");
        modelo.addAttribute("info2",LocalDateTime.now());
        return "view-exemplo2";
    }
    
    @GetMapping("/ex2a")
    public ModelAndView exemplo2a() {
        ModelAndView resposta = new ModelAndView();
        resposta.addObject("info1","Texto gerado no Controller v2a");
        resposta.addObject("info2",LocalDateTime.now());
        return resposta;
    }
}
