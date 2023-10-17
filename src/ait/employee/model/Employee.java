package ait.employee.model;

public abstract class Employee {
    protected static double minWage =13;
    protected final int id;
    protected String firstName;
    protected String lastName;
    protected double hours;

    public static double getMinWage() {
        return minWage;
    }

    public static void setMinWage(double minWage) {
        if (minWage>Employee.minWage) {
            Employee.minWage = minWage;
        }
    }

    @Override
    public String toString() {
        return "Employe" +
                " id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hours=" + hours+ '\'' +
                " salary="+calcSalary();
    }
    public abstract double calcSalary();

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Employee employe = (Employee) object;

        return id == employe.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public Employee(int id, String firstName, String lastName, double hours) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hours = hours;
    }
}
