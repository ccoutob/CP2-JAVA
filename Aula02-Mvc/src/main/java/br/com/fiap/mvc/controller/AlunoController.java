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
    public String cadastrar(){
        return "aluno/cadastro";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model){
        //Pesquisar o aluno pelo id e enviar o aluno para a view
        model.addAttribute("aluno", alunoRepository.findById(id));
        //Retornar a view
        return "aluno/editar";
    }

    @GetMapping("listar") //localhost:8080/aluno/listar
    public String listar(Model model){
        //Enviar a lista de livros para a view
        model.addAttribute("alunos", alunoRepository.findAll());
        return "aluno/lista";
    }

    @PostMapping("editar")
    @Transactional
    public String editar(Aluno aluno, Model model){
        alunoRepository.save(aluno);
        model.addAttribute("msg", "Aluno atualizado");
        model.addAttribute("alunos", alunoRepository.findAll());
        return "aluno/lista";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(Aluno aluno, Model model){
        alunoRepository.save(aluno);
        model.addAttribute("msg", "Aluno registrado!");
        return "Aluno/cadastro";
    }

}
