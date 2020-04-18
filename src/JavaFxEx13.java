
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFxEx13 extends Application {

	Stage window;
	int count = 0;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;

		Person doug = new Person();

		doug.getFirstNameProperty()
				.addListener((v, oldValue, newValue) -> System.out.println("Changing " + oldValue + " to " + newValue));

		IntegerProperty x = new SimpleIntegerProperty(3);
		IntegerProperty y = new SimpleIntegerProperty();

		y.bind(x.multiply(10));

		Button button = new Button("Submit");

		button.setOnAction(e -> {
			doug.setFirstName("Porky" + x.getValue() + " - " + y.getValue());
			x.set(x.get() + 1);
		});

		StackPane layout = new StackPane();
		layout.getChildren().addAll(button);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.show();
	}

}
