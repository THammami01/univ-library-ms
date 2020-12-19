package biblio_univ.useful;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

public final class AllInOne {
		
	public static String getDateComplet(Timestamp timestamp) {
		
		int nJDeLaSemaine = 0, d = 0, m = 0, y = 0, hour = 0, minutes = 0;

		try {
			nJDeLaSemaine = timestamp.getDay();
			d = timestamp.getDate();
			m = timestamp.getMonth();
			y = (timestamp.getYear() + 1900);
			
			hour = timestamp.getHours();
			minutes = timestamp.getMinutes();

		} catch(IllegalArgumentException e) {
			
		}

		return getJourDeSemaine(nJDeLaSemaine) + " " + d + " " + getMois(m) + " " + y + " à " + String.format("%02d", hour) + "h" + String.format("%02d", minutes);

	}
	
    public static String getJourDeSemaine(int nJDeLaSemaine) {

        switch(nJDeLaSemaine) {
        	case 1: return "Lundi";
        	case 2: return "Mardi";
        	case 3: return "Mercredi";
        	case 4: return "Jeudi";
        	case 5: return "Vendredi";
        	case 6: return "Samedi";
	        default: return "Dimanche";        	
        }
        
    }

    public static String getMois(int m) {
		switch(m) {
			case 0: return "Janvier";
			case 1: return "Février";
			case 2: return "Mars";
			case 3: return "Avril";
			case 4: return "May";
			case 5: return "Juin";
			case 6: return "Juillet";
			case 7: return "Aôut";
			case 8: return "Septembre";
			case 9: return "Octobre";
			case 10: return "Novembre";
			default: return "Décembre";			
		}
    }
    
    public static boolean passed7Days(int nbSeconds) {
    	return nbSeconds > 604800;    	
    }
}
