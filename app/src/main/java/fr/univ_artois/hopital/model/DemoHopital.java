package fr.univ_artois.hopital.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DemoHopital{
	static Scanner in = new Scanner(System.in);

	// Logger
	private static final Logger LOGGER = LogManager.getLogger(DemoHopital.class.getPackage().getName());

	// Attributes
	static Patient patient;
	static Medecin medecin;
	static RendezVous rendezVous;
	static Ordonnance ordonnance;
	static HistoriqueMedical historique;
	static Facturation facture;
	static Feedback feedBack;

	/**
	 * Permet d'afficher le menu de l'application
	 *
	 */
	public static void displayMenu(){
		LOGGER.info("Veuillez entrer un nombre pour effectuer une opération : ");
		LOGGER.info("""
					1 : Création d'un patient et ajout
					2 : Suppression d'un patient
					3 : Afficher les patients
					4 : Création et ajout d'un médecin
					5 : supprimer un médecin
					6 : afficher les médecins
					7 : Création d'un rendez-vous
					8 : Afficher les rendez-vous
					9 : supprimer un rendez-vous
					10 : Création de l'ordonnance
					11 : Afficher les ordonnances
					12 : Afficher l'ordonnance d'un patient
					13 : Afficher l'Historique médical de tous les patients
					14 : Afficher l'Historique médical d'un patient
					15 : Recherche
					16 : Créer une facture
					17 : Envoyer un FeedBack
					18 : Quitter
					""");
	}

	public static void creationPatient(){
		LOGGER.info("Entrez le nom du patient : ");
		String nom = in.next();

		LOGGER.info("Entrez le prénom du patient : ");
		String prenom = in.next();

		LOGGER.info("Entrez l'age du patient : ");
		int age = in.nextInt();

		LOGGER.info("Entrez le groupe sanguin du patient : ");
		String groupeSanguin = in.next();

		LOGGER.info("Entrez le sexe du patient (Homme, Femme, Autre) : ");
		String sexePersonne = in.next();
		Sexe sexe = Sexe.valueOf(sexePersonne);

		LOGGER.info("Entrez la taille du patient : ");
		String taille = in.next();

		LOGGER.info("Entrez le poids du patient : ");
		String poids = in.next();

		LOGGER.info("Entrez les symptomes du patient (séparé par des virgules) : ");
		String[] symptomesArray = in.next().split("\\s*,\\s*|\\s+");
		List<String> symptomes = new ArrayList<>();
		for (String symptome : symptomesArray) {
            symptomes.add(symptome);
        }

		LOGGER.info("Entrez le numéro de sécurité sociale du patient :");
		int numeroSecuriteSocial = in.nextInt();

		LOGGER.info("Entrez les troubles médicaux du patient (séparé par des virgules) : ");
		String[] troublesMedicauxArray = in.next().split("\\s*,\\s*|\\s+");
		List<String> troublesMedicaux = new ArrayList<>();
		for (String trouble : troublesMedicauxArray) {
            troublesMedicaux.add(trouble);
        }

		creationHistoriqueMedical(nom);

		patient = new Patient(nom, prenom, age, groupeSanguin, sexe, taille, poids, symptomes, numeroSecuriteSocial, troublesMedicaux);

		patient.ajoutHistorique(historique);
		patient.ajouterPatient(patient);

	}

	public static void displayRecherche(){
		int choixRecherche;
		LOGGER.info("Que voulez-vous rechercher? ");
		LOGGER.info("""
						1 : Rechercher un patient par son nom
						2 : Rechercher un patient par un critère de recherche
						3 : Rechercher un medecin par sa spécialité
						4 : Rechercher un medecin par son nom
						5 : Rechercher un medecin par un critère de recherche
						6 : Quitter
						""");
		try {
			choixRecherche = in.nextInt();
		}catch (InputMismatchException e){
			choixRecherche = 6;
		}
		switch (choixRecherche){
			case 1:
				LOGGER.info("Rechercher un patient par son nom : ");
				String nomPatientRecherche = in.next();
				patient.rechercherParNom(nomPatientRecherche);
				break;

			case 2:
				LOGGER.info("Rechercher un patient par un critère de recherche : ");
				String critereRecherche = in.next();
				patient.rechercherGenerale(critereRecherche);
				break;

			case 3:
				LOGGER.info("Rechercher un medecin par sa spécialité : ");
				String specialiteRecherche = in.next();
				medecin.rechercherParSpecialite(specialiteRecherche);
				break;

			case 4:
				LOGGER.info("Rechercher un medecin par son nom : ");
				String nomMedecinRecherche = in.next();
				medecin.rechercherParNom(nomMedecinRecherche);
				break;

			case 5:
				LOGGER.info("Rechercher un medecin par un critère de recherche : ");
				String critereRechercheMedecin = in.next();
				medecin.rechercherGenerale(critereRechercheMedecin);
				break;

			case 6:
				LOGGER.info("Au revoir!");
				break;

			default:
				LOGGER.error("Veuillez entrer un nombre valide!!");
		}
	}

	public static void creationMedecin(){
		LOGGER.info("Entrez le nom du médecin : ");
        String nom = in.next();

        LOGGER.info("Entrez le prénom du médecin : ");
        String prenom = in.next();

        LOGGER.info("Entrez l'age du médecin : ");
        int age = in.nextInt();

        LOGGER.info("Entrez les spécialisation du médecin : ");
		String[] specialitationTab = in.next().split(",\\s");
		ArrayList<String> specialisation = new ArrayList<>();
		for (String spe : specialitationTab) {
			specialisation.add(spe);
		}

        LOGGER.info("Entrez le sexe du médecin (Homme, Femme, Autre) : ");
        String sexePersonne = in.next();
        Sexe sexe = Sexe.valueOf(sexePersonne);

		medecin = new Medecin(nom, prenom, specialisation, age, sexe);

		medecin.ajouterMedecin(medecin);
	}

	public static void creationRendezVous(){
		LOGGER.info("Entrez le nom du patient pour le rendez-vous : ");
		String nomPatientRendezVous = in.next();

		LOGGER.info("Entrez le nom du médecin pour le rendez-vous : ");
		String nomMedecinRendezVous = in.next();

		LOGGER.info("Entrez la date du rendez-vous : ");
		String dateRendezVous = in.next();

		LOGGER.info("Entrez l'heure du rendez-vous : ");
		String heureRendezVous = in.next();

		rendezVous = new RendezVous(nomPatientRendezVous, nomMedecinRendezVous, dateRendezVous, heureRendezVous);

		rendezVous.ajoutRendezVous(rendezVous);

		LOGGER.info("Le rendez-vous a bien été ajouté");
	}

	public static void creationOrdonnance(){
		LOGGER.info("Entrez le nom du patient pour l'ordonnance : ");
        String nomPatientOrdonnance = in.next();

        LOGGER.info("Entrez la date de l'ordonnance : ");
        String dateOrdonnance = in.next();

        LOGGER.info("Entrez les médicaments de l'ordonnance (séparé par des virgules) : ");
		String[] medicamentsArray = in.next().split("\\s*,\\s*|\\s+");
		List<String> medicaments = new ArrayList<>();
		for (String medicament : medicamentsArray) {
            medicaments.add(medicament);
        }

		ordonnance = new Ordonnance(medicaments, nomPatientOrdonnance, dateOrdonnance);
		ordonnance.ajouteOrdonnance(ordonnance);
	}

	public static void creationHistoriqueMedical(){
		LOGGER.info("Entrez l'historique médical du patient : ");
		LOGGER.info("Entrez la dernière visites du patient: ");
		String visite = in.next();

		LOGGER.info("Entrez le diagnostic du patient : ");
		String diagnostic = in.next();

		LOGGER.info("Entrez les traitements du patient : ");
		String traitements = in.next();

		LOGGER.info("Entrez le nom du patient : ");
		String nom = in.next();

		historique = new HistoriqueMedical(visite, diagnostic, traitements, nom);
	}

	public static void creationHistoriqueMedical(String nomPatient){
		LOGGER.info("Entrez l'historique médical du patient : ");
		LOGGER.info("Entrez la dernière visites du patient: ");
		String visite = in.next();

		LOGGER.info("Entrez le diagnostic du patient : ");
		String diagnostic = in.next();

		LOGGER.info("Entrez les traitements du patient : ");
		String traitements = in.next();

		historique = new HistoriqueMedical(visite, diagnostic, traitements, nomPatient);
	}

	public static void creationDeFacture(){
		double coutFacture = 0;
		LOGGER.info("Entrez le nom du patient pour la facture : ");
		String nomPatientFacture = in.next();

		LOGGER.info("Entrez le details de la facture : ");
		String detailsFacture = in.next();

		LOGGER.info("Entrez le moyen de paiement : ");
		MoyenDePayement moyenPaiement = MoyenDePayement.valueOf(in.next());

		LOGGER.info("Entrez le cout de la facture : ");
		try {
			coutFacture = in.nextDouble();
		}catch (InputMismatchException e){
			LOGGER.error("Veuillez entrer un nombre valide!!");
		}

		facture = new Facturation(nomPatientFacture, detailsFacture, moyenPaiement, coutFacture);

		facture.ajoutFacture(facture);
	}

	public static void creationFeedBack(){
		LOGGER.info("Entrez l'id du patient : ");
		int idPatient = in.nextInt();

		LOGGER.info("Entrez l'id du medecin': ");
		int idMedecin = in.nextInt();

		LOGGER.info("Entrez le commentaire : ");
		String commentaire = in.next();

		LOGGER.info("Entrez la note : ");
		Notation note = Notation.valueOf(in.next());

		LOGGER.info("Entrez la date du feedback : ");
		String dateFeedback = in.next();

		feedBack = new Feedback(idPatient, idMedecin, commentaire, dateFeedback , note);

	}



	public static void main(String[] args) {
		// Menus
		int choix;

		// Menu principal
		do {

			displayMenu();

			try {
				choix = in.nextInt();
			} catch (InputMismatchException e) {
				choix = 18;
				LOGGER.error("Veuillez entrer un nombre valide !!");
			}

			switch (choix) {
				case 1:
					LOGGER.info("Création d'un patient et ajout");
					creationPatient();
					LOGGER.info("Le patient a bien été ajouté");
					break;

				case 2:
					LOGGER.info("Suppression d'un patient");
					LOGGER.info("Entrez le nom du patient à supprimer : ");
					String nomPatient = in.nextLine();
					patient.supprimerPatientParNom(nomPatient);
					LOGGER.info("Le patient a bien été supprimé");
					break;

				case 3:
					LOGGER.info("Afficher les patients");
					LOGGER.info("Voici la liste des patients : ");
					patient.afficherPatient();
					break;

				case 4:
					LOGGER.info("Création et ajout d'un médecin");
					creationMedecin();
					LOGGER.info("Le medecin a bien été ajouté");
					break;

				case 5:
					LOGGER.info("Supprimer un médecin");
					LOGGER.info("Entrez le nom du médecin à supprimer : ");
					String nomMedecin = in.nextLine();
					medecin.supprimerMedecinParNom(nomMedecin);
					break;

				case 6:
					LOGGER.info("Afficher les médecins");
                    LOGGER.info("Voici la liste des médecins : ");
                    medecin.afficherMedecin();
                    break;

                case 7:
					LOGGER.info("Création d'un rendez-vous");
					creationRendezVous();
					break;

				case 8:
					LOGGER.info("Afficher les rendez-vous");
					LOGGER.info("Voici la liste des rendez-vous : ");
					rendezVous.afficherRendezVous();
					break;

				case 9:
					LOGGER.info("Supprimer un rendez-vous");
					LOGGER.info("Entrez le nom du patient du rendez-vous à supprimer : ");
				    String nomPatientRendezVous = in.next();
					rendezVous.supprimerRendezVous(nomPatientRendezVous);
					LOGGER.info("Le rendez-vous a bien été supprimé");
					break;

				case 10:
					LOGGER.info("Création d'une ordonnance");
					creationOrdonnance();
					LOGGER.info("L'ordonnance a bien été ajoutée");
					break;

				case 11:
					LOGGER.info("Afficher les ordonnances");
					LOGGER.info("Voici la liste des ordonnances : \n");
					ordonnance.affichageOrdonnance();
					break;

				case 12:
					LOGGER.info("Afficher l'ordonnances d'un patient");
					LOGGER.info("Entrez le nom du patient : ");
					String nomPatientOrdonnance = in.next();
					LOGGER.info("Voici la liste des ordonnances du patient: \n");
					ordonnance.affichageOrdonnance(nomPatientOrdonnance);
					break;

				case 13 :
					historique.afficherHistorique();
					break;

				case 14 :
					LOGGER.info("Entrez le nom du patient : ");
					String nomPatientHistorique = in.next();
					historique.afficherHistorique(nomPatientHistorique);
					break;

				case 15 :
					displayRecherche();
					break;

				case 16:
					LOGGER.info("Création d'une facture");
					creationDeFacture();
					try {
						facture.genereFacture();
					}catch (FileNotFoundException e){
						LOGGER.error("Le fichier n'a pas pu être généré");
					}
					break;

                case 17:
					LOGGER.info("Création d'un feedback");
					creationFeedBack();
					break;

				case 18:
					LOGGER.info("Au revoir!");
					break;

				default:
					break;
			}

		} while (choix > 0 && choix < 18);

		in.close();
	}
}
