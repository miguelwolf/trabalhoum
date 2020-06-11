package br.com.miguelwolf.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codLivro;
	private String nomeLivro;
	@ManyToOne
	private Editora editora;
	
	public Livro() {
		super();
	}

	public Livro(String nomeLivro, Editora editora) {
		super();
		this.nomeLivro = nomeLivro;
		this.editora = editora;
	}
	
	public Livro(Long cod, String nomeLivro, Editora editora) {
		super();
		this.nomeLivro = nomeLivro;
		this.editora = editora;
	}

	public int getCodLivro() {
		return codLivro;
	}

	public void setCodLivro(int codLivro) {
		this.codLivro = codLivro;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
	 @Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + codLivro;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Livro other = (Livro) obj;
			if (codLivro != other.codLivro)
				return false;
			return true;
		}
}
