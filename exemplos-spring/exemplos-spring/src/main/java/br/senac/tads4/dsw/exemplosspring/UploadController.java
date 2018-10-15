package br.senac.tads4.dsw.exemplosspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/upload")
public class UploadController {

    public ModelAndView mostrarForm() {
        return new ModelAndView("upload/form");
    }
}
