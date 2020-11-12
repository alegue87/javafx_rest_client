module ale {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.annotation;
    requires jakarta.ws.rs;
    requires jakarta.xml.bind;
    
    opens ale to javafx.fxml;
    exports ale;
}