package entities;


public class Employee {

    private final String firstName;
    private final String middleName;
    private final String lastName;

    public Employee(String fName, String mName, String lName) {
        this.firstName = fName;
        this.middleName = mName;
        this.lastName = lName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

}
