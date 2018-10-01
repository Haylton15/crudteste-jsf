package com.haylton.estudo.dao;

import java.io.Serializable;

import com.haylton.estudo.model.Item;

public class ItemDAO<T> extends DAOGenerico<Item> implements Serializable {
	
	public ItemDAO() {
		super();//chamo o construtor de DAOGenerico para inicializar a entityManager EM
		classePersistente = Item.class;//classePersistence e ordem estão visivel pra mim pq são atributos protected e não preciso usar get ou set pois estão em nível de pacote e EstadoDAO é uma classe filha de DAOGenerico<>
		ordem = "titulo";//será usado para escolha de ordem inicial da consulta para ser montada na page
	}
}
