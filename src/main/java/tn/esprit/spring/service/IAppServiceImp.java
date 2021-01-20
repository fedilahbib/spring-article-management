package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Article;
import tn.esprit.spring.entity.Categorie;
import tn.esprit.spring.entity.Command;
import tn.esprit.spring.repository.ArticleRepository;
import tn.esprit.spring.repository.CatergorieRepository;
import tn.esprit.spring.repository.CommandRepository;
 
@Service
public class IAppServiceImp implements IAppService {

	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	CatergorieRepository catergorieRepository;
	@Autowired
	CommandRepository commandRepository;
	
	@Override 
	public void ajouterCategorie(Categorie cat) {
		catergorieRepository.save(cat);
		
	}

	@Override
	public void ajouterArticle(Article article) {
		articleRepository.save(article);
	}

	@Override
	public void ajouterCommande(Command c) {
		commandRepository.save(c);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affecteArtCat(int idcat, int idart) {
		Optional<Article> optional=articleRepository.findById(idart);	
		Optional<Categorie> optionalCat=catergorieRepository.findById(idcat);	

		if(optional!=null&&optionalCat!=null)
		{
			Article article=optional.get();
			Categorie categorie=optionalCat.get();
			article.setCategorie(categorie);
			articleRepository.save(article);
		}
	}

	@Override
	public void affecterArtCmd(int idcmd, int idart) {
		Optional<Article> optional=articleRepository.findById(idart);	
		Optional<Command> optionalCat=commandRepository.findById(idart);	

		if(optional!=null&&optionalCat!=null)
		{
			Article article=optional.get();
			Command command=optionalCat.get();
			article.setCommand(command); 
			articleRepository.save(article);
		}
	}

	@Override
	public List<String> getAllCategories() {
		List list=new ArrayList<String>();
		Iterable<Categorie> optionalIterable=catergorieRepository.findAll();	

		Iterator<Categorie> a=optionalIterable.iterator();
		while(a.hasNext())
		{
			list.add(a.next().getNomcat());
				}
		return list;
	}

	@Override
	public List<String> getAllArticleNamesByCategorie(int idmacategorie) {
		List list=new ArrayList<String>();
		Iterable<Article> optionalIterable=articleRepository.findAll();	
 	 
		Iterator<Article> a=optionalIterable.iterator();
		while(a.hasNext())
		{
			Article article=a.next();
			if(article.getCategorie().getIdcat()==idmacategorie)
			list.add(article.getCategorie().getNomcat());
			
		}	
		return list;
	}
	public List<Categorie> getCategorieList(){
		List list=new ArrayList<Categorie>();
		Iterable<Categorie> optionalIterable=catergorieRepository.findAll();	

		Iterator<Categorie> a=optionalIterable.iterator();
		while(a.hasNext())
		{
			list.add(a.next());
				}
		return list;
	

	}

}
