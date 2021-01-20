package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Article")
public class Article implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idart")
	int idart;
	String nom;
	int prix;
	String image;

	@JsonCreator
	public Article(@JsonProperty("nom") String nom,@JsonProperty("prix") int prix,@JsonProperty("image") String image) {
		super();
 		this.nom = nom;
		this.prix = prix;
		this.image = image;
	}

	public Article(String nom, int prix, String image, Categorie categorie) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.image = image;
		this.categorie = categorie;
	}

	public Article(Command command, Categorie categorie) {
		super();
		this.command = command;
		this.categorie = categorie;
	}

	public Article() {
		super();
	}

	public int getIdart() {
		return idart;
	}

	public void setIdart(int idart) {
		this.idart = idart;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@ManyToOne
	private Command command;

	@ManyToOne
	private Categorie categorie;

}
