import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

	private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");
	private IntegerProperty age = new SimpleIntegerProperty(this, "age", -1);

	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public StringProperty getFirstNameProperty() {
		return this.firstName;
	}

	public int getAge() {
		return age.get();
	}

	public void setAge(int age) {
		this.age.set(age);
	}

	public IntegerProperty getAgeProperty() {
		return this.age;
	}
}
