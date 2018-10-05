package src;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {

	String nome;
	private List<Ocorrencia> ocorrencias;
	
	public Funcionario(String string) {
		if(!string.isEmpty()){
			nome = string;
			ocorrencias = new ArrayList<Ocorrencia>();
		} else{
			throw new RuntimeException("Funcionario sem nome");
		}
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setComoResponsavelOcorrencia(Ocorrencia oc){
		ocorrencias.add(oc);
	}

	public int getQtdadeOcorrenciasResponsavel(){
		return ocorrencias.size();
	}
}