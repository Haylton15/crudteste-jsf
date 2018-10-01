package com.haylton.estudo.jsf;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="hellow")
@SessionScoped
public class HelloWorldBean implements Serializable {
	private static final long serialVersionUID= 1L;
	
	private String name;
	
	public String hello() {
		System.out.println("Chamando helloWorld.xhtml");
		return "success";
	}
	
	public String getCurrentTime() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM-yyyy HH:mm:ss"));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
