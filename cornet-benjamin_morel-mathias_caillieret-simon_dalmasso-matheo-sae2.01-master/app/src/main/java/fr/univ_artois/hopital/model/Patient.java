package fr.univ_artois.hopital.model;

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
    private String symptomes;
    private String maladie;
    private final int numeroSecuriteSociale; // ID
    private List<HistoriqueMedical> historiques;
    private ArrayList<Patient> listeDePatient = new ArrayList<>(MAX_PATIENT);
    private List<String> troublesMedicaux;

    private static final int MAX_PATIENT = 200;


    //Constructeur

    /**
     * @param nom                   nom du patient
     * @param prenom                prenom du patient
     * @param age                   age du patient
     * @param groupeSanguin         groupe sanguin du patient
     * @param sexePersonne          sexe du patient
     * @param taille                taille du patient
     * @param poids                 poids du patient
     * @param symptomes             symptomes du patient
     * @param maladie               maladie du patient
     * @param numeroSecuriteSociale numero de securite sociale du patient
     * @param troublesMedicaux      troubles medicaux du patient
     */
    public Patient(String nom, String prenom, int age, String groupeSanguin, Sexe sexePersonne,
                   String taille, String poids, String symptomes, String maladie,
                   int numeroSecuriteSociale, List<String> troublesMedicaux) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.groupeSanguin = groupeSanguin;
        this.sexePersonne = sexePersonne;
        this.taille = taille;
        this.poids = poids;
        this.symptomes = symptomes;
        this.maladie = maladie;
        this.numeroSecuriteSociale = numeroSecuriteSociale;
        this.troublesMedicaux = troublesMedicaux;
    }

    //Getters
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

    public String getSymptomes() {
        return symptomes;
    }

    public String getMaladie() {
        return maladie;
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

    //----------------------------------------------------------------
    //Setters
    public void setAge(int age) {
        this.age = age;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public void setSymptomes(String symptomes) {
        this.symptomes = symptomes;
    }

    public void setMaladie(String maladie) {
        this.maladie = maladie;
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
            LOGGER.info(",");
            if(i < listeDePatient.size() - 1) {
                LOGGER.info(listeDePatient.get(i));
            }
        }
    }

    /**
	 *
	 *
     * @param historique historique médicale d'un patient
     */
    public void ajouterHistorique(HistoriqueMedical historique) {
        historiques.add(historique);
    }

    @Override
    public void rechercherParNom(String nom) {

    }

    @Override
    public void rechercherParSpecialite(String specialite) {

    }

    @Override
    public void rechercherGenerale(String critere) {

    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Patient{");
        sb.append("numeroSecuriteSociale=").append(numeroSecuriteSociale);
        sb.append(", maladie='").append(maladie).append('\'');
        sb.append(", symptomes='").append(symptomes).append('\'');
        sb.append(", poids='").append(poids).append('\'');
        sb.append(", taille='").append(taille).append('\'');
        sb.append(", groupeSanguin='").append(groupeSanguin).append('\'');
        sb.append(", sexePersonne=").append(sexePersonne);
        sb.append(", age=").append(age);
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", nom='").append(nom).append('\'');
        sb.append('}');
        return sb.toString();
    }
}