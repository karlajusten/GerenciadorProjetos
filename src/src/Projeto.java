package src;

import java.util.ArrayList;
import java.util.List;

public class Projeto {

	private String nome;
	private List<Ocorrencia> ocorrencias;
	
	public Projeto(String nome) {
		if(!nome.isEmpty()){
			this.nome = nome;
			ocorrencias = new ArrayList<Ocorrencia>();
		} else{
			throw new RuntimeException("Projeto sem nome");
		}
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public List<Ocorrencia> getOcorrencias(){
		return ocorrencias;
	}

	public void criaOcorrencia(String nome) {
		if(!existeOcorrenciaComNome(nome)){
			Ocorrencia oc = new Ocorrencia(nome);
			ocorrencias.add(oc);
		} else{
			throw new RuntimeException("Projeto já tem Ocorrencia Com Mesmo Nome");
		}
		
	}
	
	private boolean existeOcorrenciaComNome(String nome) {
		for (Ocorrencia ocor : ocorrencias){
			if(ocor.getNome().equals(nome)){
				return true;
			}
		}
		return false;
	}

	public Ocorrencia getOcorrenciaByName(String ocorrencia){
		for (Ocorrencia ocor : ocorrencias){
			if(ocor.getNome().equals(ocorrencia)){
				return ocor;
			}
		}
		return null;
	}

	public void setResponsavelOcorrencia(Funcionario func, Ocorrencia oc){
		if(func.getQtdadeOcorrenciasResponsavel()<10){
			oc.setResponsavel(func);
			func.setComoResponsavelOcorrencia(oc);
		} else{
			throw new RuntimeException("Funcionário já é responsavel por 10 ocorrencias");
		}
	}
	
	
}
