package fr.univ_artois.hopital.model;

/**
 * Representation d'un feedback d'un client
 *
 * @author Cornet benjamin, Morel Mathias, Mathéo, Simon
 * @version 1.0
 */
public class Feedback {

    private int idFeedback; // ID
    private int idPatient;
    private int idMedecin;
    private String dateFeedback;
    private String commentaires;
    private Notation notes;

    private static int prochaineId = 1;

    /**
     * Constructeur de la classe Feedback.
     *
     * @param idPatient    id du patient
     * @param idMedecin    id du medecin
     * @param dateFeedback date du feedback
     * @param commentaires le commentaire
     * @param notes        notes
     */
    public Feedback(int idPatient, int idMedecin, String dateFeedback, String commentaires, Notation notes) {
        this.idFeedback = prochaineId++;
        this.idPatient = idPatient;
        this.idMedecin = idMedecin;
        this.dateFeedback = dateFeedback;
        this.commentaires = commentaires;
        this.notes = notes;
    }

    //Getters

    public int getIdFeedback() {
        return idFeedback;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public String getDateFeedback() {
        return dateFeedback;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public Notation getNotes() {
        return notes;
    }

    //Setters
    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    public void setNotes(Notation notes) {
        this.notes = notes;
    }

    //toString :
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Feedback{");
        sb.append("idFeedback=").append(idFeedback);
        sb.append(", idPatient=").append(idPatient);
        sb.append(", idMedecin=").append(idMedecin);
        sb.append(", dateFeedback='").append(dateFeedback).append('\'');
        sb.append(", commentaires='").append(commentaires).append('\'');
        sb.append(", notes=").append(notes);
        sb.append('}');
        return sb.toString();
    }
}
