package Model;

public class Ingredientes {


	private int idIngrediente;
	private String Nome;
	private String Unidadedemedida;
	private int Quantidade;
	private String Disponivel;
	
	public int getIdIngrediente() {
		return idIngrediente;
	}
	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getUnidadedemedida() {
		return Unidadedemedida;
	}
	public void setUnidadedemedida(String unidadedemedida) {
		Unidadedemedida = unidadedemedida;
	}
	public int getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}
	public String getDisponivel() {
		return Disponivel;
	}
	public void setDisponivel(String disponivel) {
		Disponivel = disponivel;
	}
	public Ingredientes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ingredientes(int idIngrediente, String nome, String unidadedemedida, int quantidade, String disponivel) {
		super();
		this.idIngrediente = idIngrediente;
		Nome = nome;
		Unidadedemedida = unidadedemedida;
		Quantidade = quantidade;
		Disponivel = disponivel;
	}
	
	
	
}
