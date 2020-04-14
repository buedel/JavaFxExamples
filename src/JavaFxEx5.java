
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JavaFxEx5 extends Application {

	Stage window;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(8);
		grid.setHgap(10);

		// Name
		Label nameLabel = new Label("Username:");
		GridPane.setConstraints(nameLabel, 0, 0);
		TextField nameText = new TextField("default");
		GridPane.setConstraints(nameText, 1, 0);

		// Password
		Label pwLabel = new Label("Password:");
		GridPane.setConstraints(pwLabel, 0, 1);
		TextField pwText = new TextField();
		pwText.setPromptText("be careful");
		GridPane.setConstraints(pwText, 1, 1);
		Button loginButton = new Button("Login");
		GridPane.setConstraints(loginButton, 1, 2);

		loginButton.setOnAction(e -> System.out.println(nameText.getText()));

		grid.getChildren().addAll(nameLabel, nameText, pwLabel, pwText, loginButton);

		Scene scene = new Scene(grid);
		window.setScene(scene);
		window.show();
	}

}
