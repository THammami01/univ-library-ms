package biblio_univ.useful;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

public class MariaDBConnection {

	private Connection connection;
	private Statement st;
	private ResultSet rs;
	private String query;	

	private boolean hostedOnline = false;
	public String isConnected;

	private String dburlLocal = "jdbc:mariadb://localhost:3306/BiblioUniv";
	private String usernameLocal = "root";
	private String passwordLocal = "";
	
	private String dburlOnline = "jdbc:mariadb://remotemysql.com:3306/zFSKj0KaNq";
	private String usernameOnline = "zFSKj0KaNq";
	private String passwordOnline = "Y3uEhSBH22";
	
	
	public MariaDBConnection() {
		
	    try {
	    	
	    	try {
		    	Class.forName("org.mariadb.jdbc.Driver");	    		
	    	} catch(Exception e) {
	    		isConnected = e.getMessage();
	    	}

	    	
	    	if(hostedOnline)
		        connection = DriverManager.getConnection(dburlOnline, usernameOnline, passwordOnline);	    		
	    	else
		        connection = DriverManager.getConnection(dburlLocal, usernameLocal, passwordLocal);	    		

	        st = connection.createStatement();
	    	        
	    } catch (Exception e) {
	    	isConnected = e.toString();
	    	System.out.println(e);
	    	
	    }
	    		
	}


	public void close() {
		if(connection != null) {
			try {
		        connection.close();			
			} catch(Exception e) {
				System.out.println(e);
			}
			
		}
	}
	
	
	public String[] getCredentials() { 
        String[] credentials = new String[2];
		query = "SELECT * FROM Utilisateurs;";

		try {
    		rs = st.executeQuery(query);
    		
    		rs.next();
   			credentials[0] = rs.getString("nomUtilisateur");
			credentials[1] = rs.getString("motDePasse");
			    		
		} catch (Exception e) {
			credentials[0] = "ERR01";
	    	System.out.println(e);
	    	
	    }
		
		return credentials;
	}

	
	public Abonne rechercherAbonne(int idAbonne) {
		Abonne abonne;
		query = "SELECT * FROM Abonnes WHERE idAbonne = " + idAbonne + ";";
		
		try {

			rs = st.executeQuery(query);
    		
    		if(!rs.next()) {
    			return new Abonne(-2);
    		}
    		
    		String dateComplet = AllInOne.getDateComplet(rs.getTimestamp("date_abonnement"));
    		
    		abonne = new Abonne(
    				rs.getInt("idAbonne"),
    				rs.getString("prenom"),
    				rs.getString("nom"),
    				rs.getInt("num_tel"),
    				rs.getInt("etu_ou_ens") == 0 ? EstEOuE.ETUDIANT : EstEOuE.ENSEIGNANT,
    				dateComplet
    		);
    		
    		return abonne;
			    		
		} catch (Exception e) {
	    	System.out.println(e);
	    	return null;
	    	
	    }
	}
	
	
	public int ajouterAbonne(Abonne nouvAbonne) {
		query = "INSERT INTO Abonnes (nom, prenom, etu_ou_ens, num_tel) VALUES(\"" + 
				nouvAbonne.getNom() + "\", \"" +
				nouvAbonne.getPrenom() + "\", " +
				(nouvAbonne.getEstEOuE() == EstEOuE.ETUDIANT ? 0 : 1) + ", " + 
				nouvAbonne.getNumTel() + ");";
		
		try {
	        if(st.executeUpdate(query) > 0) {
	        	query = "SELECT MAX(idAbonne) as maxId FROM Abonnes;";
	        	rs = st.executeQuery(query);
	    		
	    		rs.next();
	        	return rs.getInt("maxId");
			} else {
	        	return -1;
	        }
		} catch (Exception e) {
	    	System.out.println(e);
	    	return -1;
	    }		
	}
	
	
	public boolean modifierAbonne(Abonne abonneModifie) {
		query = "UPDATE Abonnes SET prenom = \"" + abonneModifie.getPrenom() +
				"\", nom = \"" + abonneModifie.getNom() +
				"\", etu_ou_ens = " + (abonneModifie.getEstEOuE() == EstEOuE.ETUDIANT ? 0 : 1) +
				", num_tel = " + abonneModifie.getNumTel() +
				" WHERE idAbonne = " + abonneModifie.getId() + ";";
		
		try {
	        if(st.executeUpdate(query) > 0) {
	        	return true;
			} else {
	        	return false;
	        }
		} catch (Exception e) {
	    	return false;
	    }	
	}
	
	
	public boolean supprimerAbonne(int idAbonne) {
		query = "DELETE FROM Abonnes WHERE idAbonne = " + idAbonne + ";";
		
		try {
	        if(st.executeUpdate(query) > 0)
	        	return true;
	        else
	        	return false;
		} catch (Exception e) {
	    	System.out.println(e);
	    	return false;
	    }
	}
	
	
	public Livre rechercherLivre(int idLivre) {
		Livre livre;
		query = "SELECT * FROM Livres WHERE idLivre = " + idLivre + ";";
		
		try {

			rs = st.executeQuery(query);
    		
    		if(!rs.next()) {
    			return new Livre(-2);
    		}
    		
    		String dateAjoutComplet = AllInOne.getDateComplet(rs.getTimestamp("date_ajout"));
    		
    		livre = new Livre(
    				rs.getInt("idLivre"),
    				rs.getString("titre"),
    				rs.getString("isbn"),
    				dateAjoutComplet
    		);
    		
    		return livre;
			    		
		} catch (Exception e) {
	    	System.out.println(e);
	    	return null;
	    	
	    }
	}
	
	
	public int ajouterLivre(Livre nouvLivre) {
		query = "INSERT INTO Livres (titre, isbn) VALUES(\"" + 
				nouvLivre.getTitre() + "\", \"" +
				nouvLivre.getISBN() + "\");";
		
		try {
	        if(st.executeUpdate(query) > 0) {
	        	query = "SELECT MAX(idLivre) as maxId FROM Livres;";
	        	rs = st.executeQuery(query);
	    		
	    		rs.next();
	        	return rs.getInt("maxId");
			} else {
	        	return -1;
	        }
		} catch (Exception e) {
	    	System.out.println(e);
	    	return -1;
	    }
	}

	public boolean modifierLivre(Livre livreModifie) {
		query = "UPDATE Livres SET titre = \"" + livreModifie.getTitre() +
				"\", isbn = \"" + livreModifie.getISBN() +
				"\" WHERE idLivre = " + livreModifie.getId() + ";";
		
		try {
	        if(st.executeUpdate(query) > 0) {
	        	return true;
			} else {
	        	return false;
	        }
		} catch (Exception e) {
	    	return false;
	    }
	}
	
	public boolean supprimerLivre(int idLivre) {
		query = "DELETE FROM Livres WHERE idLivre = " + idLivre + ";";
		
		try {
	        if(st.executeUpdate(query) > 0)
	        	return true;
	        else
	        	return false;
		} catch (Exception e) {
	    	System.out.println(e);
	    	return false;
	    }
	}
	
	
	
	
	
	public int ajouterEmprunt(Emprunt nouvEmprunt) {
		try {
			
        	query = "SELECT idLivre FROM Livres WHERE idLivre = " + nouvEmprunt.getIdLivre() + ";";
        	rs = st.executeQuery(query);
        	if(!rs.next())
        		return -1; // Livre DOES NOT EXIST
        	
        	query = "SELECT idAbonne FROM Abonnes WHERE idAbonne = " + nouvEmprunt.getIdAbonne() + ";";
        	rs = st.executeQuery(query);
        	if(!rs.next())
        		return -2; // Abonne DOES NOT EXIST
        	
			query = "SELECT Count(*) as NbEmpruntsDeLAbonne FROM Emprunts WHERE idAbonne = " + nouvEmprunt.getIdAbonne() + 
					" AND date_rendu IS NULL;";
        	rs = st.executeQuery(query);
    		rs.next();
        	if(rs.getInt("NbEmpruntsDeLAbonne") >= 2)
        		return -3; // NbEmpruntsDeLAbonne IS >= 2
        	
        	query = "SELECT idLivre FROM Emprunts WHERE idLivre = " + nouvEmprunt.getIdLivre() + " AND date_rendu IS NULL;";
        	rs = st.executeQuery(query);
        	if(rs.next())
        		return -4; // Livre IS emprunté
        	
			query = "INSERT INTO Emprunts (idLivre, idAbonne) VALUES(" + 
					nouvEmprunt.getIdLivre() + ", " +
					nouvEmprunt.getIdAbonne() + ");";			
	        if(st.executeUpdate(query) > 0) {
	        	query = "SELECT MAX(idEmprunt) as maxId FROM Emprunts;";
	        	rs = st.executeQuery(query);
	        	rs.next();
	        	return rs.getInt("maxId"); // SUCCUSSFULLY Emprunté AND RETURNING BACK THE ID 
			} else {
	        	return -5; // ERROR WHILE THE Emprunt
	        }
	        
		} catch (Exception e) {
	    	System.out.println(e);
	    	return -6; // ERROR WHILE CONNECTING TO DATABASE
	    }
	}

	
	public int remettreEmprunt(int idEmprunt) {
		
		query = "UPDATE Emprunts SET date_rendu = current_timestamp() WHERE idEmprunt = " + idEmprunt + " AND date_rendu IS NULL;";
		
		try {
	        if(st.executeUpdate(query) > 0) {
	        	return 0; // SUCCESSFULLY GIVEN BACK
	        } else {
	        	return 1; // ID DOES NOT EXIST OR BOOK IS GIVEN BACK	        	
	        }
		} catch (Exception e) {
			System.out.println(e);
	    	return 2; // ERROR
	    }
		
	}
	
	
//	public String rechercherPrets(int id, boolean estIdLivre, boolean tousLesLivres) {
//		
//		if(estIdLivre) {
//			query = "SELECT * FROM Emprunts" +
//					"WHERE idLivre = " + id +
//					
//					
//					(tousLesLivres ? "" : " AND date_rendu IS NULL") + ";";
//		}
//
//		
//		try {
//			
////			rs = st.executeQuery(query);
////        	rs.next();
////        	return rs.getInt("maxId");
//        	
//		} catch (Exception e) {
//			System.out.println(e);
//	    	return null; // ERROR
//	    }
//		
//	}
//	
	
	public String rechercherTousPretsNonRendus() {
		query = "SELECT CONCAT('[', E.idEmprunt, '] ', A.prenom, ' ', A.nom, ' (', A.idAbonne, ') a emprunté \"', L.titre, '\" (', L.idLivre, ') le ' ) as res, date_pret FROM Emprunts as E, Livres as L, Abonnes as A WHERE E.idLivre = L.idLivre AND E.idAbonne = A.idAbonne AND E.date_rendu IS NULL ORDER BY E.date_rendu DESC;";
		
		String res = "<html>";
		try {
			rs = st.executeQuery(query);
			
			while(rs.next())
				res += rs.getString("res") + AllInOne.getDateComplet(rs.getTimestamp("date_pret")) + " et n'a pas rendu encore.<br/><br/>";
			
			res += "</html>";
						
			return res;
			
		} catch(Exception e) {
			System.out.println(e);
			return null;
		}

	}
	
	
	public String rechercherTousPretsAvecIdLivre(int idLivre) {
		query = "SELECT CONCAT('[', E.idEmprunt, '] ', A.prenom, ' ', A.nom, ' (', A.idAbonne, ') a emprunté \"', L.titre, '\" (', L.idLivre, ') le ' ) as res, date_pret, date_rendu FROM Emprunts as E, Livres as L, Abonnes as A WHERE E.idLivre = L.idLivre AND E.idAbonne = A.idAbonne AND E.idLivre = " + idLivre + " ORDER BY E.date_rendu DESC;";
		
		String res = "<html>";
		try {
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				res += rs.getString("res") + AllInOne.getDateComplet(rs.getTimestamp("date_pret"));
				if(rs.getTimestamp("date_rendu") != null)
					res += " et a rendu le " + AllInOne.getDateComplet(rs.getTimestamp("date_rendu"));
				else
					res += " et n'a pas rendu encore";
				res += ".<br/><br/>";
			}
			
			res += "</html>";
						
			return res;
			
		} catch(Exception e) {
			System.out.println(e);
			return null;
		}

	}
	
	
	public String rechercherTousPretsAvecIdAbonne(int idAbonne) {
		query = "SELECT CONCAT('[', E.idEmprunt, '] ', A.prenom, ' ', A.nom, ' (', A.idAbonne, ') a emprunté \"', L.titre, '\" (', L.idLivre, ') le ' ) as res, date_pret, date_rendu FROM Emprunts as E, Livres as L, Abonnes as A WHERE E.idLivre = L.idLivre AND E.idAbonne = A.idAbonne AND E.idAbonne = " + idAbonne + " ORDER BY E.date_rendu DESC;";
		
		String res = "<html>";
		try {
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				res += rs.getString("res") + AllInOne.getDateComplet(rs.getTimestamp("date_pret"));
				if(rs.getTimestamp("date_rendu") != null)
					res += " et a rendu le " + AllInOne.getDateComplet(rs.getTimestamp("date_rendu"));
				else
					res += " et n'a pas rendu encore";
				res += ".<br/><br/>";
			}
			
			res += "</html>";
						
			return res;
			
		} catch(Exception e) {
			System.out.println(e);
			return null;
		}

	}
	
	
	
	public String rechercherTousPretsNonRendusAvant7Jours() {
		
		query = "SELECT (CURRENT_TIMESTAMP() - DATE_PRET) as nbSeconds, CONCAT('[', E.idEmprunt, '] ', A.prenom, ' ', A.nom, ' (', A.idAbonne, ') a emprunté \"', L.titre, '\" (', L.idLivre, ') le ' ) as res, date_pret FROM Emprunts as E, Livres as L, Abonnes as A WHERE E.idLivre = L.idLivre AND E.idAbonne = A.idAbonne AND E.date_rendu IS NULL AND (CURRENT_TIMESTAMP() - DATE_PRET) > 604800 ORDER BY (CURRENT_TIMESTAMP() - DATE_PRET) DESC;";
		
		String res = "<html>";
		try {
			rs = st.executeQuery(query);
			
			while(rs.next())
				res += rs.getString("res") + AllInOne.getDateComplet(rs.getTimestamp("date_pret")) + " et n'a pas rendu avant 7 jours.<br/><br/>";
			
			res += "</html>";
						
			return res;
			
		} catch(Exception e) {
			System.out.println(e);
			return null;
		}	

	}
	
	
	public String[] rechercherTop10() {
		query = "SELECT L.titre, COUNT(*) as nbEmprunts FROM Emprunts as E, Livres as L WHERE E.idLivre = L.idLivre GROUP BY L.titre ORDER BY nbEmprunts DESC;";
		
		String[] top10 = new String[10];
		
		try {
			rs = st.executeQuery(query);

			int i = 0;
			while(rs.next())
				top10[i++] = String.format("(%d fois) %s", rs.getInt("nbEmprunts"), rs.getString("titre"));

			for(; i<10; i++)
				top10[i] = "N/A";
				
		} catch(Exception e) {
			System.out.println(e);
		}
				
		return top10;
	}
	
	
	
	
	
	
}