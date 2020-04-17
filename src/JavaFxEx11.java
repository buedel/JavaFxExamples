
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class JavaFxEx11 extends Application {

	Stage window;
	BorderPane layout;

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

		// Create Menues
		Menu fileMenu = new Menu("_File");
		MenuItem newMenuItem = new MenuItem("_New Project...");
		newMenuItem.setOnAction(e -> System.out.println("New Project"));
		fileMenu.getItems().add(newMenuItem);
		fileMenu.getItems().add(new MenuItem("Open"));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("_Save"));
		fileMenu.getItems().add(new MenuItem("E_xit"));

		Menu editMenu = new Menu("_Edit");
		editMenu.getItems().add(new MenuItem("Cut"));
		editMenu.getItems().add(new MenuItem("Copy"));
		MenuItem pasteMenuItem = new MenuItem("Paste");
		pasteMenuItem.setDisable(true);
		editMenu.getItems().add(pasteMenuItem);

		editMenu.getItems().add(new SeparatorMenuItem());
		CheckMenuItem enableCheckMenuItem = new CheckMenuItem("enable");
		editMenu.getItems().add(enableCheckMenuItem);
		enableCheckMenuItem.setOnAction(e -> System.out.println("Enabled = " + enableCheckMenuItem.isSelected()));

		Menu sizeMenu = new Menu("Size");
		ToggleGroup sizeToggle = new ToggleGroup();

		RadioMenuItem smallRmi = new RadioMenuItem("Small");
		RadioMenuItem mediumRmi = new RadioMenuItem("Medium");
		RadioMenuItem largeRmi = new RadioMenuItem("Large");

		smallRmi.setSelected(true);

		smallRmi.setToggleGroup(sizeToggle);
		mediumRmi.setToggleGroup(sizeToggle);
		largeRmi.setToggleGroup(sizeToggle);

		sizeMenu.getItems().addAll(smallRmi, mediumRmi, largeRmi);

		Menu helpMenu = new Menu("Help");
		Menu infoMenu = new Menu("info");
		helpMenu.getItems().add(infoMenu);
		infoMenu.getItems().add(new MenuItem("About"));
		infoMenu.getItems().add(new MenuItem("Time"));

		// Main menu bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, editMenu, sizeMenu, helpMenu);

		layout = new BorderPane();
		layout.setTop(menuBar);

		Scene scene = new Scene(layout);

		window.setScene(scene);
		window.show();
	}
}
