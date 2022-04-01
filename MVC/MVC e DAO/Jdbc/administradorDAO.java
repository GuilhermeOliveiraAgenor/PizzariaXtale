package Jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Administrador;
import Model.Borda;

public class administradorDAO extends connectionFactory {
	
public void selecionarAdministrador(Administrador administrador) {
		
		String sql = "	select *from Administrador";//A string sql faz o select
		
		try {
			
			Connection con = conectar();//Conecta com o banco de dados
			PreparedStatement pst = con.prepareStatement(sql);//Chama a string sql
			ResultSet rs = pst.executeQuery();//executa o sql
			while(rs.next()) {//Passa os parâmetros
				administrador.setNome(rs.getString(1));
				administrador.setEmail(rs.getString(2));
				administrador.setCpf(rs.getString(3));
				administrador.setSenha(rs.getString(4));
			}
			con.close();//Fecha a conexão
			
		}
		catch(Exception e){
			
			System.out.println(e.getMessage());//Mostra a mensagem de erro no console
			
		}
		
	}
		public boolean alterardadosAdm(Administrador administrador) {
	
			boolean status = false;//variavel bool
			
		try {
			Connection con = conectar();//chama a conexao com o banco de dados
			System.out.println("Conexão feita com banco de dados");
			System.out.println(con);
			System.out.println("---------------------");
			System.out.println("A conexão foi feita com o banco de dados e vai chamar a procedure Alterardadosadm no banco");
			CallableStatement cls = con.prepareCall("{call alterardadosAdm(?,?,?)}");//chama a procedure de alterar dados
			cls.setString(1, administrador.getNome());//passa os parametros
			cls.setString(2, administrador.getEmail());
			cls.setString(3, administrador.getSenha());
			int result = cls.executeUpdate();//executa a procedure
			cls.close();//Fecha a conexao com o banco
			
		//O numero do result é igual o numero que vem do execute
			//Se o numero do execute for maior que 1 vai retornar um bool igual a true
			if(result >= 1) {
				
				status = true;
				System.out.println("Alterado");
				
			}
			if(result < 1){//Se nao for maior vai retornar um false
				
				status = false;
			}
			System.out.println("Os parametros nome, email e senha vão fazer conexão com o construtor");
			System.out.println("---------------------");
			System.out.println("da classe administrador. Vão setar os objetos da classe administrador");
			System.out.println("---------------------");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());//mostra e mensagem de erro no console no console
		}
		
		return status;

}
		
		public boolean loginAdm(Administrador administrador) {
			
			Connection con = conectar();
			String sql = "select *from Administrador where Cpf = ? and Senha = ?";//string com o sql
			boolean status = false;
			try {

				PreparedStatement ps = con.prepareStatement(sql);//chama a string sql
				ps.setString(1, administrador.getCpf());//Parametros
				ps.setString(2, administrador.getSenha());
				ResultSet rs = ps.executeQuery();//execute a string sql
				status = rs.next();
				
				
			} catch (Exception e) {
				
				e.getMessage();//Pega a mensagem de erro
				
			}
			return status;//retorna o status
	
		}
		public String selecionarProduto(Administrador administrador) {
			
			String mensagem ="";//string de mensagem
			
			
			try {
				Connection con = conectar();//chama a conexao com o banco de dados
				CallableStatement cls = con.prepareCall("{call selecionarProdutos()}");//chama a procedure
				int result = cls.executeUpdate();//executa a procedure
				cls.close();//fecha a conexao
				
				//o result vai ser igual o numero do execute
				//Se o numero do execute for menor ou igual a 1 vai retornar a mensagem de enviado
				if(result <= 1) {
					mensagem = "O relatorio foi enviado em seu email";
				}
				
				
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
				mensagem = e.getMessage();//mostra a mensagem de erro
				
			}

			return mensagem;//retorna a mensagem
			
		}
		public String selecionarIngredientes(Administrador administrador) {
			
			String mensagem = "";//string de mensagem
			
			try {
				Connection con = conectar();//chama a conexao com o banco de dados
				CallableStatement cls = con.prepareCall("{call selecionarIngredientes()}");//chama a procedure 
				int result = cls.executeUpdate();//executa a procedure
				cls.close();//fecha a conexao
				
				//o result vai ser igual o numero do execute
				//Se o numero do execute for menor ou igual a 1 vai retornar a mensagem de enviado
				if(result <= 1) {
					
					mensagem = "Enviado para seu email";
				}
		
			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
				mensagem = e.getMessage();//mostra a mensagem de erro
			}
			
			return mensagem;//retorna mensagem
			
		}
		
}
