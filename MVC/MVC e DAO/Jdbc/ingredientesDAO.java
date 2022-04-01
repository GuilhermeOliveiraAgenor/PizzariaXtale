package Jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Ingredientes;
import Model.Produto;

public class ingredientesDAO extends connectionFactory {

	public String inserirIngrediente(Ingredientes ingredientes) {

		String mensagem = "";//string mensagem
		
		try {
			Connection con = conectar();//chama a conexao
			CallableStatement cls = con.prepareCall("{call inseriringredienteAdm(?,?,?)}");//chama a procedure 
			cls.setString(1, ingredientes.getNome());//parametros
			cls.setString(2, ingredientes.getUnidadedemedida());
			cls.setInt(3, ingredientes.getQuantidade());
			int result = cls.executeUpdate();//executa a procedure
			con.close();//fecha a conexao
			
			//o result vai ser igual o numero do execute
			//se o result for maior igual a 1 vai mostrar a mensagem
			if(result >= 1) {
				
				mensagem = "Cadastrado com sucesso";
				
			}
		
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
			mensagem = e.getMessage();//mostra mensagem de erro
		}
		
		return mensagem;//retorna mensagem de erro
		
	}

	public String alterarIngredientes(Ingredientes ingredientes) {
		
		String mensagem = "";//string de mensagem
		
		try {
			Connection con = conectar();//chama a conexao
			CallableStatement cls = con.prepareCall("{call alteraringredienteAdm(?,?,?,?,?)}");//chama a procedure
			cls.setInt(1, ingredientes.getIdIngrediente());//parametros
			cls.setString(2, ingredientes.getNome());
			cls.setString(3, ingredientes.getUnidadedemedida());
			cls.setInt(4, ingredientes.getQuantidade());
			cls.setString(5, ingredientes.getDisponivel());
			int result = cls.executeUpdate();//executa a procedure
			con.close();//fecha a conexao
			

			//o result vai ser igual o numero do execute
			//se o result for maior igual a 1 vai mostrar a mensagem
		if(result >= 1){
			
			mensagem = "Alterado com sucesso";
		}
			
		}
		
		catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
			mensagem = e.getMessage();//mostra a mensagem de erro
		}
		return mensagem;//retorna a mensagem de erro
	
	}

	public void excluirIngredientes(Ingredientes ingredientes) {
		try {
			Connection con = conectar();//abrir a conexao
			CallableStatement cls = con.prepareCall("{call excluiringredienteAdm(?)}");//chamar a procedure
			cls.setInt(1, ingredientes.getIdIngrediente());//parametros
			cls.executeUpdate();//executa a procedure
			con.close();//fecha a conexao
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());//mostrar mensagem de erro no console
		}

	}

	public ArrayList<Ingredientes> selecionarIngredientes() {

		ArrayList<Ingredientes> listaringredientes = new ArrayList<>();

		String sql = "select *from Ingredientes";//string do sql

		try {
			Connection con = conectar();//chamar conexao
			PreparedStatement pst = con.prepareStatement(sql);//chamar a string sql
			ResultSet rs = pst.executeQuery();//executa o select

			while (rs.next()) {

				int idIngredientes = rs.getInt(1);//parametros
				String Nome = rs.getString(2);
				String Unidadedemedida = rs.getString(3);
				int Quantidade = rs.getInt(4);
				String Disponivel = rs.getString(5);

				listaringredientes.add(new Ingredientes(idIngredientes,Nome, Unidadedemedida, Quantidade, Disponivel));//adicionar lista no array
			}
			con.close();//fechar a conexao
			return listaringredientes;//retornar lista
		} catch (Exception e) {
			System.out.println("Erro : " + e.getMessage());//mostrar a mensagem de erro no console
			return null;
		}
	}
	
	public void selecionaringredienteCodigo(Ingredientes ingredientes) {
		
		String sql = "select *from Ingredientes where idIngrediente = ?";//string do sql
		
		try {
			
			Connection con = conectar();//chamar conexao 
			PreparedStatement pst = con.prepareStatement(sql);//chamar string sql
			pst.setInt(1, ingredientes.getIdIngrediente());//parametros
			ResultSet rs = pst.executeQuery();//executar select
			while(rs.next()) {
				ingredientes.setIdIngrediente(rs.getInt(1));//parametros
				ingredientes.setNome(rs.getString(2));
				ingredientes.setUnidadedemedida(rs.getString(3));
				ingredientes.setQuantidade(rs.getInt(4));
				ingredientes.setDisponivel(rs.getString(5));
				
			}
			con.close();//fechar conexao	
		}
		catch(Exception e){
			
			System.out.println(e.getMessage());//mostrar mensagem de erro no console
			
		}
		
	}
	
	
	}

	
