package cadastro.model;

import java.util.ArrayList;

public class BancoDados {
	
	ArrayList<Usuario> usuarios;
	
	public BancoDados() {
		usuarios = new ArrayList<>();
	}
	
	public Usuario AdicionarUsuario(String nome, String cpf, String fone, String email) {
		for (int i = 0; i < usuarios.size(); i++) {
			usuarios.add(i, AdicionarUsuario(nome, cpf, fone, email));
		}
		return null;
		
	}
	
	public Usuario EncontrarUsuarioPorNome(String nome) {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getNome() == nome)
				return usuarios.get(i);
		}
		return null;
	}
	
	public Usuario EncontrarUsuarios(Usuario Pessoa) {
		for (Usuario usuarioo : usuarios) {
			EncontrarUsuarioPorNome(usuarioo.getNome());
		}
		return null;
		
	}
	
	public void CaderninhoDoKira(Usuario nome) {
		usuarios.remove(EncontrarUsuarios(nome));
	}
	
	public void AtualizarUsuario(String nome, Usuario novo) {
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getNome() == nome)
				usuarios.set(i, novo);
		}
	}
}
