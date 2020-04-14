
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxEx8 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage window) throws Exception {

		window.setTitle("Checkbox example");

		ChoiceBox<String> choiceBox = new ChoiceBox<String>();
		ComboBox<String> comboBox = new ComboBox<String>();

		choiceBox.getItems().addAll("One", "Two", "Three");
		comboBox.getItems().addAll("Alpha", "Beta", "Gamma");

		choiceBox.getSelectionModel().clearAndSelect(0); // select 1st item
		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

			System.out.println(observable.toString());
			System.out.println("   From: " + oldValue);
			System.out.println("     To: " + newValue);
		});

		comboBox.setPromptText("What???");
		comboBox.setOnAction(e -> System.out.println("onAction: " + comboBox.getValue()));
		comboBox.setEditable(true);

		Button orderButton = new Button("Order Now");
		orderButton.setOnAction(e -> {
			if (!comboBox.getItems().contains(comboBox.getValue())) {
				comboBox.getItems().add(comboBox.getValue());
			}
		});

		VBox layout = new VBox(15);

		layout.getChildren().addAll(choiceBox, comboBox, orderButton);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.show();
	}

}
