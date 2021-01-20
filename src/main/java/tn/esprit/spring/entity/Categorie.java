package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Categorie")
public class Categorie implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcat")
	int idcat;
	String nomcat;

	@JsonCreator
	public Categorie(@JsonProperty("nomcat") String nomcat) {
		super();
 		this.nomcat = nomcat;
	}

	public int getIdcat() {
		return idcat;
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

	public void setIdcat(int idcat) {
		this.idcat = idcat;
	}

	public String getNomcat() {
		return nomcat;
	}

	public void setNomcat(String nomcat) {
		this.nomcat = nomcat;
	}

	@OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
	private Set<Article> articles;

	public Categorie() {
		super();
	}

}
