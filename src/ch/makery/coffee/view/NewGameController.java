package ch.makery.coffee.view;

import java.io.IOException;

import ch.makery.coffee.Main;
import ch.makery.coffee.Orders;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseDragEvent;


public class NewGameController{

	// Reference to the main application
	private Main mainApp;
	private Orders order;

	//is called by the main application to give a reference back to itself.
	public void setMainApp(Main mainApp) {
		//set cursor to empty cup
		Scene scene = new Scene(mainApp.rootLayout);
		this.mainApp = mainApp;
	}

	@FXML
	private void initialize() {

		order = new Orders();
	}


	//TODO: handle new cup event
	@FXML
	private void handleEmptyCups(ActionEvent event) throws IOException{

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Add ingredient.");
		alert.setHeaderText(null);
		alert.setContentText( order.addItem( Orders.EMPTY_CUPS ) );
		alert.showAndWait();

	}

	//TODO: handle coffee event
	@FXML
	private void handleCoffee(ActionEvent event) throws IOException{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Add ingredient.");
		alert.setHeaderText(null);
		alert.setContentText( order.addItem( Orders.COFFEE ) );
		alert.showAndWait();

	}


	//TODO: handle ice event
	@FXML
	private void handleIce(ActionEvent event) throws IOException{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Add ingredient.");
		alert.setHeaderText(null);
		alert.setContentText( order.addItem( Orders.ICE ) );
		alert.showAndWait();
	}


	//TODO: handle espresso event
	@FXML
	private void handleEspresso(ActionEvent event) throws IOException{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Add ingredient.");
		alert.setHeaderText(null);
		alert.setContentText( order.addItem( Orders.ESPRESSO ) );
		alert.showAndWait();
	}


	//TODO: handle milk event
	@FXML
	private void handleMilk(ActionEvent event) throws IOException{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Add ingredient.");
		alert.setHeaderText(null);
		alert.setContentText( order.addItem( Orders.MILK ) );
		alert.showAndWait();
	}

	//TODO: handle caramel event
	@FXML
	private void handleCaramel(ActionEvent event) throws IOException{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Add ingredient.");
		alert.setHeaderText(null);
		alert.setContentText( order.addItem( Orders.CARAMEL ) );
		alert.showAndWait();
	}

	//TODO: handle Hazelnut
	@FXML
	private void handleHazelnut(ActionEvent event) throws IOException{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Add ingredient.");
		alert.setHeaderText(null);
		alert.setContentText( order.addItem( Orders.HAZEINUT ) );
		alert.showAndWait();
	}

	@FXML
	private void handleCurrentOrder(ActionEvent event) throws IOException{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Current order.");
		alert.setHeaderText(null);
		alert.setContentText( order.printCurrentOrder() );
		alert.showAndWait();
	}

	@FXML
	private void handleCurrentItems(ActionEvent event) throws IOException{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Current items.");
		alert.setHeaderText(null);
		alert.setContentText( order.printCurrentItems() );
		alert.showAndWait();
	}

	//TODO: handle submit event
	@FXML
	private void handleSubmit(ActionEvent event) throws IOException{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Submit order.");
		alert.setHeaderText(null);
		alert.setContentText( order.submit() );
		alert.showAndWait();

		if( order.isM_orderMade() == true )
		{
			alert.setTitle("new order.");
			alert.setHeaderText(null);
			alert.setContentText( order.newOrder() );
			alert.showAndWait();
		}
	}


	//TODO: handle trash drag over event
	@FXML
	public final ObjectProperty<EventHandler<? super MouseDragEvent>> onMouseDragOverProperty(){

		//TODO: return cleared ingredients
		return null;

	}



}//end new game controller

/*
 * *******Main Program
boolean play = true;
int difficulty = 2;

createOrder(int diff)
{
for (int x = 0; x < 2; x++ )
// placedOrder[x] = <<Drink Generated using RNG?>> 1 = latte, 2 = icedCoffee, 3 = caramelCoffee
}

//TODO: Write main program, which will basically be...
// initialize and place all the objects on screen

do{
	createOrder(difficulty);
	//display order & run game
	//wait for submit from user
	//give score
	//ask to play again
	//if no, play = false

}while play == true;


 *******CoffeeBar

//TODO: address of Location on screen
Static String drinkInProg[10];
Static String completedOrder[10];
Static String placedOrder[10];
Static boolean haveCup = false;
Static int ingredientCount = 0;




 *******CoffeeBarObject extendsCoffeeBar // There won't be an actual "CoffeeBarObject" actually created or placed anywhere, just skeleton for the other objects

//TODO: Hitbox size
boolean hitboxClickable = true;
boolean hitboxVisable = true;
String ingredient = "";

//TODO: Event triggered on click
{
	if (CupStack.haveCup == true)
	{
		if (ingredientCount < 5)
		{
			drinkInProg[ingredientCount] = ingredient;
			ingredientCount++;
			this.hitboxClickable = false;
		}
	}
}

 *******CoffeePot extends CoffeeBarObject

this.ingredient = "coffee";

 *******IceMachine extends CoffeeBarObject

this.ingredient = "ice";

 *******MilkJug extends CoffeeBarObject

this.ingredient = "milk";

 *******CaramelPump extends CoffeeBarObject

this.ingredient = "caramel";


 *******CupStack extends CoffeeBar

//Event triggered on click
if (haveCup == false)
	haveCup = true;
	//TODO: change mouse curser from standard arrow (or hand) to coffee cup icon


 *****PickupWindow extends CoffeeBarObject

String drinkName = "";
int drinkCount = 0;

//Event triggered on click !!!Method Overload the event inherited from CoffeeBarObject
{
	if(haveCup == true)
		{
		//TODO: loop to scan drinkInProg[] to check ingredients
		//assign String to drinkName according to ingredients in drinkInProg[]
		completedOrder[drinkCount] = drinkName;
		drinkCount++;
		ingredientCount = 0;
		haveCup = false;
		//TODO: change mouse curser from coffee cup icon to standard arror (or hand)
		}

}

 *******SubmitButton extends CoffeeBarObject // Not sure if it really makes sense to extend here since it does have an ingredient

//Event triggered on click !!!Method Overload the event inherited from CoffeeBarObject
{
	if(haveCup == false)
		{
		//TODO: ask if user wants to submit
		// if yes, scan completedOrder[] and compare to placedOrder[]
		//Assign score/check pass fail etc.
		}
}
 */

