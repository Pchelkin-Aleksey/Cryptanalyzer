package com.example.cryptanalyzer.Forms;

import com.example.cryptanalyzer.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ErrorForms {
    public static Stage stage = new Stage();
    public void show() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("erorr.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 200);
        stage.setTitle("Error");
        stage.setScene(scene);
        stage.show();
    }
}
