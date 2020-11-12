package ale;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class LoginController {
    @FXML
    Button login_submit;

    @FXML
    TextField login_username;

    @FXML
    PasswordField login_password;

    
    private static final String target = "http://directus.io";
    private static final String resourceProducts = "/prova/items/product";
    private static final String resourceAuth = "/prova/auth/authenticate";
    private WebTarget webTarget;

    public LoginController(){ // deve essere con visibilità 'public' ( per fxml )
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target(target);
    }

    @FXML
    void login(ActionEvent e) throws IOException {
        //Scene scene = login_submit.getScene();

        String username = login_username.getText();
        String password = login_password.getText();

        this.authenticate(username, password);
        App.setRoot("main");
    }

    private void authenticate(String username, String password){
        
        WebTarget webTargetProducts = this.webTarget.path(resourceAuth);

        // Building a http request invocation
        Invocation.Builder invocationBuilder = webTargetProducts.request(MediaType.APPLICATION_JSON);
                                                                        //MediaType.APPLICATION_XML
        Auth response = invocationBuilder.get(Auth.class);
        
        System.out.println(response.data);
    }

    private void products(){
        
        WebTarget webTargetProducts = this.webTarget.path(resourceProducts);

        // Building a http request invocation
        Invocation.Builder invocationBuilder = webTargetProducts.request(MediaType.APPLICATION_JSON);
                                                                        //MediaType.APPLICATION_XML
        Products response = invocationBuilder.get(Products.class);
        for(Product product: response.data){
            System.out.println(product.model);
        }
    }
}
