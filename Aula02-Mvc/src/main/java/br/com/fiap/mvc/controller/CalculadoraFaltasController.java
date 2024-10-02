package br.com.fiap.mvc.controller;

import br.com.fiap.mvc.model.Faltas;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("calculadora")
public class CalculadoraFaltasController {

    @GetMapping("porcentagem")
    public String calcular(){
        return "calculadora/porcentagem";
    }

    @PostMapping("media")
    public String calcular(Faltas faltas, Model model){
        model.addAttribute("porcentagemMedia", faltas.calcularMediaFaltas());
        model.addAttribute("fal", faltas);
        return "calculadora/porcentagem";
    }

}
