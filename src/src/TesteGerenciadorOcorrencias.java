package src;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TesteGerenciadorOcorrencias {

	@Test 
	public void criarEmpresaPetrobras() throws Exception {
		Empresa empresa = new Empresa("Petrobras");
		assertEquals("Petrobras", empresa.getNome());
	}
	
	@Test (expected = RuntimeException.class)
	public void criarEmpresaSemNome() throws Exception {
		Empresa empresa = new Empresa("");
	}
	
	@Test (expected = RuntimeException.class)
	public void criarEmpresNomeNull() throws Exception {
		Empresa empresa = new Empresa(null);
	}
	
	@Test
	public void criarFuncionario() throws Exception {
		Funcionario func = new Funcionario("João da Silva");
		assertEquals("João da Silva", func.getNome());
	}
	
	@Test (expected = RuntimeException.class)
	public void criarFuncionarioSemNome() throws Exception {
		Funcionario funcJoao = new Funcionario("");
	}
	
	@Test (expected = RuntimeException.class)
	public void criarFuncionarioComNomeNull() throws Exception {
		Funcionario funcJoao = new Funcionario(null);
	}
	
	@Test
	public void petrobrasContrataFuncionarioJoao() throws Exception {
		Empresa empresa = new Empresa("Petrobras");
		Funcionario funcJoao = new Funcionario("João da Silva");
		empresa.contrataFuncionario(funcJoao);
		assertEquals(true, empresa.temFuncionario("João da Silva"));
	}
	
	@Test
	public void petrobrasContrataJoaoEMaria() throws Exception {
		Empresa empresa = new Empresa("Petrobras");
		Funcionario funcJoao = new Funcionario("João da Silva");
		empresa.contrataFuncionario(funcJoao);
		Funcionario funcMaria = new Funcionario("Maria Silveira");
		empresa.contrataFuncionario(funcMaria);
		assertEquals(true, empresa.temFuncionario("João da Silva"));
		assertEquals(true, empresa.temFuncionario("Maria Silveira"));
	}
	
	@Test
	public void CriaProjetoPreSal() throws Exception {
		Projeto projetoPreSal = new Projeto("Pré-Sal");
		assertEquals("Pré-Sal", projetoPreSal.getNome());
	}
	
	@Test (expected = RuntimeException.class)
	public void CriaProjetoSemNome() throws Exception {
		Projeto projetoPreSal = new Projeto("");
	}
	
	@Test
	public void PetrobasCriaProjetoPreSal() throws Exception {
		Empresa empresa = new Empresa("Petrobras");
		Projeto projetoPreSal = new Projeto("Pré-Sal");
		empresa.criarProjeto(projetoPreSal);
		assertEquals("Pré-Sal", empresa.getProjeto("Pré-Sal").getNome());
	}
	
	@Test
	public void criaOcorrencia() throws Exception {
		Empresa empresa = new Empresa("Petrobras");
		Projeto projetoPreSal = new Projeto("Pré-Sal");
		empresa.criarProjeto(projetoPreSal);
		projetoPreSal.criaOcorrencia("Problema 1 no Pré-Sal");
		assertEquals("Problema 1 no Pré-Sal", projetoPreSal.getOcorrenciaByName("Problema 1 no Pré-Sal").getNome());
	}
	
	@Test
	public void ProjetoPreSalDaPetrobrasCriaOcorrencia() throws Exception {
		Empresa empresa = new Empresa("Petrobras");
		Projeto projetoPreSal = new Projeto("Pré-Sal");
		projetoPreSal.criaOcorrencia("Problema 1 no Pré-Sal");
		empresa.criarProjeto(projetoPreSal);
		assertEquals("Problema 1 no Pré-Sal", projetoPreSal.getOcorrenciaByName("Problema 1 no Pré-Sal").getNome());
	}
	
	@Test (expected = RuntimeException.class)
	public void ProjetoPreSalDaPetrobrasCriaDuasOcorrenciaComMesmoNome() throws Exception {
		Empresa empresa = new Empresa("Petrobras");
		Projeto projetoPreSal = new Projeto("Pré-Sal");
		empresa.criarProjeto(projetoPreSal);
		projetoPreSal.criaOcorrencia("Problema 1 no Pré-Sal");
		projetoPreSal.criaOcorrencia("Problema 1 no Pré-Sal");
	}
	
	@Test
	public void ProjetoPreSalDaPetrobrasCriaOcorrenciaEResposavel() throws Exception {
		Empresa empresa = new Empresa("Petrobras");
		Projeto projetoPreSal = new Projeto("Pré-Sal");
		empresa.criarProjeto(projetoPreSal);
		Funcionario joao = new Funcionario("João da Silva");
		empresa.contrataFuncionario(joao);
		projetoPreSal.criaOcorrencia("Problema 1 no Pré-Sal");
		projetoPreSal.setResponsavelOcorrencia(joao, projetoPreSal.getOcorrenciaByName("Problema 1 no Pré-Sal"));
		assertEquals("João da Silva", projetoPreSal.getOcorrenciaByName("Problema 1 no Pré-Sal").getResposavel().getNome());
	}
	
	@Test
	public void ChecarOcorrenciaNaoConcluida() throws Exception {
		Empresa empresa = new Empresa("Petrobras");
		Projeto projetoPreSal = new Projeto("Pré-Sal");
		empresa.criarProjeto(projetoPreSal);
		projetoPreSal.criaOcorrencia("Problema 1 no Pré-Sal");
		Ocorrencia ocorrencia = projetoPreSal.getOcorrenciaByName("Problema 1 no Pré-Sal");
		ocorrencia.setResponsavel(new Funcionario("João da Silva"));
		assertEquals(false, ocorrencia.estaConcluido());
	}
	
	@Test
	public void ChecarOcorrenciaConcluida() throws Exception {
		Empresa empresa = new Empresa("Petrobras");
		Projeto projetoPreSal = new Projeto("Pré-Sal");
		empresa.criarProjeto(projetoPreSal);
		projetoPreSal.criaOcorrencia("Problema 1 no Pré-Sal");
		Ocorrencia ocorrencia = projetoPreSal.getOcorrenciaByName("Problema 1 no Pré-Sal");
		ocorrencia.setResponsavel(new Funcionario("João da Silva"));
		ocorrencia.setConcluido(true);
		assertEquals(true, ocorrencia.estaConcluido());
	}
	
	@Test
	public void FuncionarioResponsavelUmaOcorrencia throws Exception {
		Empresa empresa = new Empresa("Petrobras");
		Projeto projetoPreSal = new Projeto("Pré-Sal");
		empresa.criarProjeto(projetoPreSal);
		projetoPreSal.criaOcorrencia("Problema 1 no Pré-Sal");
		Ocorrencia ocorrencia = projetoPreSal.getOcorrenciaByName("Problema 1 no Pré-Sal");
		ocorrencia.setResponsavel(new Funcionario("João da Silva"));
		assertEquals(1, empresa.quantidadeOcorrenciaResponsavel("João da Silva"));
	}
}
