import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxEx3 extends Application {

	Stage window;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;

		window.setTitle("Example of an Alert Box");

		Button button = new Button("Raise Alert");
		button.setOnAction(e -> MyAlertBox.display("ALERT!!!", e.toString()));

		StackPane layout = new StackPane();
		layout.getChildren().addAll(button);

		Scene scene= new Scene(layout, 200, 200);

		window.setScene(scene);;
		window.show();
	}

}
