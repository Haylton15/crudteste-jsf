package com.haylton.estudo.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import com.haylton.estudo.dao.ListaDAO;
import com.haylton.estudo.jsf.Util;
import com.haylton.estudo.model.Lista;

@ManagedBean(name="controleLista")
public class ControleLista implements Serializable{
	
	private ListaDAO<Lista> dao;
	private Lista lista;
	
	public ControleLista() {
		dao = new ListaDAO<>();
	}
	
	public String listar() {
		return "/lista/listar?faces-redirect=true";
	}
	
	public String novo() {
		lista = new Lista();
		return "formulario?faces-redirect=true";
	}
	
	public String salvar() {
		boolean persistiu = false;
		if(lista.getId() == null) {
			persistiu = dao.persist(lista);
		}else {
			persistiu = dao.merge(lista);
		}
		if (persistiu){
            Util.mensagemInformacao(dao.getMensagem());
            return "listar?faces-redirect=true";
        } else {
            Util.mensagemErro(dao.getMensagem());
            return "formulario?faces-redirect=true";
        }
	}
	
	public String cancelar(){
        return "listar?faces-redirect=true";
    }
    
    public String editar(Integer id){
        lista = dao.localizar(id);
        return "formulario?faces-redirect=true";
    }
    
    public void remover(Integer id){
        lista = dao.localizar(id);
        if (dao.remove(lista)){
            Util.mensagemInformacao(dao.getMensagem());
        } else {
            Util.mensagemErro(dao.getMensagem());
        }
    }

	public ListaDAO<Lista> getDao() {
		return dao;
	}

	public void setDao(ListaDAO<Lista> dao) {
		this.dao = dao;
	}

	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}
    
    
	
}
