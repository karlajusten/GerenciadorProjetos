package src;

import java.util.ArrayList;

public class Ocorrencia {

	String nome;
	Funcionario responsavel;
	boolean concluido;
	
	public Ocorrencia(String string) {
			nome = string;
			concluido = false;
	}
	public String getNome() {
		return nome;
	}

	public Funcionario getResposavel() {
		return responsavel;
	}
	
	public void setResponsavel(Funcionario func){
		responsavel = func;
	}
	
	public boolean estaConcluido(){
		return concluido;
	}
	
	public void setConcluido(boolean c){
		concluido = c;
	}

}