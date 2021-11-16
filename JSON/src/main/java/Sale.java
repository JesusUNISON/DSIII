public class Sale {
    int id;
    String firstName;
    String lastName;

    double sales;
    String state;

    String department;

    public Sale(int id, String firstName, String lastName, double sales, String state, String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sales = sales;
        this.state = state;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sales=" + sales +
                ", state='" + state + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
