package com.haylton.estudo.dao;

import java.io.Serializable;

import com.haylton.estudo.model.Item;

public class ItemDAO<T> extends DAOGenerico<Item> implements Serializable {
	
	public ItemDAO() {
		super();//chamo o construtor de DAOGenerico para inicializar a entityManager EM
		classePersistente = Item.class;//classePersistence e ordem est�o visivel pra mim pq s�o atributos protected e n�o preciso usar get ou set pois est�o em n�vel de pacote e EstadoDAO � uma classe filha de DAOGenerico<>
		ordem = "titulo";//ser� usado para escolha de ordem inicial da consulta para ser montada na page
	}
}
