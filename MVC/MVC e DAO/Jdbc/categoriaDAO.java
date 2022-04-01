package Jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Categoria;
import Model.Ingredientes;
import Model.Produto;

public class categoriaDAO extends connectionFactory {
	
	
	public ArrayList<Categoria> selecionarCategoria(){
		
		ArrayList<Categoria> listacategoria = new ArrayList<>();
		
		String sql = "select *from Categoriaproduto";//string sql
		
		try {
			Connection con = conectar();//chama a conexao
			PreparedStatement pst = con.prepareStatement(sql);//chama a string sql
			ResultSet rs = pst.executeQuery();//executa o select
			
			while(rs.next()) {
				
				int idCategoria = rs.getInt(1);//parametros
				String Nome = rs.getString(2);
				
		
				listacategoria.add(new Categoria(idCategoria,Nome));//adiciona na lista do array
				
			}
			con.close();//fecha a conexao
			return listacategoria;//retorna a lista
		}
		 catch (Exception e) {
				System.out.println("Erro : " + e.getMessage());//mostra a mensagem de erro
				return null;
			}
		
		
	}
	public String inserirCategoria(Categoria categoria) {

		String mensagem ="";//string da mensagem
		
		try {
			Connection con = conectar();//chama a conexao
			CallableStatement cls = con.prepareCall("{call inserircategoriAdm(?)}");//chama a procedure
			cls.setString(1, categoria.getNome());//parametros
			int result = cls.executeUpdate();//executa a procedure
			con.close();//fecha a conexao
			
			//o result vai ser igual o numero do execute
			//se o numero do execute for maior ou igual a 1 retorna a mensagem
			if(result >= 1) {
				
				mensagem = "Cadastrado com sucesso";
				
			}
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
			mensagem = e.getMessage();//mostra a mensagem de erro
		}
		
		return mensagem;//retorna a mensagem
	}
	public String alterarCategoria(Categoria categoria) {
		
		String mensagem = "";//string da mensagem
		
		try {
			Connection con = conectar();//chama a conexao
			CallableStatement cls = con.prepareCall("{call alterarcategoriAdm(?,?)}");//chama a procedure
			cls.setInt(1, categoria.getIdCategoria());//parametros
			cls.setString(2, categoria.getNome());
			int result = cls.executeUpdate();//executa a procedure
			con.close();//fecha a conexao
			

			//o result vai ser igual o numero do execute
			//se o numero do execute for maior ou igual a 1 retorna a mensagem
			
			if(result >= 1) {
				
				mensagem = "Alterado com sucesso";
				
			}
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
			mensagem = e.getMessage();//mostra a mensagem de erro
			
		}
		
		return mensagem;//retorna a mensagem de erro
		
	}
	public void excluirCategoria(Categoria categoria) {
		
		try {
			Connection con = conectar();//chamar a conexao
			CallableStatement cls = con.prepareCall("{call excluircategoriAdm(?)}");//chamar a procedure
			cls.setInt(1, categoria.getIdCategoria());//parametros
			cls.executeUpdate();//executa a procedure
			con.close();//fecha a conexao
		
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());//mostra a mensagem de erro no console
				}
		
	}
	
	
	public void selecionarcategorianoCodigo(Categoria categoria) {
		
		String sql = "	select *from Categoriaproduto where idCategoria = ?";//string sql
		
		try {
			
			Connection con = conectar();//chamar a conexao
			PreparedStatement pst = con.prepareStatement(sql);//chamar a string sql
			pst.setInt(1, categoria.getIdCategoria());//parametros
			ResultSet rs = pst.executeQuery();//executa o select
			while(rs.next()) {
				categoria.setIdCategoria(rs.getInt(1));//parametros
				categoria.setNome(rs.getString(2));	
			}
			con.close();//fecha a conexao
			
		}
		catch(Exception e){
			
			System.out.println(e.getMessage());//mostra a mensagem de erro no console
			
		}
		
	}
	
	
	}
	
	
