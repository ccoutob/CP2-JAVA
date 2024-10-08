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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("cadastrar")
    public String cadastrar(Aluno aluno){
        return "aluno/cadastro";
    }

    @GetMapping("listar") //localhost:8080/aluno/listar
    public String listar(Model model){
        //Enviar a lista de alunos para a view
        model.addAttribute("status", alunoRepository.findAll());
        return "aluno/lista";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model){
        //Pesquisar o aluno pelo id e enviar o aluno para a view
        model.addAttribute("aluno", alunoRepository.findById(id));
        //Retornar a view
        return "aluno/editar";
    }

    @PostMapping("editar")
    @Transactional
    public String editar(Aluno aluno, RedirectAttributes redirectAttributes){
        alunoRepository.save(aluno);
        redirectAttributes.addFlashAttribute("msg", "Aluno atualizado");
        return "redirect:/aluno/listar";
    }

    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(Aluno aluno, RedirectAttributes redirectAttributes){
        alunoRepository.save(aluno);
        redirectAttributes.addFlashAttribute("msg", "Aluno registrado!");
        return "redirect:/aluno/cadastrar";
    }

    @PostMapping("excluir")
    @Transactional
    public String remover(Long idStatus, RedirectAttributes redirectAttributes){
        alunoRepository.deleteById(idStatus);
        redirectAttributes.addFlashAttribute("msg", "Aluno removido!");
        return "redirect:/aluno/listar";
    }

}
