

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxEx14 extends Application {

	Stage window;
	int count = 0;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;

		window.setTitle("Window Title");

		TextField userInput = new TextField();
		userInput.setMaxWidth(200);
		Label label = new Label("Welcom to the site ");
		Label label2 = new Label("");
		
		HBox bottomText = new HBox();
		bottomText.getChildren().addAll(label, label2);
		bottomText.setAlignment(Pos.BOTTOM_CENTER);
		
		VBox vbox = new VBox(10, userInput, bottomText);
		vbox.setAlignment(Pos.CENTER);
		
		label2.textProperty().bind(userInput.textProperty());
		
		Scene scene = new Scene(vbox, 300, 300);
		window.setScene(scene);
		window.show();
	}

}
