package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.Categorie;
import tn.esprit.spring.entity.Command;

public interface IAppService {
	public void ajouterCategorie(Categorie cat);
	public void ajouterArticle(Article article);
	public void ajouterCommande(Command c);
	public void affecteArtCat(int idcat,int idart);
	public void affecterArtCmd(int idcmd,int idart);
	public List<String> getAllCategories();
	public List<String> getAllArticleNamesByCategorie(int idmacategorie);
	public List<Categorie> getCategorieList();


}
