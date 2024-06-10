package fr.univ_artois.hopital.model;


public class Feedback extends RendezVous {
	private String commentaires;
	enum notation{UN,DEUX,TROIS,QUATRE,CINQ}
	private notation notes;
	public Feedback(int idRendezvous, int dateRendezVous, int heureRendezVous,
					String commentaires, notation notes, Patient patient, Medecin medecin) {
		super(idRendezvous, dateRendezVous, heureRendezVous, patient, medecin);
		this.commentaires = commentaires;
		this.notes = notes;
	}
	public String getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}
	public notation getNotes() {
		return notes;
	}
	public void setNotes(notation notes) {
		this.notes = notes;
	}
	
	public String toString() {
		return "feedback [commentaires=" + commentaires + ", notes=" + notes + "]";
	}		
}
