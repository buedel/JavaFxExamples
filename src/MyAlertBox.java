import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MyAlertBox {

	public static void display(String title, String msg) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		
		Label label = new Label(msg);
		
		Button closeButton = new Button("Close");
		
		closeButton.setOnAction(e-> window.close());
		
		VBox layout = new VBox(10);
		
		layout.getChildren().addAll(label, closeButton);
		
		Scene scene = new Scene(layout);
		
		window.setScene(scene);
		
		window.showAndWait();
	}
}
