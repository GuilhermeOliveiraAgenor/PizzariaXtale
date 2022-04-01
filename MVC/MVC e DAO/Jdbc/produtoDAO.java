package Jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Produto;

public class produtoDAO extends connectionFactory {
	
	public String inserirProduto(Produto produto) {
		
		String mensagem = "";//string mensagem
		
		try {
			Connection con = conectar();//chamar a conexao
			CallableStatement cls = con.prepareCall("{call inserirprodutoAdm(?,?,?,?)}");//chamar procedure
			cls.setString(1, produto.getNome());//parametros
			cls.setFloat(2, produto.getPreco());
			cls.setInt(3, produto.getCategoria());
			cls.setInt(4, produto.getEstoque());
			int result = cls.executeUpdate();//executar procedure
			con.close();//fechar conexao
			

			//o result vai ser igual o numero do execute
			//se o result for maior igual a 1 vai mostrar a mensagem
			if(result >= 1) {
				
				mensagem = "Cadastrado com sucesso";
				
			}
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
			mensagem = e.getMessage();//retorna mensagem de erro

		}
		
		return mensagem;//retorna mensagem
	}
	
	public String alterarProduto(Produto produto) throws SQLException {
		
		String mensagem = "";//string mensagem
		
		try {
			Connection con = conectar();//chamar conexao
			CallableStatement cls = con.prepareCall("{call alterarprodutoAdm(?,?,?,?,?)}");//chamar procedure
			cls.setInt(1, produto.getIdproduto());//parametros
			cls.setString(2, produto.getNome());
			cls.setFloat(3, produto.getPreco());
			cls.setInt(4, produto.getCategoria());
			cls.setInt(5, produto.getEstoque());
			int result =  cls.executeUpdate();//executa procedure
			con.close();//fechar conexao
			

			//o result vai ser igual o numero do execute
			//se o result for maior igual a 1 vai mostrar a mensagem
			if(result >= 1)
			{
				mensagem = "Alterado com sucesso";
			}	
		
		} catch (Exception e) {
			mensagem = e.getMessage();//mostrar mensagem de erro
			System.out.println("Erro" + e.getMessage());
		}
		
		return mensagem;//retornar mensagem de erro	
	}
	
	public void excluirProduto(Produto produto) {
		try {
			Connection con = conectar();//chamar conexao
			CallableStatement cls = con.prepareCall("{call excluirProduto(?)}");//chamar procedure
			cls.setInt(1, produto.getIdproduto());//parametros
			int exec = cls.executeUpdate();//executa a procedure
			con.close();//fecha a conexao
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());//mostra a mensagem de erro no console
		}
		
		
	}
	
public ArrayList<Produto> selecionarProduto() {
	
	ArrayList<Produto> listaproduto = new ArrayList<>();
	
	String sql = "select *from Produto";
	
	try {
		Connection con = conectar();
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			
			int Idproduto = rs.getInt(1);
			String Nome = rs.getString(2);
			float Preco = rs.getFloat(3);
			int Categoria = rs.getInt(4);
			int Estoque = rs.getInt(5);
	
			listaproduto.add(new Produto(Idproduto,Nome,Preco,Categoria,Estoque));
		}
		con.close();
		return listaproduto;
	}
	 catch (Exception e) {	
			System.out.println("Erro : " + e.getMessage());
			return null;
		}
	}

	public void selecionarprodutoCodigo(Produto produto) {
		
		String sql = "select *from Produto where Idproduto = ?";
		
		try {
			
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, produto.getIdproduto());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				produto.setIdproduto(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setPreco(rs.getFloat(3));
				produto.setCategoria(rs.getInt(4));
				produto.setEstoque(rs.getInt(5));
				
			}
			con.close();
			
		}
		catch(Exception e){
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	
	}

	


