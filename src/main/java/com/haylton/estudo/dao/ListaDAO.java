package com.haylton.estudo.dao;

import java.io.Serializable;

import com.haylton.estudo.model.Lista;

public class ListaDAO<T> extends DAOGenerico<Lista> implements Serializable {
	
	public ListaDAO() {
		super();
		classePersistente = Lista.class;
		ordem = "id";
	}
}
