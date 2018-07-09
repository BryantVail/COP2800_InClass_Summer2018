package pr3;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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
		
		//circle that will be animated
		Circle orbitCircle = new Circle(75, 50, 20);
		orbitCircle.setFill(Color.ORANGE);
		
		
		//circle for arc
		Circle arcCircle = new Circle(125, 100, 50);
		arcCircle.setFill(Color.WHITE);
		arcCircle.setStroke(Color.BLACK);
		
		//add circles to the pane
		pane.getChildren().add(orbitCircle);
		pane.getChildren().add(arcCircle);
		
		//create path transition
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(4000));
		pt.setPath(arcCircle);
		pt.setNode(orbitCircle);
		pt.setOrientation(
				PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT
				);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(true);
		pt.play();
		
		arcCircle.setOnMousePressed(e -> {
			pt.pause();
		});
		arcCircle.setOnMouseReleased(e -> {
			pt.play();
		});
		
		//create scene
		Scene scene = new Scene(pane, 250, 200);
		primaryStage.setTitle("Path Transition Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
