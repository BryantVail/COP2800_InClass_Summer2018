package pr4;
//Bryant Vail


import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		
		
		
		HBox hbox = new HBox();
		
		
		//circle that will be animated
		Circle orbitCircle = new Circle(75, 50, 20);
		orbitCircle.setFill(Color.ORANGE);
		
		
		//create arc
		Arc pendulumArc = new Arc(100,200,80,45,45,100);
		pendulumArc.setStroke(Color.BLACK);
		pendulumArc.setFill(Color.WHITE);
		
		
		
		//create path transition
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(4000));
		pt.setPath(pendulumArc);
		pt.setNode(orbitCircle);
		pt.setOrientation(
				PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT
				);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(true);
		pt.play();
		
		pendulumArc.setOnMousePressed(e -> {
			pt.pause();
		});
		pendulumArc.setOnMouseReleased(e -> {
			pt.play();
		});
		
		Button toggleButton = new Button("Toggle Motion");
		toggleButton.setOnAction(e -> {
			if(pt.getStatus() == Animation.Status.RUNNING) {
				pt.pause();
			}else {
				pt.play();
			}
		});
		
		//add circles to the pane
		pane.getChildren().add(hbox);
		pane.getChildren().add(orbitCircle);
		pane.getChildren().add(pendulumArc);
		
		hbox.getChildren().add(toggleButton);
		
		//create scene
		Scene scene = new Scene(pane, 250, 200);
		primaryStage.setTitle("Path Transition Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		

		
	}
}
