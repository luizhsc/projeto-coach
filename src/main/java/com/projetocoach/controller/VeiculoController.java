package com.projetocoach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VeiculoController {

    @RequestMapping("/cadastro")
    private String form(){
        return "veiculo/formVeiculo";
    }

}
