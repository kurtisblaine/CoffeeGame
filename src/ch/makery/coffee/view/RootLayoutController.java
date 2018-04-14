package ch.makery.coffee.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import java.io.IOException;

import ch.makery.coffee.Main;


 //root layout controller
public class RootLayoutController{

    // Reference to the main application
    private Main mainApp;

    //Is called by the main application to give a reference back to itself.
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    //handles about in main menu
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("CoffeeGame");
        alert.setHeaderText("About");
        alert.setContentText("Select 'New Game' to begin the coffee gaming experience. Click on the coffee cup and complete the specified coffee "
        		+ "in the correct order sequence:" + "\n" + "Coffee with cream = Coffee and milk" + "\n"
        		+ "Caramel Americano = Espresso and caramel" + "\n" + "Hazelnut Latte = milk, espresso and hazelnut" + "\n" +
"Caramel Mocchiato = coffee, milk, espresso, ice and caramel" + "\n" +
"Author group: Sioux Falls Java. ");

        alert.showAndWait();
    }

    //handles close in main menu
    @FXML
    private void handleExit() {
        System.exit(0);
    }
    
    @FXML
    private void handleGoHome(){
    	Main.showMainMenu();
    }
    
}