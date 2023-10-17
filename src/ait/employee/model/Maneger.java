package ait.employee.model;

public class Maneger extends Employee {
    private double baseSalary;
    private int grade;

    public Maneger(int id, String firstName, String lastName, double hours, double baseSalary, int grade) {
        super(id, firstName, lastName, hours);
        this.baseSalary = baseSalary;
        this.grade = grade;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public int getGrade() {
        return grade;
    }
    public double calcSalary(){
        double salary=baseSalary+grade*hours;
        if (salary<hours*minWage){
            salary=minWage*hours;
        }
        return salary;
    }


}
