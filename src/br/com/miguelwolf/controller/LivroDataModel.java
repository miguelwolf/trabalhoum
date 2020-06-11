package br.com.miguelwolf.controller;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import br.com.miguelwolf.entidades.Livro;

public class LivroDataModel extends ListDataModel<Livro> implements SelectableDataModel<Livro> {  

    public LivroDataModel() {
    }

    public LivroDataModel(List<Livro> data) {
        super(data);
    }

    @Override
    public Livro getRowData(String rowKey) {
    	
    	List<Livro> livros = (List<Livro>) getWrappedData();

        for(Livro liv : livros) {
            if(liv.getCodLivro() == Integer.parseInt(rowKey))
                return liv;
        }

        return null;
    }

    @Override
    public Object getRowKey(Livro l) {
        return l.getCodLivro();
    }

}