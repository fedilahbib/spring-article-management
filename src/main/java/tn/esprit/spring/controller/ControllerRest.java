package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.Categorie;
import tn.esprit.spring.entity.Command;
 import tn.esprit.spring.service.IAppService;
 

@RestController
@RequestMapping("/exeamen")
public class ControllerRest {

	@Autowired
	IAppService appService;

 //
	@GetMapping("/AllCategories")
	public List<String> getAllCategories() {
		return appService.getAllCategories();
	}

	@GetMapping("/AllArticle/{idmacategorie}")
	public List<String> getAllArticleNamesByCategorie(@PathVariable("idmacategorie") int idmacategorie) {
		return appService.getAllArticleNamesByCategorie(idmacategorie);

	}

	@PutMapping("/cmd/{idcmd}/{idart}")
	public void affecterArtCmd(@PathVariable("idcmd") int idcmd,@PathVariable("idart") int idart) {
		appService.affecterArtCmd(idcmd, idart);
	}

	@PutMapping("/cat/{idcat}/{idart}")
	public void affecteArtCat(@PathVariable("idcat") int idcat,@PathVariable("idart") int idart) {
		appService.affecteArtCat(idcat, idart);
	}

	@PostMapping("/ajouterCategorie")
	public String ajouterCategorie(@RequestBody Categorie str1 ) {
	 appService.ajouterCategorie(str1);
		return "ajouterCategorie";

	}


	@PostMapping("/ajouterCommande")
	public String ajouterCommande(@RequestBody Command c) {
		appService.ajouterCommande(c);
		return "ajouterCommande";

	}

	@PostMapping("/ajouterArticle")
	public String ajouterArticle(@RequestBody Article article) {
		appService.ajouterArticle(article);

		return "ajouterArticle";
	}

}
