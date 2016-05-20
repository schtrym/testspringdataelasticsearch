package springdataelastisearch.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "go4book", type = "book")
@org.springframework.data.mongodb.core.mapping.Document(collection="book")
public class Book implements Serializable {

	private static final long serialVersionUID = -5905452954145464861L;

	@Id
	private String id;

	private String reference;

	private String titre;

	private String designation;

	private String editeur;

	private String serie;

	private String numero_serie;

	private String auteur1;

	private String auteur2;

	private String auteur3;

	private String title;

	private Double price;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public String getReference() {
		return reference;
	}

	public String getTitre() {
		return titre;
	}

	public String getDesignation() {
		return designation;
	}

	public String getEditeur() {
		return editeur;
	}

	public String getSerie() {
		return serie;
	}

	public String getNumero_serie() {
		return numero_serie;
	}

	public String getAuteur1() {
		return auteur1;
	}

	public String getAuteur2() {
		return auteur2;
	}

	public String getAuteur3() {
		return auteur3;
	}

	public String getTitle() {
		return title;
	}

	public Double getPrice() {
		return price;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public void setNumero_serie(String numero_serie) {
		this.numero_serie = numero_serie;
	}

	public void setAuteur1(String auteur1) {
		this.auteur1 = auteur1;
	}

	public void setAuteur2(String auteur2) {
		this.auteur2 = auteur2;
	}

	public void setAuteur3(String auteur3) {
		this.auteur3 = auteur3;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
