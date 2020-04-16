
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxEx10 extends Application {

	Stage window;
	TableView<Product> table;

	TextField nameInput;
	TextField priceInput;
	TextField quantityInput;

	static int MIN = 100;

	public static void main(String[] args) {
		Application.launch(args);
	}

	ListView<String> listView;

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("JavaFX Examples");

		// Name column
		TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(MIN);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

		// Price column
		TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
		priceColumn.setMinWidth(MIN);
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

		// Quantity column
		TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.setMinWidth(MIN);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

		// Name input
		nameInput = new TextField();
		nameInput.setPromptText("Name");
		nameInput.setMinWidth(MIN);

		// Price input
		priceInput = new TextField();
		priceInput.setPromptText("Price");
		priceInput.setMinWidth(MIN);

		// Quantity input
		quantityInput = new TextField();
		quantityInput.setPromptText("Quantity");
		quantityInput.setMinWidth(MIN);

		// Button
		Button addButton = new Button("Add");
		Button deleteButton = new Button("Delete");

		addButton.setOnAction(e -> addButtonClicked());
		deleteButton.setOnAction(e -> deleteButtonClicked());

		// add area
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10, 10, 10, 10));
		hbox.setSpacing(10);
		hbox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);

		table = new TableView<Product>();
		table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		table.setItems(getProducts());
		table.getColumns().add(nameColumn);
		table.getColumns().add(priceColumn);
		table.getColumns().add(quantityColumn);

		VBox layout = new VBox();

		layout.getChildren().addAll(table, hbox);

		Scene scene = new Scene(layout);

		window.setScene(scene);
		window.show();
	}

	public ObservableList<Product> getProducts() {
		ObservableList<Product> products = FXCollections.observableArrayList();

		products.add(new Product("Laptop", 3345.99, 1));
		products.add(new Product("Book", 5.49, 3));
		products.add(new Product("Bell", 18.34, 1));
		products.add(new Product("Red Baloons", 99, 99));
		return products;
	}

	public void addButtonClicked() {
		Product product = new Product();
		product.setName(nameInput.getText());
		product.setPrice(Double.parseDouble(priceInput.getText()));
		product.setQuantity(Integer.parseInt(quantityInput.getText()));
		table.getItems().add(product);
		nameInput.clear();
		priceInput.clear();
		quantityInput.clear();
	}

	public void deleteButtonClicked() {
		ObservableList<Product> productsSelected;
		ObservableList<Product> allProducts;

		allProducts = table.getItems();
		productsSelected = table.getSelectionModel().getSelectedItems();

		productsSelected.forEach(allProducts::remove);

	}
}
