module com.example.cryptanalyzer {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.cryptanalyzer to javafx.fxml;
    exports com.example.cryptanalyzer;
    exports com.example.cryptanalyzer.services;
    opens com.example.cryptanalyzer.services to javafx.fxml;
    exports com.example.cryptanalyzer.Forms;
    opens com.example.cryptanalyzer.Forms to javafx.fxml;
}