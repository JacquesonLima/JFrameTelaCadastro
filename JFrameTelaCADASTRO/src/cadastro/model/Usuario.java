package cadastro.model;

public class Usuario extends Pessoa{

	private String login;
	private String senha;
	
	public Usuario(String nome, String cpf, String email) {
		super(nome, cpf, email);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
}
