package br.com.miguelwolf.controller;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import br.com.miguelwolf.entidades.Editora;

public class EditoraDataModel extends ListDataModel<Editora> implements SelectableDataModel<Editora> {  

    public EditoraDataModel() {
    }

    public EditoraDataModel(List<Editora> data) {
        super(data);
    }

    @Override
    public Editora getRowData(String rowKey) {
    	
    	List<Editora> editoras = (List<Editora>) getWrappedData();

        for(Editora edt : editoras) {
            if(edt.getCodEditora() == Integer.parseInt(rowKey))
                return edt;
        }

        return null;
    }

    @Override
    public Object getRowKey(Editora e) {
        return e.getCodEditora();
    }

}