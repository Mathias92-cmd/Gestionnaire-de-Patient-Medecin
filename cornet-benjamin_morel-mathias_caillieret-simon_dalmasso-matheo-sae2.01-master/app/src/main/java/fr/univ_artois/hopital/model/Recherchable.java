package fr.univ_artois.hopital.model;

public interface Recherchable {

  void rechercherParNom(String nom);
  void rechercherParSpecialite(String specialite);
  void rechercherGenerale(String critere);

}
