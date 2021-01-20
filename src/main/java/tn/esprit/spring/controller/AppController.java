package tn.esprit.spring.controller;


import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Categorie;
import tn.esprit.spring.service.IAppService;

 


@Scope(value = "session")
@Controller(value = "appController") // Name of the bean in Spring IoC 
@ELBeanName(value = "appController") // Name of the bean used by JSF  
@Join(path = "/", to = "/cat.jsf")
public class AppController {
	
	@Autowired
	IAppService appService;
 
 
	private String nomcat;
	
	public void addCat()
	{
		appService.ajouterCategorie(new Categorie(nomcat));
		

	}
	public String getNomcat() {
		return nomcat;
	}


	public void setNomcat(String nomcat) {
		this.nomcat = nomcat;
	}


	private Categorie categorie;

	public IAppService getAppService() {
		return appService;
	}


	public void setAppService(IAppService appService) {
		this.appService = appService;
	}


 


}
