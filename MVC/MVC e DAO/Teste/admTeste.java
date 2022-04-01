package Teste;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Model.Administrador;
import Jdbc.administradorDAO;
import Jdbc.connectionFactory;


public class admTeste {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdm() throws SQLException{
		
		administradorDAO admdao = new administradorDAO();//chama a classe admdao
		
		connectionFactory con = new connectionFactory();//chama a classe de conexao com banco
		
		//Administrador adm1 = new Administrador("Guilherme uouoi","uoiu@gmail.com","987897","121iiui");//Alterar
		
		//Administrador adm1 = new Administrador("","mandrakeguizao@gmail.com","987897","12uiuo");//Erro no nome
		
		//Administrador adm1 = new Administrador("Guilherme Agenor","","987897","12uiuo");//Erro no email

		//Administrador adm1 = new Administrador("Guilherme Agenor","mandrakeguizao@gmail.com","987897","");//erro na senha
				
		//admdao.Alterardadosadm(adm1);//altera os dados
		
		con.testeConexao();//teste de conexao
		
		
	}
	

}
