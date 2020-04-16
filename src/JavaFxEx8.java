
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxEx8 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	ListView<String> listView;

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
			listView.getItems().add(comboBox.getValue());
		});

		listView = new ListView<String>();
		listView.getItems().addAll("Item One", "Item Two", "Item Three");

		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		VBox layout = new VBox(15);

		Button printItems = new Button("print Items");

		printItems.setOnAction(e -> printItems());

		layout.getChildren().addAll(choiceBox, comboBox, listView, orderButton, printItems);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.show();
	}

	private void printItems() {
		ObservableList<String> movies;

		movies = listView.getSelectionModel().getSelectedItems();

		System.out.println("Selected Items:");
		for (String msg : movies) {
			System.out.println("   " + msg);
		}
	}
}
