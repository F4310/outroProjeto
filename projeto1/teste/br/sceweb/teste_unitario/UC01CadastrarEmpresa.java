package br.sceweb.teste_unitario;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.sceweb.model.Empresa;
import br.sceweb.model.EmpresaDAO;

public class UC01CadastrarEmpresa {
	static EmpresaDAO empresaDAO;
	static Empresa empresa;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
	}
	
	/**
	 * CT01UC01FBCadastra_com_Sucesso
	 * Verificar o comportamento do sistema para o cadastro de 
	 * empresa com sucesso
	 */
	@Test
	
	public void CT01UC01FBCadastra_com_sucesso() {
		assertEquals(1,empresaDAO.adiciona(empresa));
	}
	
	/**
	 * CT02UC01FBCadastra_com_CNPJ_Invalido
	 * Verificar o comportamento do sistema para cadastro com CNPJ Invalido
	 */
	@Ignore
	@Test
	public void CT02UC01FBCadastra_com_CNPJ_Invalido() {
		assertEquals(false,empresa.setCnpj("8942"));
	}
	
	@Ignore
	@Test
	public void CT03UC01FBCadastra_com_CNPJ_Ja_Cadastrado() {
		assertEquals(0,empresaDAO.adiciona(empresa));
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empresaDAO.exclui("89424232000180");
	}
}



