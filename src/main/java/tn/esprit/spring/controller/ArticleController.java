package tn.esprit.spring.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.Categorie;
import tn.esprit.spring.service.IAppService;

 


@Scope(value = "session")
@Controller(value = "articleController") // Name of the bean in Spring IoC 
@ELBeanName(value = "articleController") // Name of the bean used by JSF  
@Join(path = "/article", to = "/article.jsf")
public class ArticleController {
	
	@Autowired
	IAppService appService;
 
 	private String image;
	private String nom;
	private int prix;
	private ArrayList catList;
	
	private Categorie cat;

	 
	public Categorie getCat() {
		return cat;
	}
	public void setCat(Categorie cat) {
		this.cat = cat;
	}
	public ArrayList getCatList() {
		return (ArrayList) appService.getCategorieList();
	}
	public void setCatList(ArrayList catList) {
		this.catList = catList;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
 

 	public void addArticle()
	{
System.out.println(nom);
 		appService.ajouterArticle(new Article(nom, prix, image,cat));
	
	}
 
 

 


}
