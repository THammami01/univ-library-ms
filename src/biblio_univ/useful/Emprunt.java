package biblio_univ.useful;

public class Emprunt {

	private int id;
	private int idLivre;
	private int idAbonne;
	private String dateEmpruntComplet;
	
	public Emprunt() {
		id = -1;
		idLivre = -1;
		idAbonne = -1;
		dateEmpruntComplet = null;
	}

	public Emprunt(int id) {
		this();
		this.id = id;
	}
	
	public Emprunt(int id, int idLivre, int idAbonne) {
		this.id = id;
		this.idLivre = idLivre;
		this.idAbonne = idAbonne;
		this.dateEmpruntComplet = null;
	}
	
	public Emprunt(int id, int idLivre, int idAbonne, String dateEmpruntComplet) {
		this(id, idLivre, idAbonne);
		this.dateEmpruntComplet = dateEmpruntComplet;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdLivre() {
		return idLivre;
	}
	
	public void setIdLivre(int idLivre) {
		this.idLivre = idLivre;
	}
	
	public int getIdAbonne() {
		return idAbonne;
	}
	
	public void setIdAbonne(int idAbonne) {
		this.idAbonne = idAbonne;
	}
	
	public String getDateAjoutComplet() {
		return dateEmpruntComplet;
	}
	
	public String toString() {
		return id + " " + idLivre + " " + idAbonne + " " + dateEmpruntComplet;
	}


}
