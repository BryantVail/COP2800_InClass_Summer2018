//Bryant Vail

package pr3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		TextField txtOutput = new TextField("Selection");
		
		//stage
		primaryStage.setTitle("Project 3");
		
		
		VBox vbox = new VBox();
		RadioButton radio1 = new RadioButton("1");
		RadioButton radio2 = new RadioButton("2");
		RadioButton radio3 = new RadioButton("3");
		//ToggleGroup
		ToggleGroup radioGroup = new ToggleGroup();
		//set ToggleGroup
		radio1.setToggleGroup(radioGroup);
		radio1.setSelected(true);
		
		radio2.setToggleGroup(radioGroup);
		
		radio3.setToggleGroup(radioGroup);
		
		radio1.setOnAction(e ->{
			txtOutput.setText("Value: 1 Selected");
		});
		radio2.setOnAction(e ->{
			txtOutput.setText("Value: 2 Selected");
		});
		radio3.setOnAction(e ->{
			txtOutput.setText("Value: 3 Selected");
		});
		
		//label
		Label lblQuestion = new Label("How many do you select?");
		
		vbox.getChildren().add(lblQuestion);
		vbox.getChildren().add(radio1);
		vbox.getChildren().add(radio2);
		vbox.getChildren().add(radio3);
		vbox.getChildren().add(txtOutput);
		
		Scene sceneMain = new Scene(vbox, 300,300);
		primaryStage.setScene(sceneMain);
		primaryStage.show();
	}//end public void start
	
	public static void main(String[] args) {
			
		Application.launch(args);

	}

}
