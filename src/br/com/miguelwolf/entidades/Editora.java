package br.com.miguelwolf.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Editora {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codEditora;
	
	private String nomeEditora;	
	
	public Editora() {
		super();
	}
	
	public Editora(String nomeEditora) {
		super();
		this.nomeEditora = nomeEditora;
	}
	
	public Editora(int codEditora, String nomeEditora) {
		super();
		this.codEditora = codEditora;
		this.nomeEditora = nomeEditora;
	}

	public int getCodEditora() {
		return codEditora;
	}

	public void setCodEditora(int codEditora) {
		this.codEditora = codEditora;
	}

	public String getNomeEditora() {
		return nomeEditora;
	}

	public void setNomeEditora(String nomeEditora) {
		this.nomeEditora = nomeEditora;
	}
	
	 @Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + codEditora;
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
			Editora other = (Editora) obj;
			if (codEditora != other.codEditora)
				return false;
			return true;
		}
	
}
