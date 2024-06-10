package fr.univ_artois.hopital.model;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


/**
 * Representation d'un patient dans la clinique
 *
 * @author Cornet benjamin, Morel Mathias, Mathéo, Simon
 * @version 1.0
 */
public class Patient implements Recherchable{

    //Loger
    private static final Logger LOGGER = LogManager.getLogger(Patient.class.getPackage().getName());

    //Attributs
    private String nom;
    private String prenom;
    private int age;
    private Sexe sexePersonne;
    private String groupeSanguin;
    private String taille;
    private String poids;
    private List<String> symptomes;
    private int numeroSecuriteSociale; // ID
    private List<HistoriqueMedical> historiques;
    private List<String> troublesMedicaux;

    private static final int MAX_PATIENT = 200;
    private ArrayList<Patient> listeDePatient = new ArrayList<>(MAX_PATIENT);


    //Constructeur

    /**
     * Constructeur par de la classe patient
     *
     * @param nom nom du patient
     * @param prenom prénom du patient
     * @param age age du patient
     * @param groupeSanguin groupe sanguin du patient
     * @param sexePersonne sexe du patient
     * @param taille taille du patient
     * @param poids poids du patient
     * @param symptomes symptomes du patient
     * @param numeroSecuriteSociale numéro de sécurité sociale du patient
     * @param troublesMedicaux troubles médicaux du patient
     */
    public Patient(String nom, String prenom, int age, String groupeSanguin, Sexe sexePersonne,
                   String taille, String poids, List<String> symptomes,
                   int numeroSecuriteSociale, List<String> troublesMedicaux) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.groupeSanguin = groupeSanguin;
        this.sexePersonne = sexePersonne;
        this.taille = taille;
        this.poids = poids;
        this.symptomes = symptomes;
        this.numeroSecuriteSociale = numeroSecuriteSociale;
        this.troublesMedicaux = troublesMedicaux;
        this.historiques = new ArrayList<>() {
        };
    }

    //Getters
    // Getters
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public Sexe getSexePersonne() {
        return sexePersonne;
    }

    public String getGroupeSanguin() {
        return groupeSanguin;
    }

    public String getTaille() {
        return taille;
    }

    public String getPoids() {
        return poids;
    }

    public List<String> getSymptomes() {
        return symptomes;
    }

    public int getNumeroSecuriteSociale() {
        return numeroSecuriteSociale;
    }

    public List<String> getTroublesMedicaux() {
        return troublesMedicaux;
    }

    public List<HistoriqueMedical> getHistoriques() {
        return historiques;
    }

    public ArrayList<Patient> getListeDePatient() {
        return listeDePatient;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSexePersonne(Sexe sexePersonne) {
        this.sexePersonne = sexePersonne;
    }

    public void setGroupeSanguin(String groupeSanguin) {
        this.groupeSanguin = groupeSanguin;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public void setSymptomes(List<String> symptomes) {
        this.symptomes = symptomes;
    }

    public void setTroublesMedicaux(List<String> troublesMedicaux) {
        this.troublesMedicaux = troublesMedicaux;
    }

    public void setNumeroSecuriteSociale(int numeroSecuriteSociale) {
        this.numeroSecuriteSociale = numeroSecuriteSociale;
    }


    /**
     * Ajout d'un patient
     *
     * @param patient patient
     */
    public void ajouterPatient(Patient patient) {
        listeDePatient.add(patient);
    }

    /**
     * Suppression d'un patient par son numero de securite sociale
     *
     * @param nomPatient Nom du patient
     */
    public void supprimerPatientParNom(String nomPatient) {
        for (int i = 0; i < listeDePatient.size(); i++) {
            if (listeDePatient.get(i).getNom().equals(nomPatient)) {
                listeDePatient.remove(i);
            }
        }
    }


    /**
     * Affichage de tous les patients
     */
    public void afficherPatient() {
        for (int i = 0; i < listeDePatient.size(); i++) {
            LOGGER.info(listeDePatient.get(i));
        }
    }

    /**
     * Recherche d'un patient par son nom
     *
     * @param nom le nom du patient
     */
    @Override
    public void rechercherParNom(String nom) {
        for (int i = 0; i < listeDePatient.size(); i++) {
            if (listeDePatient.get(i).getNom().equals(nom)) {
                LOGGER.info(listeDePatient.get(i));
            }
        }
    }

    @Override
    public void rechercherParSpecialite(String specialite) {

    }

    @Override
    public void rechercherGenerale(String critere) {
        boolean found = false;
        for (Patient patient : listeDePatient) {
            if (patient.getNom().contains(critere) ||
                patient.getPrenom().contains(critere) ||
                patient.getSymptomes().contains(critere) ||
                patient.getTroublesMedicaux().contains(critere)){
                LOGGER.printf(Level.INFO,"Patient trouvé : {%Patient}", patient);
                found = true;
            }
        }
        if (!found) {
            LOGGER.printf(Level.INFO,"Aucun patient ne correspond au critère de recherche : {%critere}", critere);
        }
    }

    public void ajoutHistorique(HistoriqueMedical historique) {
        historiques.add(historique);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Patient{");
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", age=").append(age);
        sb.append(", poids='").append(poids).append('\'');
        sb.append(", taille='").append(taille).append('\'');
        sb.append(", groupeSanguin='").append(groupeSanguin).append('\'');
        sb.append(", sexePersonne=").append(sexePersonne);
        sb.append(", symptomes='").append(symptomes).append('\'');
        sb.append("numeroSecuriteSociale=").append(numeroSecuriteSociale);
        sb.append(", troublesMedicaux='").append(troublesMedicaux).append('\'');
        sb.append(", historiquesMedicaux='").append(historiques).append('\'');
        sb.append('}');
        return sb.toString();
    }
}