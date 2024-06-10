package fr.univ_artois.hopital.model;

public class Facturation {
	
	//Attributs
	private double prixFacture;
	private Consultation consultation;
	private MoyenPayement moyenPayement;
	
	public Facturation(Consultation consultation , MoyenPayement moyenPayement) {
		this.consultation = consultation;
		this.prixFacture = 0;
		this.moyenPayement = moyenPayement;
	}
	
	//Crétion d'une énumétation
	public enum MoyenPayement {
		CARTE_CREDIT , CHEQUE , ESPECE , VIREMENT
	}
	
	//Méthode Prix de facture
	public void prixFacture() {
		System.out.println("Facture pour le patient "  + consultation.getNomPatient());
		System.out.println("Montant de la consultation = " + consultation.getMontantConsultation());
	}
	
	//Méthode permettant de choisir le moyen de payement
	public static MoyenPayement choisirMoyenPayement (int choix) {
		switch(choix) {
			case 1 : 
				return MoyenPayement.CARTE_CREDIT;
			case 2 :
				return MoyenPayement.CHEQUE;
				
			case 3:
				return MoyenPayement.ESPECE;
				
			case 4 :
				return MoyenPayement.VIREMENT;
				
			default :
				throw new IllegalArgumentException("Choix impossible ! ");
		}
	}
}
