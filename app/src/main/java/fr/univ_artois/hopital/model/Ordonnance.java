package fr.univ_artois.hopital.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation d'un rendez-vous dans la clinique
 *
 * @author Cornet benjamin, Morel Mathias, Mathéo, Simon
 * @version 1.0
 */
public class Ordonnance {


    private static final Logger LOGGER = LogManager.getLogger(Ordonnance.class.getPackage().getName());

    private int idOrdonnance;
    private List<String> medPrescrits;
    private String nomPatient;
    private String dateOrdonnance;

    private static int nextIdOrdonnance = 1;
    private List<Ordonnance> listeOrdonnances = new ArrayList<>();

    //Constructeur

    /**
     * Constructeur de la classe Ordonnance
     *
     * @param medPrescrits   les médicaments prescrits
     * @param nomPatient     nom du patient
     * @param dateOrdonnance date de création de l'ordonnance'
     */
    public Ordonnance(List<String> medPrescrits, String nomPatient, String dateOrdonnance) {
        this.idOrdonnance = nextIdOrdonnance++;
        this.medPrescrits = medPrescrits;
        this.nomPatient = nomPatient;
        this.dateOrdonnance = dateOrdonnance;
    }


    //Getters
    public int getIdOrdonnance() {
        return idOrdonnance;
    }

    public List<String> getMedPrescrits() {
        return medPrescrits;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public String getDateOrdonnance() {
        return dateOrdonnance;
    }

    //Setters
    public void setMedPrescrits(List<String> medPrescrits) {
        this.medPrescrits = medPrescrits;
    }


    //methode affichage

    /**
     * Affiche d'une ordonnance d'un patient grâce au nom du patient
     *
     * @param nomPatient nom du patient
     */
    public void affichageOrdonnance(String nomPatient) {
        for(int i = 0; i < listeOrdonnances.size(); i++) {
            if(listeOrdonnances.get(i).getNomPatient().equals(nomPatient)) {
                LOGGER.info(listeOrdonnances.get(i).toString());
            }
        }
    }

    /**
     * Affiche de toutes les ordonnances de la clinique
     *
     */
    public void affichageOrdonnance() {
        for(int i = 0; i < listeOrdonnances.size(); i++) {
            LOGGER.info(listeOrdonnances.get(i).toString());
        }
    }

    //methode ajouter une ordonnance
    public void ajouteOrdonnance(Ordonnance ordonnance) {
        listeOrdonnances.add(ordonnance);
    }

    // toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ordonnance{");
        sb.append("idOrdonnance=").append(idOrdonnance);
        sb.append(", medPrescrits=").append(medPrescrits);
        sb.append(", nomPatient='").append(nomPatient).append('\'');
        sb.append(", dateOrdonnance='").append(dateOrdonnance).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
