package Model;

public class Administrador {
	
	private String Nome ;
	private String Email;
	private String Cpf;
	private String Senha;
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCpf() {
		return Cpf;
	}
	public void setCpf(String cpf) {
		Cpf = cpf;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	public Administrador() {
		super();
		
	}
	public Administrador(String nome, String email, String cpf, String senha) {
		super();
		Nome = nome;
		Email = email;
		Cpf = cpf;
		Senha = senha;
	}
	
	
	
}
