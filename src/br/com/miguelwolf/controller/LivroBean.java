package br.com.miguelwolf.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.com.miguelwolf.bd.EditoraBD;
import br.com.miguelwolf.bd.LivroBD;
import br.com.miguelwolf.entidades.Editora;
import br.com.miguelwolf.entidades.Livro;

@Named(value = "livroBean")
@ManagedBean
@ViewScoped
public class LivroBean implements Serializable{

	Livro livro;
	String resultado;
	List<Editora> editoras;
	List<Livro> livros;
	LivroDataModel livroModel;
	
	LivroBD livroBD;

	@PostConstruct
	public void init() {
		livroBD = new LivroBD();
		livro = new Livro();
		livros = livroBD.consultarLivros();
		editoras = new EditoraBD().consultarEditoras();
		livroModel = new LivroDataModel(livros);
	}

	public void salvar() {
		if (livroBD.salvar(livro)) {
			resultado = "Sucesso!";
		} else {
			resultado = "Falha";
		}
	}
	
	public void atualizar() {
		if (livroBD.atualizar(livro)) {
			livros = new LivroBD().consultarLivros();
			resultado = "Sucesso!";
		} else {
			resultado = "Falha";
		}
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public List<Editora> getEditoras() {
		return editoras;
	}

	public void setEditoras(List<Editora> editoras) {
		this.editoras = editoras;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public void onRowSelect(SelectEvent event) {
		Livro l = (Livro) event.getObject();
		setLivro(l);
	}

	public LivroDataModel getLivroModel() {
		return livroModel;
	}

	public void setLivroModel(LivroDataModel livroModel) {
		this.livroModel = livroModel;
	}

}
