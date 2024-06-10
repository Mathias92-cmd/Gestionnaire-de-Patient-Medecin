package fr.univ_artois.hopital.controller;

import fr.univ_artois.hopital.model.EnumUtils;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import fr.univ_artois.hopital.model.Patient;
import fr.univ_artois.hopital.model.Sexe;

import java.util.Arrays;
import java.util.List;

public class AjouterPatientController {

    @FXML
    private TextField nomTextField;

    @FXML
    private TextField prenomTextField;

    @FXML
    private TextField ageTextField;

    @FXML
    private TextField groupeSanguinTextField;

    @FXML
    private TextField sexeTextField;

    @FXML
    private TextField tailleTextField;

    @FXML
    private TextField poidsTextField;

    @FXML
    private TextField symptomesTextField;

    @FXML
    private TextField numSecuTextField;

    @FXML
    private TextField troublesMedicauxTextField;

    private Stage dialogStage;
    private boolean okClicked = false;
    private Patient newPatient;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    public Patient getNewPatient() {
        return newPatient;
    }

    public void setPatient(Patient patient) {
        this.newPatient = patient;

        if(patient != null) {
            nomTextField.setText(patient.getNom());
            prenomTextField.setText(patient.getPrenom());
            ageTextField.setText(Integer.toString(patient.getAge()));
            groupeSanguinTextField.setText(patient.getGroupeSanguin());
            sexeTextField.setText(patient.getSexePersonne().name());
            tailleTextField.setText(patient.getTaille());
            poidsTextField.setText(patient.getPoids());
            symptomesTextField.setText(String.join(",", patient.getSymptomes()));
            numSecuTextField.setText(Integer.toString(patient.getNumeroSecuriteSociale()));
            troublesMedicauxTextField.setText(String.join(",", patient.getTroublesMedicaux()));
        }
    }

    @FXML
    private void handleValider() {
        if (isInputValid()) {
            String nom = nomTextField.getText();
            String prenom = prenomTextField.getText();
            int age = Integer.parseInt(ageTextField.getText());
            String groupeSanguin = groupeSanguinTextField.getText();
            Sexe sexe = EnumUtils.getSexeIgnoreCase(sexeTextField.getText());
            String taille = tailleTextField.getText();
            String poids = poidsTextField.getText();
            List<String> symptomes = Arrays.asList(symptomesTextField.getText().split(","));
            int numSecu = Integer.parseInt(numSecuTextField.getText());
            List<String> troublesMedicaux = Arrays.asList(troublesMedicauxTextField.getText().split(","));

            newPatient = new Patient(nom, prenom, age, groupeSanguin, sexe, taille, poids, symptomes, numSecu, troublesMedicaux);
            okClicked = true;
            dialogStage.close();
        }
    }

    private boolean isInputValid() {
        // Ajouter des validations si nécessaire
        return true;
    }
}
