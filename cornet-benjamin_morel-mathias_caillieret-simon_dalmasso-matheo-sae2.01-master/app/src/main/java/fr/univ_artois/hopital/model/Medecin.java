package fr.univ_artois.hopital.model;

// Importations
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

/**
 * Representation d'un medecin dans la clinique
 *
 * @author Cornet benjamin, Morel Mathias, Mathéo, Simon
 * @version 1.0
 */
public class Medecin {

    //Loger
    private static final Logger LOGGER = LogManager.getLogger(Patient.class.getPackage().getName());

    private int idMedecin;
    private String specialisation; // Maybe a list of specialisation
    private String nomMedecin;
    private String prenomMedecin;
    private int ageMedecin;
    private Sexe sexeMedecin;

    private static final int MAX_MEDECIN = 15;
    private ArrayList<Medecin> listeMedecin = new ArrayList<>(MAX_MEDECIN);



    public Medecin(int idMedecin, String specialisation, String nomMedecin, String prenomMedecin, int ageMedecin, Sexe sexeMedecin) {
        this.idMedecin = idMedecin;
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

    public String getSpecialisation() {
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

    public ArrayList<Medecin> getListeMedecin() {
        return listeMedecin;
    }

    //Setters

    public void setSpecialisation(String specialisation) {
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
            LOGGER.info(",");
            if(i < listeMedecin.size() - 1) {
                LOGGER.info(listeMedecin.get(i));
            }
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Medecin{");
        sb.append("sexeMedecin=").append(sexeMedecin);
        sb.append(", ageMedecin=").append(ageMedecin);
        sb.append(", prenomMedecin='").append(prenomMedecin).append('\'');
        sb.append(", nomMedecin='").append(nomMedecin).append('\'');
        sb.append(", specialisation='").append(specialisation).append('\'');
        sb.append(", idMedecin=").append(idMedecin);
        sb.append('}');
        return sb.toString();
    }
}