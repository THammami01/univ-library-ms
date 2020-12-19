package biblio_univ.useful;

public class Livre {

	private int id;
	private String titre;
	private String isbn;
	private String dateAjoutComplet;
	
	public Livre() {
		id = -1;
		titre = "...";
		isbn = "...";
		this.dateAjoutComplet = null;
	}

	public Livre(int id) {
		this();
		this.id = id;
	}
	
	public Livre(int id, String titre, String isbn) {
		this.id = id;
		this.titre = titre;
		this.isbn = isbn;
		this.dateAjoutComplet = null;
	}
	
	public Livre(int id, String titre, String isbn, String dateAjoutComplet) {
		this(id, titre, isbn);
		this.dateAjoutComplet = dateAjoutComplet;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public String getISBN() {
		return isbn;
	}
	
	public void setISBN(String isbn) {
		this.isbn = isbn;
	}
	
	public String getDateAjoutComplet() {
		return dateAjoutComplet;
	}
	
	public String toString() {
		return id + " " + titre + " " + isbn + " " + dateAjoutComplet;
	}

}
