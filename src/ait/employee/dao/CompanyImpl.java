package ait.employee.dao;

import ait.employee.EmployeAppl;
import ait.employee.model.Employee;
import ait.employee.model.SalesManager;

public class CompanyImpl implements Company {
    private Employee[] employees;
    private int sizeActual;

    public CompanyImpl(int capacity) {
        employees = new Employee[capacity];

    }


    @Override
    public boolean addEmployee(Employee employee) {
        if (employee == null || sizeActual == employees.length || findEmployee(employee.getId()) != null) {
            return false;
        }
        employees[sizeActual] = employee;
        sizeActual++;
        return true;
    }

    @Override
    public Employee removeEmployee(int id) {
        Employee employeeRemove = null;
        for (int i = 0; i < sizeActual; i++) {

            if (employees[i].getId() == id) {
                employeeRemove = employees[i];
                employees[i] = employees[sizeActual - 1];
                employees[sizeActual - 1] = null;
                sizeActual--;
            }
        }
        return employeeRemove;

    }

    @Override
    public Employee findEmployee(int id) {
        for (int i = 0; i < sizeActual; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        return null;
    }

    @Override
    public double totalSalary() {
        double res = 0;
        for (int i = 0; i < sizeActual; i++) {
            res += employees[i].calcSalary();
        }
        return res;
    }

    @Override
    public int quantity() {
        return sizeActual;
    }

    @Override
    public double avgSalary() {
        double res = totalSalary() / sizeActual;
        return res;
    }

    @Override
    public double totalSales() {
        double sum = 0;
        for (int i = 0; i < sizeActual; i++) {
            if (employees[i] instanceof SalesManager) {
                SalesManager sm = (SalesManager) employees[i];
                sum += sm.getSalesValue();
                //sum+= ((SalesManager) employees[i]).getSalesValue();
            }
        }
        return sum;
    }

    @Override
    public void printEmployees() {
        for (int i = 0; i < sizeActual; i++) {
            System.out.println(employees[i]);
        }

    }
}
