package com.example.cryptanalyzer.services;
import com.example.cryptanalyzer.Forms.ErrorController;
import com.example.cryptanalyzer.Forms.ErrorForms;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileEditor {
    private final String path;

    public FileEditor(String path){
        this.path = path;
    }

    private Path getPath(){
        Path file_path = null;
        if (path != null && !path.equals("")){
            file_path = Path.of(path);
            if (Files.isRegularFile(file_path) && Files.exists(file_path))
                return file_path;
        }
        return file_path;
    }

    public String getContentFile() throws IOException {
        ErrorForms errorForms = new ErrorForms();
        ErrorController.errorName = "Не верный путь к файлу";
        if (getPath() == null)
            errorForms.show();
        return Files.readString(getPath());
    }

    public void saveFile(String content) throws IOException {
        ErrorForms errorForms = new ErrorForms();
        ErrorController.errorName = "Не верный путь к файлу";
        if (getPath() == null)
           errorForms.show();
        Files.createFile(getPath());
        Files.writeString(getPath(), content);
    }
}