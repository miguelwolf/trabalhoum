package br.com.miguelwolf.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.com.miguelwolf.bd.EditoraBD;
import br.com.miguelwolf.bd.LivroBD;
import br.com.miguelwolf.entidades.Editora;
import br.com.miguelwolf.entidades.Livro;

@Named(value = "editoraBean")
@ManagedBean
@ViewScoped
public class EditoraBean implements Serializable{


	Editora editora;
	String resultado;
	List<Editora> editoras;
	EditoraDataModel editoraModel;
	
	EditoraBD editoraBD;

	@PostConstruct
	public void init() {
		editoraBD = new EditoraBD();
		editora = new Editora();
		editoras = editoraBD.consultarEditoras();
		editoraModel = new EditoraDataModel(editoras);
	}

	public void salvar() {
		if (editoraBD.salvar(editora)) {
			resultado = "Sucesso!";
		} else {
			resultado = "Falha";
		}
	}
	
	public void atualizar() {
		if (editoraBD.atualizar(editora)) {
			editoras = editoraBD.consultarEditoras();
			resultado = "Sucesso!";
		} else {
			resultado = "Falha";
		}
	}

	

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
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

	public void onRowSelect(SelectEvent event) {
		Editora e = (Editora) event.getObject();
		setEditora(e);
	}

	public EditoraDataModel getEditoraModel() {
		return editoraModel;
	}

	public void setEditoraModel(EditoraDataModel editoraModel) {
		this.editoraModel = editoraModel;
	}
	
}
