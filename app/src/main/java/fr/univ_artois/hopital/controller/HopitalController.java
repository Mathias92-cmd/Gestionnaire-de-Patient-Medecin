package fr.univ_artois.hopital.controller;

import fr.univ_artois.hopital.model.Medecin;
import fr.univ_artois.hopital.model.Patient;
import fr.univ_artois.hopital.model.RendezVous;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.ArrayList;


public class HopitalController {

    @FXML
    private ListView<Patient> listViewPatients;
    @FXML
    private ListView<Medecin> listViewMedecins;
    @FXML
    private ListView<RendezVous> listViewRendezVous;

    private ArrayList<Patient> listeDePatient = new ArrayList<>();

    private ObservableList<Patient> patientList = FXCollections.observableArrayList();
    private ObservableList<Medecin> medecinList = FXCollections.observableArrayList();
    private ObservableList<RendezVous> rendezVousList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        listViewPatients.setItems(patientList);
        listViewMedecins.setItems(medecinList);
        listViewRendezVous.setItems(rendezVousList);

        // Ajoutez des exemples de données pour tester

        rendezVousList.add(new RendezVous( "Doe John", "House Gregory", "2024-06-10", "10:00"));
        rendezVousList.add(new RendezVous( "Smith Anna", "Cuddy Lisa", "2024-06-11", "11:00"));
    }

    @FXML
    private void handleAjouterPatient() throws IOException {
        // Logique pour ajouter un patient
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr.univ_artois.hopital/view/ajoutPatient-view.fxml"));
            Parent page = loader.load();

            // Créer un nouveau stage pour le formulaire modal
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Ajouter un Patient");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(listViewPatients.getScene().getWindow());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Récupérer le contrôleur du formulaire et lui passer le stage
            AjouterPatientController controller = loader.getController();
            controller.setDialogStage(dialogStage);

            // Afficher le formulaire et attendre que l'utilisateur le ferme
            dialogStage.showAndWait();

            // Si l'utilisateur a validé, ajouter le patient à la liste
            if (controller.isOkClicked()) {
                patientList.add(controller.getNewPatient());
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    private void handleModifierPatient() {
        // Logique pour modifier un patient
        Patient selectedPatient = listViewPatients.getSelectionModel().getSelectedItem();
        if (selectedPatient != null) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fr/univ_artois/hopital/view/AjouterPatient.fxml"));
                Parent page = loader.load();

                Stage dialogStage = new Stage();
                dialogStage.setTitle("Modifier Patient");
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(listViewPatients.getScene().getWindow());
                Scene scene = new Scene(page);
                dialogStage.setScene(scene);

                AjouterPatientController controller = loader.getController();
                controller.setDialogStage(dialogStage);
                controller.setPatient(selectedPatient);

                dialogStage.showAndWait();

                if (controller.isOkClicked()) {
                    listViewPatients.refresh();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Afficher un message d'erreur si aucun patient n'est sélectionné
            System.out.println("Aucun patient sélectionné.");
        }
    }

    @FXML
    // il faut selectionner en cliquant sur le patient puis appuyer sur le bouton supprimer
    private void handleSupprimerPatient() {
        Patient selectedPatient = listViewPatients.getSelectionModel().getSelectedItem();
        if (selectedPatient != null) {
            listeDePatient.remove(selectedPatient);
            listViewPatients.getItems().remove(selectedPatient);
        } else {
            // Afficher un message d'erreur si aucun patient n'est sélectionné
            System.out.println("Aucun patient sélectionné.");
        }
    }


    @FXML
    private void handleAjouterMedecin() {
        // Logique pour ajouter un médecin
    }

    @FXML
    private void handleModifierMedecin() {
        // Logique pour modifier un médecin
    }

    @FXML
    private void handleSupprimerMedecin() {
        // Logique pour supprimer un médecin
    }

    @FXML
    private void handleAjouterRendezVous() {
        // Logique pour ajouter un rendez-vous
    }

    @FXML
    private void handleModifierRendezVous() {
        // Logique pour modifier un rendez-vous
    }

    @FXML
    private void handleSupprimerRendezVous() {
        // Logique pour supprimer un rendez-vous
    }

    @FXML
    private void handleQuitter() {
        // Logique pour quitter l'application
        System.exit(0);
    }
}
