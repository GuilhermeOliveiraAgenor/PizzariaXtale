package Model;

public class Categoria {
	
	private int idCategoria;
	private String Nome;
	
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categoria(int idCategoria, String nome) {
		super();
		this.idCategoria = idCategoria;
		Nome = nome;
	}
	
	
	
	

}
