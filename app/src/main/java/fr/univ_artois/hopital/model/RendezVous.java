package fr.univ_artois.hopital.model;

import java.util.ArrayList;

/**
 * Representation d'un rendez-vous dans la clinique
 *
 * @author Cornet benjamin, Morel Mathias, Mathéo, Simon
 * @version 1.0
 */
public class RendezVous {

    //Atributs :
    private int idRendezvous;
    private String dateRendezVous;
    private String heureRendezVous;
    private String nomPatient;
    private String nomMedecin;


    private static final int MAX_RENDEZ_VOUS = 500;
    private ArrayList<RendezVous> listeDeRendezVous = new ArrayList<>(MAX_RENDEZ_VOUS);
    private static int idRendezProchainVous = 1;

    //Constructeur

    /**
     * Constructeur de la classe RendezVou
     * @param dateRendezVous  date du rendez-vous
     * @param heureRendezVous heure du rendez-vous
     * @param nomPatient      nom du patient
     * @param nomMedecin      nom du médecin
     */
    public RendezVous(String dateRendezVous, String heureRendezVous, String nomPatient, String nomMedecin) {
        this.idRendezvous = idRendezProchainVous++;
        this.dateRendezVous = dateRendezVous;
        this.heureRendezVous = heureRendezVous;
        this.nomPatient = nomPatient;
        this.nomMedecin = nomMedecin;
    }

    //Getters
    public int getIdRendezvous() {
        return idRendezvous;
    }

    public String getDateRendezVous() {
        return dateRendezVous;
    }

    public String getHeureRendezVous() {
        return heureRendezVous;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public ArrayList<RendezVous> getRendezVous() {
        return listeDeRendezVous;
    }

    //Setters
    public void setDateRendezVous(String dateRendezVous) {
        this.dateRendezVous = dateRendezVous;
    }

    public void setHeureRendezVous(String heureRendezVous) {
        this.heureRendezVous = heureRendezVous;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
    }

    //Méthodes :

    /**
     * Ajout d'un rendez-vous.
     *
     * @param rendezVous rendez-vous à ajouter
     */
    public void ajoutRendezVous(RendezVous rendezVous) {
        this.listeDeRendezVous.add(rendezVous);
    }

    /**
     * Suppression d'un rendez-vous par le nom du patient.
     *
     * @param nomPatient Nom du patient
     */
    public void supprimerRendezVous(String nomPatient) {
        for (int i = 0; i < listeDeRendezVous.size(); i++) {
            if (listeDeRendezVous.get(i).getNomPatient().equals(nomPatient)) {
                listeDeRendezVous.remove(i);
            }
        }
    }

    /**
     * Affichage de tous les rendez-vous de la liste
     *
     */
     public void afficherRendezVous() {
        for (int i = 0; i < listeDeRendezVous.size(); i++) {
            System.out.println(listeDeRendezVous.get(i));
        }
     }

    //Méthode toString
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("RendezVous{");
        sb.append("idRendezvous=").append(idRendezvous);
        sb.append(", dateRendezVous=").append(dateRendezVous);
        sb.append(", heureRendezVous=").append(heureRendezVous);
        sb.append(", nomPatient='").append(nomPatient).append('\'');
        sb.append(", nomMedecin='").append(nomMedecin).append('\'');
        sb.append(", listeDeRendezVous=").append(listeDeRendezVous);
        sb.append('}');
        return sb.toString();
    }
}