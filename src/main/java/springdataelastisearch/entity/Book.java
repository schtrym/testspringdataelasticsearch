package springdataelastisearch.entity;

import java.io.Serializable;

public class Book implements Serializable {
	
	private static final long serialVersionUID = -5905452954145464861L;

	private String title;
	
	private String serie;
	
	private String editor;
	
	private Double price;

	public String getTitle() {
		return title;
	}

	public String getSerie() {
		return serie;
	}

	public String getEditor() {
		return editor;
	}

	public Double getPrice() {
		return price;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
