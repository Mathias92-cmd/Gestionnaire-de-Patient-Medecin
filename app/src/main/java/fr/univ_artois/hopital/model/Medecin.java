package fr.univ_artois.hopital.model;

// Importations
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.image.LookupOp;
import java.util.ArrayList;

/**
 * Representation d'un medecin dans la clinique
 *
 * @author Cornet benjamin, Morel Mathias, Mathéo, Simon
 * @version 1.0
 */
public class Medecin implements Recherchable{

    //Loger
    private static final Logger LOGGER = LogManager.getLogger(Patient.class.getPackage().getName());

    private int idMedecin;
    private ArrayList<String> specialisation; // Maybe a list of specialisation
    private String nomMedecin;
    private String prenomMedecin;
    private int ageMedecin;
    private Sexe sexeMedecin;

    private static final int MAX_MEDECIN = 15;
    private static ArrayList<Medecin> listeMedecin = new ArrayList<>(MAX_MEDECIN);
    private static int prochaineId = 1;

    /**
     * Constructeur de la classe Medecin
     *
     * @param nomMedecin Nom du medecin
     * @param prenomMedecin Prenom du medecin
     * @param specialisation Liste des specialisations du medecin
     * @param ageMedecin Age du medecin
     * @param sexeMedecin Sexe du medecin
     */
    public Medecin(String nomMedecin,String prenomMedecin,  ArrayList<String> specialisation, int ageMedecin, Sexe sexeMedecin) {
        this.idMedecin = prochaineId++;
        this.specialisation = specialisation;
        this.nomMedecin = nomMedecin;
        this.prenomMedecin = prenomMedecin;
        this.ageMedecin = ageMedecin;
        this.sexeMedecin = sexeMedecin;
    }

    //Getters

    public int getIdMedecin() {
        return idMedecin;
    }

    public ArrayList<String> getSpecialisation() {
        return specialisation;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public String getPrenomMedecin() {
        return prenomMedecin;
    }

    public int getAgeMedecin() {
        return ageMedecin;
    }

    public Sexe getSexeMedecin() {
        return sexeMedecin;
    }

    public static ArrayList<Medecin> getListeMedecin() {
        return listeMedecin;
    }

    //Setters

    public void setSpecialisation(ArrayList<String> specialisation) {
        this.specialisation = specialisation;
    }

    public void setAgeMedecin(int ageMedecin) {
        this.ageMedecin = ageMedecin;
    }

    /**
     * Permet d'ajouter un medecin à la liste des medecins.
     *
     * @param medecin un medecin
     */
    public void ajouterMedecin(Medecin medecin) {
        listeMedecin.add(medecin);
    }

	/**
	 * Suppression d'un medecin par son nom
	 *
	 * @param nomMedicine Nom du medecin
	 */
    public void supprimerMedecinParNom(String nomMedicine) {
        for(int i = 0; i < listeMedecin.size(); i++) {
            if(listeMedecin.get(i).getNomMedecin().equals(nomMedicine)) {
                listeMedecin.remove(i);
            }
        }

    }


	/**
	 * Affichage de tous les medecins de la liste
	 */
	public void afficherMedecin() {
        for (int i = 0; i < listeMedecin.size(); i++) {
            LOGGER.info(listeMedecin.get(i));
            LOGGER.printf(Level.INFO,"\n");
        }
    }

    @Override
    public void rechercherParNom(String nom) {
        for(int i = 0; i < listeMedecin.size(); i++) {
            if(listeMedecin.get(i).getNomMedecin().equals(nom)) {
                LOGGER.info(listeMedecin.get(i));
            }
        }
    }

    @Override
    public void rechercherParSpecialite(String specialite) {
        for(int i = 0; i < listeMedecin.size(); i++) {
            if(listeMedecin.get(i).getSpecialisation().contains(specialite)) {
                LOGGER.info(listeMedecin.get(i));
            }
        }
    }

    @Override
    public void rechercherGenerale(String critere) {
        boolean found = false;
        for (Medecin medecin : listeMedecin) {
            if (medecin.getNomMedecin().contains(critere) ||
                medecin.getPrenomMedecin().contains(critere) ||
                medecin.getSpecialisation().contains(critere)){
                LOGGER.printf(Level.INFO,"Medecin trouvé : {%Medecin}", medecin);
                found = true;
            }
        }
        if (!found) {
            LOGGER.printf(Level.INFO,"Aucun medecin ne correspond au critère de recherche : {%critere}", critere);
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Medecin{");
        sb.append(" IdMedecin=").append(idMedecin);
        sb.append(", PrenomMedecin='").append(prenomMedecin).append('\'');
        sb.append(", NomMedecin='").append(nomMedecin).append('\'');
        sb.append(", SexeMedecin=").append(sexeMedecin);
        sb.append(", AgeMedecin=").append(ageMedecin);
        sb.append(", Specialisation='").append(specialisation).append('\'');
        sb.append('}');
        return sb.toString();
    }

}