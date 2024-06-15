package br.edu.senaisp.CrudAluno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.senaisp.CrudAluno.model.Aluno;
import br.edu.senaisp.CrudAluno.service.AlunoService;

@Controller
@RequestMapping("/inicio")
public class AlunoController {
	
	@Autowired
    private AlunoService alunoService;

    @GetMapping()
    public String viewHomePage(Model model) {
        model.addAttribute("listAluno", alunoService.getAllAluno());
        return "Lista_deAluno";
    }
    
    @GetMapping("/novo")
    public String showNewAlunoForm(Model model) {
    	System.err.println("Cheguei");
        Aluno aluno = new Aluno();
        model.addAttribute("aluno", aluno);
        return "NovoAluno";
    }
    
    @PostMapping("/SalvarAluno")
    public String saveAluno(@ModelAttribute("aluno") Aluno aluno) {
    	alunoService.saveAluno(aluno);
        return "redirect:/";
    }
    
    @GetMapping("/mostraId/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Integer id, Model model) {
        Aluno aluno = alunoService.getAlunoById(id);
        model.addAttribute("aluno", aluno);
        return "update_aluno";
    }
    
    @GetMapping("/deleteALUNO/{id}")
    public String deleteAluno(@PathVariable(value = "id") Integer id) {
        alunoService.deleteAlunoById(id);
        return "redirect:/";
    }
    
    
}
