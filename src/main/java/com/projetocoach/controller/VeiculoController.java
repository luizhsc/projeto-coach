package com.projetocoach.controller;

import com.projetocoach.models.Veiculo;
import com.projetocoach.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        return "redirect:/";
    }

    @RequestMapping(value = "/")
    public ModelAndView listaVeiculos(){
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<Veiculo> veiculoInterable = veiculoRepository.findAll();
        modelAndView.addObject("veiculos", veiculoInterable);
        return modelAndView;
    }

    @RequestMapping("/{id}")
    public ModelAndView detalheVeiculo(@PathVariable("id") int id){
        Veiculo veiculo = veiculoRepository.findById(id);
        ModelAndView modelAndView = new ModelAndView("veiculo/detalheVeiculo");
        modelAndView.addObject("veiculo", veiculo);
        return modelAndView;
    }

    @RequestMapping(value = "/deletar")
    public String deletaVeiculo(int id){
        Veiculo veiculo = veiculoRepository.findById(id);
        veiculoRepository.delete(veiculo);
        return "redirect:/";
    }

}
