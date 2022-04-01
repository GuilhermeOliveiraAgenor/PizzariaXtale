package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class connectionFactory {

	private String user = "sa";//Nome do usuario
	private String password = "gui123";//Senha do usuario
	private String url = "jdbc:sqlserver://LAPTOP-SSVQOHP6;databaseName=Admdelivery";//Link de conexao com o banco de dados
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//Driver do sql server 

	protected Connection conectar() {

		Connection con = null;
		try {

			Class.forName(driver);//Chama a classe do driver
			con = DriverManager.getConnection(url, user, password);//Passa o usuario,link e a senha
			return con;//Retorna a conexao

		} catch (Exception e) {

			System.out.println("Erro: " + e.getMessage());
			return null;

		}
	}

	public void testeConexao() {

		try {
			Connection con = conectar();//Chama a função de conexao com o banco de dados
			System.out.println(con);//Mostra se conectou ou não
			System.out.println("----------------------");
			System.out.println("Conexao com banco de dados");
			System.out.println("----------------------");
			con.close();//Fecha a conexao

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

}
