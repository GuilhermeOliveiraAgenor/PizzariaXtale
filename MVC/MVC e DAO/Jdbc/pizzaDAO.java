package Jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.jasper.tagplugins.jstl.core.Out;

import Model.Pizza;
import Model.Produto;

public class pizzaDAO extends connectionFactory {
	
	public String inserirpizzAdm(Pizza pizza) {
		
		String mensagem = "";//string de mensagem
		
		try {
			Connection con = conectar();//chamar conexao
			CallableStatement cls = con.prepareCall("{call inserirpizzAdm(?,?,?)}");//chamar procedure
			cls.setString(1, pizza.getNome());//parametros
			cls.setFloat(2, pizza.getPreco());
			cls.setString(3, pizza.getTamanhopizza());
			int result = cls.executeUpdate();//executa a procedure
			cls.close();//fecha a conexao
			
			//o result vai ser igual o numero do execute
			//se o result for maior igual a 1 vai mostrar a mensagem
			if(result >= 1) {
				
				mensagem = "Cadastrado com sucesso";
			}
			
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			mensagem = e.getMessage();//retorna a mensagem de erro
		}
		
		return mensagem;//retorna mensagem 
		
	}
	public String alterarpizzAdm(Pizza pizza) {
		
		String mensagem = "";//string de mensagem
		
		try {
			Connection con = conectar();//chamar conexao
			CallableStatement cls = con.prepareCall("{call alterarpizzAdm(?,?,?,?,?)}");//chamar a procedure
			cls.setInt(1, pizza.getIdpizza());//parametros
			cls.setString(2, pizza.getNome());
			cls.setFloat(3, pizza.getPreco());
			cls.setString(4, pizza.getTamanhopizza());
			cls.setString(5, pizza.getDisponivel());
			int result = cls.executeUpdate();//executa a procedure
			cls.close();//fecha a conexao
			

			//o result vai ser igual o numero do execute
			//se o result for maior igual a 1 vai mostrar a mensagem
			if(result >= 1) {
				
				mensagem = "Alterado com sucesso";
				
			}
			
		} catch (Exception e) {
			System.out.println("Erro: "+ e.getMessage());
			mensagem = e.getMessage();//retornar mensagem de erro
		}
		
		return mensagem;//retorna mensagem de erro
		
	}
	public void excluirpizzAdm(Pizza pizza) {
		
		try {
			Connection con = conectar();//chamar conexao
			CallableStatement cls = con.prepareCall("{call excluirpizzAdm(?)}");//chamar  procedure
			cls.setInt(1, pizza.getIdpizza());//parametros
			cls.execute();//executa a procedure
			cls.close();//fecha a conexao
			
		} catch (Exception e) {
			System.out.println("Erro: "+ e.getMessage());//mostrar mensagem de erro no console
		}
		
	}
	
	public ArrayList<Pizza> selecionarPizza()
	{
		ArrayList<Pizza> listarpizza = new ArrayList<>();
		
		String sql = "select *from Pizza";//string sql
		
		try {
			Connection con = conectar();//chamar conexao
			PreparedStatement pst = con.prepareStatement(sql);//chamar string sql
			ResultSet rs = pst.executeQuery();//executar select
			
			while(rs.next()) {
				
				int Idpizza = rs.getInt(1);//parametros
				String Nome = rs.getString(2);
				float Preco = rs.getFloat(3);
				String Tamanhopizza = rs.getString(4);
				String Disponivel = rs.getString(5);
				
		
				listarpizza.add(new Pizza(Idpizza,Nome,Preco,Tamanhopizza,Disponivel));//adicinar lista no array
			}
			con.close();//fechar conexao
			return listarpizza;//retornar lista
		}
		 catch (Exception e) {
				System.out.println("Erro : " + e.getMessage());//mostrar mensagem de erro no console
				return null;
			}
	}
	
	public void selecionarpizzaCodigo(Pizza pizza)
	{
		String sql = "select *from Pizza where Idpizza = ?";//string sql
		
		try {

			Connection con = conectar();//chamar conexao
			PreparedStatement pst = con.prepareStatement(sql);//chamar string sql
			pst.setInt(1, pizza.getIdpizza());//parametros
			ResultSet rs = pst.executeQuery();//executar select
			
			while(rs.next()) {
				
				pizza.setIdpizza(rs.getInt(1));//parametros
				pizza.setNome(rs.getString(2));
				pizza.setPreco(rs.getFloat(3));
				pizza.setTamanhopizza(rs.getString(4));
				pizza.setDisponivel(rs.getString(5));
				
			}
			con.close();//fechar conexao
		}
		 catch (Exception e) {
				System.out.println("Erro : " + e.getMessage());//mostrar mensagem de erro no console
			
			}
	}
}
		
	
	
	

