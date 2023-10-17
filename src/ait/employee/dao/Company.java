package ait.employee.dao;

import ait.employee.model.Employee;

public interface Company {
     boolean addEmployee (Employee employee);
     Employee removeEmployee(int id);
     Employee findEmployee(int id);
     double totalSalary();
     int quantity();
     double avgSalary();
     double totalSales();
     void printEmployees();



}
