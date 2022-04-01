package Model;

public class Pizza {
	
	private int Idpizza;
	private String Nome;
	private float Preco;
	private String Tamanhopizza;
	private String Disponivel;
	public int getIdpizza() {
		return Idpizza;
	}
	public void setIdpizza(int idpizza) {
		Idpizza = idpizza;
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
	public String getTamanhopizza() {
		return Tamanhopizza;
	}
	public void setTamanhopizza(String tamanhopizza) {
		Tamanhopizza = tamanhopizza;
	}
	public String getDisponivel() {
		return Disponivel;
	}
	public void setDisponivel(String disponivel) {
		Disponivel = disponivel;
	}
	public Pizza() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pizza(int idpizza, String nome, float preco, String tamanhopizza, String disponivel) {
		super();
		Idpizza = idpizza;
		Nome = nome;
		Preco = preco;
		Tamanhopizza = tamanhopizza;
		Disponivel = disponivel;
	}
	
	

}
