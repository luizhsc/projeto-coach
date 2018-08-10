package com.projetocoach.controller;

import com.projetocoach.models.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.projetocoach.repository.VeiculoRepository;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VeiculoController {

    @Autowired
    public VeiculoRepository veiculoRepository;


    @RequestMapping(value="/cadastrar", method=RequestMethod.GET)
    private String form(){
        return "veiculo/formVeiculo";
    }


    @RequestMapping(value="/cadastrar", method=RequestMethod.POST)
    private String form(Veiculo veiculo)
    {
        veiculoRepository.save(veiculo);
        return "redirect:/cadastrar";
    }

    @RequestMapping(value = "/")
    public ModelAndView listaVeiculos(){
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<Veiculo> veiculoInterable = veiculoRepository.findAll();
        modelAndView.addObject("veiculos", veiculoInterable);
        return modelAndView;
    }

    @RequestMapping(value = "/deletar")
    public String deletaVeiculo(int id){
        Veiculo veiculo = veiculoRepository.findById(id);

        veiculoRepository.delete(veiculo);
        return "redirect:/";
    }
}
