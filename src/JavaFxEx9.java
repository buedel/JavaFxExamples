
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFxEx9 extends Application {

	private Stage window;
	private TreeView<String> tree;

	public static void main(String[] args) {
		Application.launch(args);
	}

	ListView<String> listView;

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("JavaFX Examples");

		TreeItem<String> root;
		TreeItem<String> nodeOne;
		TreeItem<String> nodeTwo;

		root = new TreeItem<String>("Root");
		root.setExpanded(true);

		nodeOne = makeBranch("node one", root);
		nodeTwo = makeBranch("node two", root);

		makeBranch("one", nodeOne);
		makeBranch("two", nodeOne);
		makeBranch("three", nodeOne);

		makeBranch("A", nodeTwo);
		makeBranch("B", nodeTwo);
		makeBranch("C", nodeTwo);

		tree = new TreeView<String>(root);
		tree.setShowRoot(false);
		tree.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		tree.getSelectionModel().selectedItemProperty()
				.addListener((v, oldVal, newVal) -> System.out.println("old: " + oldVal + ", new: " + newVal));

		Button ok = new Button("OK");

		ok.setOnAction(e -> printItems());
		// Layout
		StackPane layout = new StackPane();

		layout.getChildren().addAll(tree, ok);

		Scene scene = new Scene(layout);

		window.setScene(scene);
		window.show();
	}

	private TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
		TreeItem<String> newItem = new TreeItem<String>(title);
		parent.getChildren().add(newItem);
		newItem.setExpanded(true);
		return newItem;
	}

	private void printItems() {
		ObservableList<TreeItem<String>> selectedItems = tree.getSelectionModel().getSelectedItems();

		for (TreeItem<String> item : selectedItems) {
			System.out.println(item.getValue());
		}
	}
}
