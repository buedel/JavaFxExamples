
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFxEx1 extends Application {
	
	Button button;
	static Logger logger;
	
	public static void main(String[] args) {
		Application.launch(args);
		logger = Logger.getLogger("JavaFxEx1");
	}

	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Trump is a big fucktard");
		
		button = new Button("Fuck Trump");
//		button.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//				System.out.println(event.toString());
//				
//			}
//		});
		
		button.setOnAction(e->System.out.println(e.toString()));
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		
		Scene scene = new Scene(layout, 300, 250);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}

}
