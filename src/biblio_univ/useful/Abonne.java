package biblio_univ.useful;

import biblio_univ.useful.EstEOuE;

public class Abonne {
	
	private int id;
	private String prenom;
	private String nom;
	private int numTel;
	private EstEOuE estEOuE;
	private String dateAbonnementComplet;
	
	
	public Abonne() {
		id = -1;
		prenom = "...";
		nom = "...";
		numTel = 0;
		estEOuE = EstEOuE.NOT_SET_YET;
		this.dateAbonnementComplet = null;
	}
	
	public Abonne(int id) {
		this();
		this.id = id;
	}
	
	public Abonne(int id, String prenom, String nom, int numTel, EstEOuE estEOuE) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.numTel = numTel;
		this.estEOuE = estEOuE;
		this.dateAbonnementComplet = null;
	}
	
	public Abonne(int id, String prenom, String nom, int numTel, EstEOuE estEOuE, String dateAbonnementComplet) {
		this(id, prenom, nom, numTel, estEOuE);
		this.dateAbonnementComplet = dateAbonnementComplet;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	public String getNom() {
		return nom;
	}
	
	public void getNom(String nom) {
		this.nom = nom;
	}
	
	
	public int getNumTel() {
		return numTel;
	}
	
	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}
	
	
	public EstEOuE getEstEOuE() {
		return estEOuE;
	}
	
	public void setEstEOuE(EstEOuE estEOuE) {
		this.estEOuE = estEOuE;
	}
	
	public String getDateComplet() {
		return dateAbonnementComplet;
	}
	
	public String toString() {
		return id + " " + prenom + " " + nom + " " + 
				(numTel == 0 ? "..." : numTel) + " " + 
				(estEOuE == EstEOuE.NOT_SET_YET ? "..." : estEOuE == EstEOuE.ETUDIANT ? "Etudiant" : "Enseignant");
	}
	
	
}
