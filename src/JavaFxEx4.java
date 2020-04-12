import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxEx4 extends Application {

	Stage window;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;

		HBox topMenu = new HBox(10);

		Button fileButton = new Button("File");
		Button editButton = new Button("Edit");
		Button viewButton = new Button("View");

		topMenu.getChildren().addAll(fileButton, editButton, viewButton);

		VBox leftMenu = new VBox(10);
		Button b1 = new Button("1");
		Button b2 = new Button("2");
		Button b3 = new Button("3");

		leftMenu.getChildren().addAll(b1, b2, b3);

		BorderPane borderPane = new BorderPane();

		borderPane.setTop(topMenu);
		borderPane.setLeft(leftMenu);

		Scene scene = new Scene(borderPane);

		window.setScene(scene);
		window.show();
	}

}
