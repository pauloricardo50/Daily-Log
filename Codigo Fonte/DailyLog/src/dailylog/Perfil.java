/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import java.util.ArrayList;
import persistencia.PerfilBD;
import persistencia.PermissaoBD;

/**
 *
 * @author Jardielma e Paulo Ricardo
 */
public class Perfil {
	private int id;
	private String descricao;
	private String horarioPadraoInicial;
	private String horarioPadraoFinal;
	private int tamanhoFonte;
	private boolean autoContraste;
	private PerfilBD persistencia;
	private ArrayList<Permissao> permissoes;

	/* Getters */
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public String getHorarioPadraoInicial() {
		return horarioPadraoInicial;
	}

	public String getHorarioPadraoFinal() {
		return horarioPadraoFinal;
	}

	public int getTamanhoFonte() {
		return tamanhoFonte;
	}

	public boolean getAutoContraste() {
		return autoContraste;
	}

	public String getDescricao() {
		return descricao;
	}

	public ArrayList<Permissao> getPemissoes() {
		return permissoes;
	}

	/**
	 *
	 * @author Lucas Eduardo
	 */
	public class PerfilBuilder()
	{
		private int id;
		private String descricao;
		private String horarioPadraoInicial;
		private String horarioPadraoFinal;
		private int tamanhoFonte;
		private boolean autoContraste;
		private PerfilBD persistencia;
		private ArrayList<Permissao> permissoes;

		/* Instancia um onbjeto PerfilBuilder*/
		public PerfilBuilder() {

		}
		
		/*Adiciona os atributos*/
		public PerfilBuilder setId(int id) {
			this.id = id;
			return this;
		}
	
		public PerfilBuilder setHorarioPadraoInicial(String horarioPadraoInicial) {
			this.horarioPadraoInicial = horarioPadraoInicial;
			return this;
		}
	
		public PerfilBuilder setHorarioPadraoFinal(String horarioPadraoFinal) {
			this.horarioPadraoFinal = horarioPadraoFinal;
			return this;
		}
	
		public PerfilBuilder setTamanhoFonte(int tamanhoFonte) {
			this.tamanhoFonte = tamanhoFonte;
			return this;
		}
	
		public PerfilBuilder setAutoContraste(boolean autoContraste) {
			this.autoContraste = autoContraste;
			return this;
		}
	
		public PerfilBuilder setDescricao(String descricao) {
			this.descricao = descricao;
			return this;
		}
	
		public PerfilBuilder setPermissoes(ArrayList<Permissao> permissao) {
			this.permissoes = permissao;
			return this;
		}
	
		
		/*Cria e retorna um objeto Perfil*/
		public Perfil criarPerfil() {
			return new Perfil(this);
		}
	}
	
	/*Construtor do Perfil*/
	private Perfil(PerfilBuilder perfil) {
		this.id = perfil.id;
		this.descricao = perfil.descricao;
		this.horarioPadraoInicial = perfil.horarioPadraoInicial;
		this.horarioPadraoFinal = perfil.horarioPadraoFinal;
		this.tamanhoFonte = perfil.tamanhoFonte;
		this.persistencia = perfil.persistencia;
		this.permissoes = perfil.permissoes;
	}


	public Perfil buscar() {

		persistencia = new PerfilBD();
		Perfil perfilRetorno = new Perfil();
		PermissaoBD permissaoBD = new PermissaoBD();
		try {
			// busca e retorna o perfil do usuario
			perfilRetorno = persistencia.buscar(this.id);

			this.id = perfilRetorno.getId();
			this.descricao = perfilRetorno.getDescricao();
			this.horarioPadraoInicial = perfilRetorno.getHorarioPadraoInicial();
			this.horarioPadraoFinal = perfilRetorno.getHorarioPadraoFinal();
			this.tamanhoFonte = perfilRetorno.getTamanhoFonte();
			this.autoContraste = perfilRetorno.getAutoContraste();
			this.permissoes = permissaoBD.listar(this.id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return this;
	}

	/**
	 * Salva o Perfil Método utilizado para salvar e atualizar o perfil do usuário
	 * 
	 * @return
	 */
	public String salvar() {

		persistencia = new PerfilBD();
		Perfil perfilRetorno;
		PermissaoBD permissaoBD = new PermissaoBD();
		try {
			// salva o perfil do usuario
			if (this.getDescricao().length() == 0) {
				return "Descrição Não preenchida";
			}
			if (this.getHorarioPadraoInicial().length() == 0) {
				return "Horario padrão inicial não informado";
			}
			if (this.getHorarioPadraoFinal().length() == 0) {
				return "Horario padrão final não informado";
			}
			if (this.getTamanhoFonte() < 10) {
				return "O tamanho da fonte deve ser maior";
			}

			// salva o perfil
			perfilRetorno = persistencia.salvar(this);

			// Atualiza o id do usuario, tendo em vista que o usuario criado não tinha
			this.id = perfilRetorno.getId();

		} catch (Exception e) {
			System.out.println(e);
		}
		return "Perfil Salvo com sucesso";
	}

	public ArrayList<Perfil> listar() {

		PerfilBD perfilBD = new PerfilBD();
		try {
			// salva o perfil do usuario
			return perfilBD.listar();

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
