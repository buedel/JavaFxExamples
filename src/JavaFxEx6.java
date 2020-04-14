
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxEx6 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage window) throws Exception {

		window.setTitle("Checkbox example");

		CheckBox cb1 = new CheckBox("Checkbox One");
		CheckBox cb2 = new CheckBox("Checkbox Two");
		CheckBox cb3 = new CheckBox("Checkbox Three");
		Button orderButton = new Button("Order Now");
		
		cb2.setSelected(true);
		
		VBox layout = new VBox();
		
		layout.getChildren().addAll(cb1, cb2, cb3, orderButton);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.show();
	}

}
