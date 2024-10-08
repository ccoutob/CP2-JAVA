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
    public String calcular() {
        return "calculadora/porcentagem"; // Carrega o template correto
    }

    @PostMapping("porcentagem")
    public String calcular(Faltas faltas, Model model) {
        System.out.println("Calculando porcentagem com faltas: " + faltas.getFaltas());
        double porcentagemMedia = faltas.calcularMediaFaltas();
        model.addAttribute("porcentagemMedia", porcentagemMedia);
        model.addAttribute("fal", faltas); // Para acessar as faltas
        return "/porcentagem"; // Retorna para o mesmo template
    }
}


