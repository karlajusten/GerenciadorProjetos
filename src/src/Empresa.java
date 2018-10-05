package src;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

	private String nome;
	private List<Funcionario> funcionarios;
	private List<Projeto> projetos;
	
	public Empresa(String nome) {
		if(!nome.isEmpty()){
			this.nome = nome;
			funcionarios = new ArrayList<Funcionario>();
			projetos = new ArrayList<Projeto>();
		} else{
			throw new RuntimeException("Empresa sem nome");
		}
	}
	
	public String getNome() {
		return nome;
	}

	public void contrataFuncionario(Funcionario funcJoao) {
		funcionarios.add(funcJoao);
	}
	
	public boolean temFuncionario(String funcionario){
		for (Funcionario func : funcionarios){
			if(func.getNome().equals(funcionario)){
				return true;
			}
		}
		return false;
	}

	public void criarProjeto(Projeto projeto) {
		projetos.add(projeto);
	}
	
	public Projeto getProjeto(String projeto){
		for (Projeto proj : projetos){
			if(proj.getNome().equals(projeto)){
				return proj;
			}
		}
		return null;
	}
}
