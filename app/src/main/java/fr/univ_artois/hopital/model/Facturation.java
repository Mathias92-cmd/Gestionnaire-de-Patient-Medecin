package fr.univ_artois.hopital.model;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Representation d'une facture pour un patient
 *
 * @author Cornet benjamin, Morel Mathias, Mathéo, Simon
 * @version 1.0
 */
public class Facturation {

	private static final Logger LOGGER = LogManager.getLogger(Facturation.class.getPackage().getName());

	//Attributs
	private int numeroFacture; //ID
	private String nomPatient;
	private String detailsFacture;
	private double coutTotal;
	private MoyenDePayement moyenPayement;

	List<Facturation> listeFacture = new ArrayList<>();

	private static int prochaineId = 1;


	/**
	 * Constructeur de la classe Facturation
	 *
	 * @param nomPatient facture du patient
	 * @param detailsFacture des details de la facture
	 * @param moyenPayement le moyen de payement utilise
	 * @param coutTotal le cout total de la facture
	 */
	public Facturation(String nomPatient, String detailsFacture, MoyenDePayement moyenPayement, double coutTotal) {
		this.numeroFacture = prochaineId++;
		this.nomPatient = nomPatient;
		this.detailsFacture = detailsFacture;
		this.moyenPayement = moyenPayement;
		this.coutTotal = coutTotal;
	}

	//Getters
	public int getNumeroFacture() {
		return numeroFacture;
	}

	public String getPatient() {
		return nomPatient;
	}

	public String getDetailsFacture() {
		return detailsFacture;
	}

	public double getCoutTotal() {
		return coutTotal;
	}

	public MoyenDePayement getMoyenPayement() {
		return moyenPayement;
	}

	//Setters
	public void setMoyenPayement(MoyenDePayement moyenPayement) {
		this.moyenPayement = moyenPayement;
	}

	public void setDetailsFacture(String detailsFacture) {
		this.detailsFacture = detailsFacture;
	}

	//Méthodes :

	/**
	 * Ajout d'une facture à la liste des factures
	 *
	 */
	public void ajoutFacture(Facturation facture) {
		listeFacture.add(facture);
	}

	/**
	 * Permet de generer une facture au format pdf
	 *
	 */
	public void genereFacture() throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);

		LOGGER.info("Entrez le nom du fichier de la facture : (sans extention)");
		String fileName = sc.next();
		String htmlFileName = fileName + ".html";
		PrintWriter ficW = new PrintWriter(htmlFileName) ;

		ficW.println("<!DOCTYPE html>");
		ficW.println("<html>");
		ficW.println("<head>");
		ficW.println("<title>Facture</title>");
		ficW.println("</head>");
		ficW.println("<body>");
		ficW.println("<h1>Facture n° : " + this.numeroFacture + "</h1>");
		ficW.println("<p>Patient : " + getPatient() + "</p>");
		ficW.println("<p>Moyen de payement : " + this.moyenPayement + "</p>");
		ficW.println("<p>Details : " + this.detailsFacture + "</p>");
		ficW.println("<p>Cout total : " + this.coutTotal + " €</p>");
		ficW.println("</body>");
		ficW.println("</html>");

		ficW.close();

		LOGGER.printf(Level.INFO, "Facture générée avec succès : {%s}" , htmlFileName);
	}

	/**
	 * Permet de choisir le moyen de payement
	 *
	 * @param choix le choix du moyen de payement
	 */
	public MoyenDePayement choisirMoyenPayement(int choix) {
        return switch (choix) {
            case 1 -> MoyenDePayement.CARTE_CREDIT;
            case 2 -> MoyenDePayement.CHEQUE;
            case 3 -> MoyenDePayement.ESPECE;
            case 4 -> MoyenDePayement.VIREMENT;
            default -> throw new IllegalArgumentException("Choix impossible ! ");
        };
	}
}
