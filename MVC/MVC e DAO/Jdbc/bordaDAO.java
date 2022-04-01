package Jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.Borda;
import Model.Pizza;

public class bordaDAO extends connectionFactory {

	public String inserirbordAdm(Borda borda) {

		String mensagem = "";//string de mensagem
		
		try {
			Connection con = conectar();//chama a conexao com o banco de dados
			CallableStatement cls = con.prepareCall("{call inserirbordAdm(?,?)}");//chama a procedure
			cls.setString(1, borda.getNomeborda());//parametros
			cls.setFloat(2, borda.getPreco());
			int result = cls.executeUpdate();//executa a procedure
			cls.close();//fecha a conexao

			//o result vai ser igual o numero de linhas do execute
			//se o numero do execute for maior ou igual a 1 vai retornar a mensagem cadastrado
			if(result >= 1) {
				
				mensagem = "Cadastrado com sucesso";
			}
			
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			mensagem = e.getMessage();//mostra a mensagem de erro
			
		}

		return mensagem;//retorna a mensagem de erro
	}

	public String alterarbordAdm(Borda borda) {

		String mensagem = "";//string de mensagem
		
		try {
			Connection con = conectar();//chama a conexao com o banco de dados
			CallableStatement cls = con.prepareCall("{call alterarbordAdm(?,?,?)}");//chama a procedure
			cls.setInt(1, borda.getIdborda());//parametros
			cls.setString(2, borda.getNomeborda());
			cls.setFloat(3, borda.getPreco());
			int result = cls.executeUpdate();//executa a procedure
			cls.close();//fecha a conexao

			//o result vai ser igual o numero que vem do execute do execute
			//se o numero do execute for maior ou igual a 1 vai retornar a mensagem
			if(result >= 1) {
				
				mensagem = "Alterado com sucesso";
			}
			
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			mensagem = e.getMessage();//retorna e mensagem de erro
		}
		
		return mensagem;//mensagem de erro

	}

	public void excluirbordAdm(Borda borda) {
	
		try {
			Connection con = conectar();//chama a conexa
			CallableStatement cls = con.prepareCall("{call excluirbordAdm(?)}");//chama a procedure
			cls.setInt(1, borda.getIdborda());//parametros
			int result = cls.executeUpdate();//executa a procedure
			cls.close();//fecha a conexao

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());//mostra no sistema a mensagem de erro
				
		}

	}
	public ArrayList<Borda> selecionarBorda()
	{
		ArrayList<Borda> listarborda = new ArrayList<>();
		
		String sql = "select *from Borda";//string sql
		
		try {
			Connection con = conectar();//chama a conexao
			PreparedStatement pst = con.prepareStatement(sql);//chama a string sql
			ResultSet rs = pst.executeQuery();//executa o select
			
			while(rs.next()) {
				
				int Idborda = rs.getInt(1);//parametros do construtor
				String Nomeborda = rs.getString(2);
				float Preco = rs.getFloat(3);
				
				listarborda.add(new Borda(Idborda,Nomeborda,Preco));//adiciona na lista do array
			}
			con.close();//fecha a conexao
			return listarborda;//retorna a lista
		}
		 catch (Exception e) {
				System.out.println("Erro : " + e.getMessage());//mostra a mensagem de erro no sistema
				return null;
			}
	}
	public void selecionarbordaCodigo(Borda borda)
	{
		String sql = "select *from Borda where Idborda = ?";//string sql
		
		try {

			Connection con = conectar();//chama a conexao
			PreparedStatement pst = con.prepareStatement(sql);//chama a string sql 
			pst.setInt(1, borda.getIdborda());//parametros
			ResultSet rs = pst.executeQuery();//executa o select
			
			while(rs.next()) {
				borda.setIdborda(rs.getInt(1));//parametros
				borda.setNomeborda(rs.getString(2));
				borda.setPreco(rs.getFloat(3));
			}
			con.close();//fecha a conexao
		}
		 catch (Exception e) {
				System.out.println("Erro : " + e.getMessage());//mostra a mensagem de erro
			
			}
	}

}
