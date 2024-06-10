package fr.univ_artois.hopital.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation d'un historique medical d'un patient
 *
 * @author Cornet benjamin, Morel Mathias, Mathéo, Simon
 * @version 1.0
 */
public class HistoriqueMedical {

	//Loger
	private static final Logger LOGGER = LogManager.getLogger(HistoriqueMedical.class.getPackage().getName());

	//Création des Attributs
	private List<HistoriqueMedical> historiques = new ArrayList<>();
	private String visite;
	private String diagnostic;
	private String traitements;
	private String nomPatient;
	
	//Contructeur

	/**
	 * Constructeur de la classe HistoriqueMedical
	 *
	 * @param visite jour de visite
	 * @param diagnostic diagnostic du patient
	 * @param traitements traitements du patient
	 * @param nomPatient nom du patient
	 */
	public HistoriqueMedical(String visite, String diagnostic, String traitements, String nomPatient) {
		this.visite = visite;
		this.diagnostic = diagnostic;
		this.traitements = traitements;
		this.nomPatient = nomPatient;
	}

	//Getters et Setters
	public List<HistoriqueMedical> getHistoriques() {
		return historiques;
	}

	public String getVisite() {
		return visite;
	}

	public String getDiagnostic() {
		return diagnostic;
	}

	public String getTraitements() {
		return traitements;
	}

	public String getNomPatient() {
		return nomPatient;
	}

	//Méthodes :

	/**
	 * Ajout d'un historique à la liste des historiques
	 *
	 * @param historique l'historique à ajouter
	 */
	public void ajouterHistorique(HistoriqueMedical historique) {
		historiques.add(historique);
	}

	/**
	 * Suppression d'un historique par son nom de patient
	 *
	 * @param nomPatient le nom du patient
	 */
	public void supprimerHistoriqueParNomDePatient(String nomPatient) {
		for (int i = 0; i < historiques.size(); i++) {
            if (historiques.get(i).getNomPatient().equals(nomPatient)) {
                historiques.remove(i);
            }
        }
	}

	/**
     * Affichage de tous les historiques
     */
	public void afficherHistorique() {
		LOGGER.info("Affichage de l'historique");
        for (int i = 0; i < historiques.size(); i++) {
            System.out.println(historiques.get(i).toString());
        }
	}

	/**
	 *  Affichage de l'historique d'un patient
	 */
	public void afficherHistorique(String nomDuPatient) {
		for (int i = 0; i < historiques.size(); i++) {
            if (historiques.get(i).getNomPatient().equals(nomDuPatient)) {
                System.out.println(historiques.get(i).toString());
            }
        }
	}

	//Méthode toString
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("HistoriqueMedical{");
		sb.append("NomPatient='").append(nomPatient).append('\'');
		sb.append(", historiques=").append(historiques);
		sb.append(", visite='").append(visite).append('\'');
		sb.append(", diagnostic='").append(diagnostic).append('\'');
		sb.append(", traitements='").append(traitements).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
