package br.com.fiap.mvc.controller;

import br.com.fiap.mvc.model.Aluno;
import br.com.fiap.mvc.respository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("cadastrar")
    public String cadastrar(Aluno aluno){
        return "aluno/cadastro";
    }
    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(Aluno aluno, Model model){
        alunoRepository.save(aluno);
        model.addAttribute("msg", "Aluno cadastrado!");
        return "aluno/cadastro";
    }

}
