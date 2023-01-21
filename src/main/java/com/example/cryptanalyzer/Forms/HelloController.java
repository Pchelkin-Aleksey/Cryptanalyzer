package com.example.cryptanalyzer.Forms;

import com.example.cryptanalyzer.services.Decoder;
import com.example.cryptanalyzer.services.EnCoder;
import com.example.cryptanalyzer.services.FileEditor;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.*;
public class HelloController implements Initializable {
    @FXML
    private Button ButtonShowDownload;
    @FXML
    private TextField TextKey;
    @FXML
    private TextArea ReadTextF;
    @FXML
    private TextField FiledPathField;
    @FXML
    private ToggleButton ToggleButton;
    @FXML
    private TextArea TextResult;
    @FXML
    private ListView ListResults;

    @FXML
    protected void onToggleButton() {
        if (ToggleButton.isSelected()) {
            ButtonShowDownload.setText("Сохранить");
            ToggleButton.setText("Расшифровать");
        }
        else {
            ButtonShowDownload.setText("Загрузить");
            ToggleButton.setText("Зашифровать");
        }
    }

    @FXML
    protected void onСalculate(){
        EnCoder enCoder = new EnCoder();
        Decoder decoder = new Decoder();
        String result;
        if (TextKey.getText() == null)
            TextKey.setText("1");

        if (!ToggleButton.isSelected())
            result = enCoder.inCode(Integer.parseInt(TextKey.getText()), ReadTextF.getText());
        else{
            result = decoder.decode(ReadTextF.getText(), Integer.parseInt(TextKey.getText()));
        }
        TextResult.setText(result);
    }
    @FXML
    protected void onBruteForce()  {
        ListResults.getItems().clear();
        Decoder decoder = new Decoder();
        ListResults.getItems().addAll(decoder.bruteForce(ReadTextF.getText()));
    }
    @FXML
    protected void onSelected() {
        TextKey.setText(String.valueOf(ListResults.getSelectionModel().getSelectedIndex()));
        TextResult.setText(ListResults.getSelectionModel().getSelectedItems().toString());
    }


    @FXML
    protected void onSetTextFile() throws IOException {
        FileEditor file = new FileEditor(FiledPathField.getText());
        if (!ToggleButton.isSelected())
            ReadTextF.setText(file.getContentFile());
        else {
            String content = ReadTextF.getText();
            file.saveFile(content);
        }
    }

    @FXML
    protected void onSelectFile(){
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Смотреть txt файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            FiledPathField.setText(file.getPath());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextKey.setText("1");
    }
}