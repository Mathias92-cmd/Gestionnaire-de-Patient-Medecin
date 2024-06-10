package fr.univ_artois.hopital.model;

import java.util.List;

/**
 * Representation d'un rendez-vous dans la clinique
 *
 * @author Cornet benjamin, Morel Mathias, Mathéo, Simon
 * @version 1.0
 */
public class Ordonnance {

    private int idOrdonnance;
    private List<String> medPrescrits;
    private String nomPatient;
    private String dateOrdonnance;

    //Constructeur

    /**
     * Constructeur de la classe Ordonnance
     *
     * @param idOrdonnance   id de l'ordonnance'
     * @param medPrescrits   les médicaments prescrits
     * @param nomPatient     nom du patient
     * @param dateOrdonnance date de création de l'ordonnance'
     */
    public Ordonnance(int idOrdonnance, List<String> medPrescrits, String nomPatient, String dateOrdonnance) {
        this.idOrdonnance = idOrdonnance;
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
     * Affiche dans la console une ordonnance
     */
    public void affichageOrdonnance() {
        System.out.println("Ordonnance de la clinque");
        System.out.println("Id Ordonnance : " + idOrdonnance);
        System.out.println("Nom du patient : " + nomPatient);
        System.out.println("Date de l'ordonnance : " + dateOrdonnance);
        System.out.println("Liste des medicaments prescrits : ");
        for (String medPrescrit : medPrescrits) {
            System.out.println(medPrescrit);
        }
    }

    //methode ajouter une ordonnance

    /**
     * Ajoute une ordonnance à la liste des ordonnances
     *
     * @param medicament
     */
    public void ajouteMedicament(String medicament) {
        medPrescrits.add(medicament);
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
