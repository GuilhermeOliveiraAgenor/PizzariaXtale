package Model;

public class Borda {

	private int Idborda;
	private String Nomeborda;
	private float Preco;
	
	
	public int getIdborda() {
		return Idborda;
	}
	public void setIdborda(int idborda) {
		Idborda = idborda;
	}
	public String getNomeborda() {
		return Nomeborda;
	}
	public void setNomeborda(String nomeborda) {
		Nomeborda = nomeborda;
	}
	public float getPreco() {
		return Preco;
	}
	public void setPreco(float preco) {
		Preco = preco;
	}
	public Borda() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Borda(int idborda, String nomeborda, float preco) {
		super();
		Idborda = idborda;
		Nomeborda = nomeborda;
		Preco = preco;
	}
	
	
}
