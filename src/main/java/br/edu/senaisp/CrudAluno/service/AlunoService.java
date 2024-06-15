package br.edu.senaisp.CrudAluno.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senaisp.CrudAluno.model.Aluno;
import br.edu.senaisp.CrudAluno.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
    private AlunoRepository alunoRep;

    public List<Aluno> getAllAluno() {
        return alunoRep.findAll();
    }

    public void SalvAluno(Aluno aluno) {
    	alunoRep.save(aluno);
    }
    
    public Aluno getStudentById(Integer id) {
        Optional<Aluno> optional = alunoRep.findById(id);
        Aluno aluno = null;
        if (optional.isPresent()) {
        	aluno = optional.get();
        } else {
            throw new RuntimeException("Aluno não encontrado por id :: " + id);
        }
        return aluno;
    }
    
    public void deleteAlunoById(Integer id) {
    	alunoRep.deleteById(id);
    }

	public void saveAluno(Aluno aluno) {
		
	}

	public Aluno getAlunoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
