package fr.univ_artois.hopital.model;

import java.util.Scanner;

public class DemoHopital{
	
	public static void main(String[] args) {
		// Menus
		int choix;
		Patient patient = null;
		Scanner in = new Scanner(System.in);
		
		do {
			
			System.out.println("Veuillez entrer un nombre pour effectuer une opération : ");
			System.out.println(" 1 : Création d'un Patient et ajout \n 2 : supression d'un patient \n 3 : Afficher les patients \n 4 : Création et ajout d'un médecin  \n 5 : supprimer un médecin \n 6 : afficher les médecins \n 7 : Affichage des personnes  \n 8 : supprimer une personnes \n 9 : Création de l'ordonance  \n 10 : Afficher les ordonnances \n 11 : Historique médical du dernier patient \n 12 : Module de recherche \n 13 : Facturation \n 14 : FeedBack \n 15 : Arrêter ");
			
			do {
				// Menu principal
			    choix = in.nextInt();
			}while(choix < 0 && choix > 20);
			
			// Création d'un menu à l'aide d'un switch
			switch (choix) {
			case 1:
				System.out.println("Veuillez entrer les informations du patient : ");
				
				System.out.println("Nom : ");
				String nom = in.next();
				
				System.out.println("Prénom : ");
				String prenom = in.next();
								
				System.out.println("Age : ");
				int age = in.nextInt();
				
				System.out.println("Sexe (HOMME ou FEMME) : ");
				String sexeStr = in.next();
				Sexe sexePersonne;
				
				System.out.println("Groupe Sanguin : ");
				String groupeSanguin = in.next();
				
				System.out.println("Taille : ");
				String taille = in.next();
				
				System.out.println("Poids : ");
				String poids = in.next();
				
				System.out.println("Symptômes : ");
				String symptomes = in.next();
				
				System.out.println("Maladie : ");
				String maladie = in.next();
				
				System.out.println("N° de securite sociale : ");
				int securiteSociale = in.nextInt();

				break;
				
			case 8 :
				// Suppression d'une personne
				System.out.println("Veuillez entrer l'identifiant de la personne à supprimer : ");
				int idASupprimer = in.nextInt();
	
			    // Appeler la méthode suprimmerPersonneParId pour supprimer la personne par son identifiant
			    break;
				
			case 7 : 
				// Affichage des personnes
				break;
				
			case 4 : 
				// Création d'un médecin
			    System.out.println("Création d'un médecin :");
			    
			    System.out.println("Entrez le nom du médecin : ");
			    String nomMedecin = in.next();
			    
			    System.out.println("Entrez le prénom du médecin : ");
			    String prenomMedecin = in.next();
			    
			    System.out.println("Entrez l'identifiant du médecin : ");
			    int idMedecin = in.nextInt();
			    			    
			    System.out.println("Entrez l'âge du médecin : ");
			    int ageMedecin = in.nextInt();
			    
			    System.out.println("Entrez le sexe du médecin (HOMME ou FEMME) : ");
			    String sexeMedecinStr = in.next();

			    
			    System.out.println("Entrez la spécialisation du médecin : ");
			    String specialisation = in.next();
	
			    // Créer une instance de Medecin

				
			case 5:
				int idASupprimerMedecin = in.nextInt();
				

				
			case 6 : 

				
			case 3 :

				
			case 2:
				 System.out.println("Entrez le nom du patient que vous voulez suprimer : ");
				 String nomPatientSupr = in.next();

				 
			case 9:
				// Nous demandons à l'utilisateur de saisir les informations pour créer une ordonnance
			    System.out.println("Création d'une ordonnance :");

			    System.out.println("Entrez les médicaments prescrits (séparés par des virgules) : ");
			    String medPrescritsStr = in.next();
			    String[] medPrescrits = medPrescritsStr.split(",");

			    System.out.println("Entrez la posologie (séparée par des virgules) : ");
			    String posologieStr = in.next(); // Nous utilisons nextLine() pour lire toute la ligne
			    String[] posologieSplitStr = posologieStr.split(",");

			    // Nous créons un tableau d'entiers pour stocker les valeurs de posologie
			    int[] posologieSplit = new int[posologieSplitStr.length];

			    // Nous convertisons chaque élément du tableau de chaînes en un entier
			    for (int i = 0; i < posologieSplitStr.length; i++) {
			        // Nous utilisons "Integer.parseInt()" pour convertir une chaîne en un entier
			    	posologieSplit[i] = Integer.parseInt(posologieSplitStr[i]);
			    }

			    System.out.println("Entrez la durée de traitement : ");
			    int dureeT = in.nextInt();
			    in.nextLine();

			    System.out.println("Entrez les informations supplémentaires : ");
			    String infosMStr = in.nextLine();
			    String[] infosM = infosMStr.split(",");

			    // Créer une instance d'ordonnance
			    Ordonnance ordonnance = new Ordonnance(medPrescrits, posologieSplit, dureeT, infosM);
			    
			    //Ajout de l'ordonnance dans le tableau de répartitions des ordonnaces
			    Ordonnance.ajouteOrdonnance(ordonnance);

			    // Afficher les détails de l'ordonnance
			    System.out.println("Ordonnance créée :");
			    Ordonnance.affichageOrdonnance();
				break;
				
			case 10:
				// Affichage des ordonnances
				System.out.println("Voici les ordonnances créées : ");
				Ordonnance.affichageOrdonnance();
				break;
				
			case 11:
				// Ajout d'un historique médical pour le dernier patient
			    if (patient == null) {
			        System.out.println("Veuillez d'abord créer un patient.");
			    } else {
			        System.out.println("Entrez les informations de la visite médicale : ");
			        
			        System.out.println("Date de la visite : ");
			        String dateVisite = in.next();
			        
			        System.out.println("Diagnostic : ");
			        String diagnostic = in.next();
			        
			        System.out.println("Traitements : ");
			        String traitements = in.next();
			        
			        // Création de l'historique médical
			        HistoriqueMedical historiqueMedical = new HistoriqueMedical(dateVisite, diagnostic, traitements, patient);
			        
			        // Ajout de l'historique médical au patient

			        
			        System.out.println("Historique médical ajouté pour le patient : " + patient.getNom() + " " + patient.getPrenom());
			    }
			    break;
			    
			case 12:
				// Module de recherche
			    System.out.println("Veuillez sélectionner le critère de recherche : ");
			    System.out.println("1 : Recherche par nom du patient");
			    System.out.println("2 : Recherche par prénom du patient");
			    System.out.println("3 : Recherche par groupe sanguin du patient");
			    System.out.println("4 : Recherche par nom du médecin");
			    System.out.println("5 : Recherche par spécialité du médecin");
			    
			    int critereRecherche = in.nextInt();

			    switch (critereRecherche) {
				    case 1:

			        break;
			        case 2:

			            
			            break;
			        case 3:

			            break;
			        case 4:

			            break;
			        case 5:

			            break;
			        default:
			            System.out.println("Critère de recherche invalide.");
			            break;
			    }
			    break;
			  
			case 13:
				break;
				
			case 14:
				break;
				
			case 15:
				System.out.println("Vous avez bien arrêter !!");
				System.exit(0);
				
			default:
				System.out.println("Mauvaise opération entrer !!");
				break;
			}
		
		}while(choix != 15);
	}
}
