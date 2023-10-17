package ait.employee;

import ait.employee.model.Employee;
import ait.employee.model.Maneger;
import ait.employee.model.SalesManager;
import ait.employee.model.WageEmployee;

public class EmployeAppl {
    public static void main(String[] args) {
        Employee[] firm = new Employee[5];
        firm[0] = new Maneger(1000, "John", "Smith", 160, 5000, 5);
        firm[1] = new WageEmployee(2000, "Ann", "Smith", 160, 15);
        firm[2] = new SalesManager(3000, "Peter", "Jackson", 160, 19000, 0.1);
        firm[3] = new SalesManager(4000, "Rob", "Agraval", 80, 20000, 0.1);
        //firm[4] = new Employee(5000, "John", "Idiot", 160);
        printArray(firm);
        double total = totalSalary(firm);
        System.out.println("Total salary = " + total);
        total = totalSales(firm);
        System.out.println("Total sales = " + total);

    }

    public static double totalSales(Employee[] employees) {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] instanceof SalesManager) {
                SalesManager sm = (SalesManager) employees[i];
                sum = sm.getSalesValue();
                //sum+= ((SalesManager) employees[i]).getSalesValue();
            }
        }
        return sum;
    }

    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.println(arr[i]);
            }
        }
    }

    public static double totalSalary(Employee[] employees) {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sum += employees[i].calcSalary();
            }

        }
        return sum;
    }
}
