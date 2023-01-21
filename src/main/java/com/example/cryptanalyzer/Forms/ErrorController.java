package com.example.cryptanalyzer.Forms;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ErrorController implements Initializable {

    public static String errorName;
    @FXML
    private Text TextError;

    public void onSkip() {
        Stage stage = ErrorForms.stage;
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextError.setText(errorName);
    }
}
