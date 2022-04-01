package Model;

public class Produto {
	
	private int Idproduto;
	private String Nome;
	private float Preco;
	private int Categoria;
	private int Estoque;
	public int getIdproduto() {
		return Idproduto;
	}
	public void setIdproduto(int idproduto) {
		Idproduto = idproduto;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public float getPreco() {
		return Preco;
	}
	public void setPreco(float preco) {
		Preco = preco;
	}
	public int getCategoria() {
		return Categoria;
	}
	public void setCategoria(int categoria) {
		Categoria = categoria;
	}
	public int getEstoque() {
		return Estoque;
	}
	public void setEstoque(int estoque) {
		Estoque = estoque;
	}
	public Produto() {
		super();
		
	}
	public Produto(int idproduto, String nome, float preco, int categoria, int estoque) {
		super();
		Idproduto = idproduto;
		Nome = nome;
		Preco = preco;
		Categoria = categoria;
		Estoque = estoque;
	}
	
	
	
}