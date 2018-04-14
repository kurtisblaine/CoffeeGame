package ch.makery.coffee.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ch.makery.coffee.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainMenuController extends Main{
	
	// Reference to the main application
    private Main mainApp;
  
        @FXML
        private Button newGame;
        @FXML
        private Button highScores;
        
    //reference back to main
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }
    
    //handles exit java
	@FXML
	private void handleExit() {
		System.exit(0);
	}
	
	//handles high score button
	@FXML
	private void handleHighScores(ActionEvent event) throws IOException{
		   //new loader
		   FXMLLoader loader = new FXMLLoader();
	       loader.setLocation(Main.class.getResource("view/HighScores.fxml"));
	       AnchorPane highScores = loader.load();
	       
	       //rootlayout to anchorpane
	       rootLayout.setCenter(highScores); 
	}
	

	//handles new game button
	@FXML
	 private void handleNewGame(ActionEvent event) throws IOException{
		   //new loader
	       FXMLLoader loader = new FXMLLoader();
	       loader.setLocation(Main.class.getResource("view/NewGame.fxml"));
	       AnchorPane newGame = loader.load();
	       
	       //rootlayout to anchorpane
	       rootLayout.setCenter(newGame); 
	       
	       Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("CoffeeGame");
	        alert.setHeaderText("Coffee Order!");
	        alert.setContentText("Hey, New Guy! Coffee order just arrived!" + "\n" + "Caramel Mocchiato, stat!" +
	        "\n" + "If you need some help, navigate yourself to the help button in the header");
	        alert.showAndWait();
	       }
	
  }
	
	    
	

