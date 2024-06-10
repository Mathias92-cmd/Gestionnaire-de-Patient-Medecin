package fr.univ_artois.hopital.model;

public class ModuleDeRecherche{
	
		//Constante : 
		private static final int MAX_PATIENT = 200;
		private static final int MAX_MEDECIN = 15;
			
		//Tableaux
		private static Patient[] listePatient = new Patient[MAX_PATIENT];
		private static Medecin[] listeMedecin = new Medecin[MAX_MEDECIN];

	// methode rechercher patient par le nom
		public static Patient[] recherchePatientNom(String nomPatient) {
		    Patient[] listePatientParNom = new Patient[MAX_PATIENT];
		    for(int i = 0 ; i < listePatient.length; i ++) {
		        if(listePatient[i] != null && listePatient[i].getNom().equals(nomPatient)) {
		            listePatientParNom[i] = listePatient[i];
		            System.out.println("Bravo vous avez trouvé le patient : " + listePatient[i].getNom()); 
		        }
		    }
		    return listePatientParNom;
		}

	// methode rechercher patient par le prenom 
	public static Patient[] recherchePatientPrenom(String prenomPatient) {
		Patient[] listePatientParPrenom = new Patient[MAX_PATIENT];
		for(int i = 0 ; i < listePatient.length; i ++) {
			if(listePatient[i] != null && listePatient[i].getPrenom().equals(prenomPatient) ) {
				listePatientParPrenom[i] = listePatient[i];
				System.out.println("Bravo vous avez trouvé le patient : "+listePatient[i].getPrenom());
			}
		}
		return listePatientParPrenom;
	}
	// methode rechercher patient par le groupe sanguin
	public static Patient[] recherchePatientGroupeSanguin(String groupSanguinPatient) {
		Patient[] listePatientParGroupeSanguin = new Patient[MAX_PATIENT];
		for(int i = 0 ; i < listePatient.length; i ++) {
			if(listePatient[i].getGroupeSanguin().equals(groupSanguinPatient) ) {
				listePatientParGroupeSanguin[i] = listePatient[i];
				System.out.println("Bravo vous avez trouvé le patient : "+listePatient[i].getGroupeSanguin()); 
			}
		}
		return listePatientParGroupeSanguin;
	}
	//methode rechercher medecin par le nom
	public static Medecin[] rechercheMedecinNom(String nomMedecin) {
		Medecin[] listeMedecinParNom = new Medecin[MAX_MEDECIN];
		for(int i = 0 ; i < listeMedecin.length; i ++) {
			if(listePatient[i] != null && listeMedecin[i].getNom().equals(nomMedecin) ) {
				listeMedecinParNom[i] = listeMedecin[i];
			}
		}
		return listeMedecinParNom;
	}
	//methode rechercher medecin par la spécialite
	public static Medecin[] rechercheMedecinParSpecialite(String speMedecin) {
		Medecin[] listeMedecinParSpecialite = new Medecin[MAX_MEDECIN];
		for(int i = 0 ; i < listeMedecin.length; i ++) {
			if(listePatient[i] != null && listeMedecin[i].getSpecialisation().equals(speMedecin) ) {
				listeMedecinParSpecialite[i] = listeMedecin[i];
			}
		}
		return listeMedecinParSpecialite;
	}
}