package fr.univ_artois.hopital.model;

import java.util.Arrays;

public class HistoriqueMedical {
	//Création des Attributs
	private static final int MAX = 200;
	private String[] historique=new String[MAX];
	private String visite;
	private String diagnostic;
	private String traitements;
	private Patient pat;
	private static int nbHist=0;
	
	//Contructeur
	public HistoriqueMedical(String visite, String diagnostic, String traitements, Patient pat) {
		this.historique[nbHist]= visite.concat(diagnostic).concat(traitements);
		this.pat = pat;
		nbHist++;		
	}
	
	//Getters et Setters
	public String[] getHistorique() {
		return historique;
	}
	
	public void setHistorique(String[] historique) {
		this.historique = historique;
	}
	
	public String getVisite() {
		return visite;
	}
	
	public void setVisite(String visite) {
		this.visite = visite;
	}
	
	public String getDiagnostic() {
		return diagnostic;
	}
	
	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}
	
	public String getTraitements() {
		return traitements;
	}
	
	public void setTraitements(String traitements) {
		this.traitements = traitements;
	}
  
	//Méthode toString
	public String toString() {
		return "HistoriqueMedical [historique=" + Arrays.toString(historique) + ", pat=" + pat + "]";
	}
}
