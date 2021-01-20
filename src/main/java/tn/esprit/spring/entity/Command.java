package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Command")
public class Command implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCmd")
	private int idCmd;
	private Date dateLivraison;
	
	@JsonCreator	
	public Command(@JsonProperty("dateLivraison") Date dateLivraison) {
		super();
		this.dateLivraison = dateLivraison;
	}
	@OneToMany(mappedBy = "command", cascade = CascadeType.ALL)
	private Set<Article> articles;
	
	public int getIdCmd() {
		return idCmd;
	}
	public void setIdCmd(int idCmd) {
		this.idCmd = idCmd;
	}
	public Date getDateLivraison() {
		return dateLivraison;
	}
	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}
	public Set<Article> getArticles() {
		return articles;
	}
	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
	public Command() {
		super();
	}


}
