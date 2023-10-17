package ait.employee.test;

import ait.employee.dao.Company;
import ait.employee.dao.CompanyImpl;
import ait.employee.model.Employee;
import ait.employee.model.Maneger;
import ait.employee.model.SalesManager;
import ait.employee.model.WageEmployee;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
    Company company;
    Employee[] firmEmplyee;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        company = new CompanyImpl(5);
        firmEmplyee = new Employee[4];
        firmEmplyee[0] = new Maneger(1000, "John", "Smith", 160, 5000, 5);
        firmEmplyee[1] = new WageEmployee(2000, "Ann", "Smith", 160, 15);
        firmEmplyee[2] = new SalesManager(3000, "Peter", "Jackson", 160, 19000, 0.1);
        firmEmplyee[3] = new SalesManager(4000, "Rob", "Agraval", 80, 20000, 0.1);
        for (int i = 0; i < firmEmplyee.length; i++) {
            company.addEmployee(firmEmplyee[i]);
        }
    }

    @org.junit.jupiter.api.Test
    void addEmployee() {
        assertFalse(company.addEmployee(null));
        assertFalse(company.addEmployee(firmEmplyee[1]));
        Employee employee = new SalesManager(5000, "Peter", "Jackson", 160, 19000, 0.1);
        assertTrue(company.addEmployee(employee));
        assertEquals(5, company.quantity());
        employee = new SalesManager(6000, "Peter", "Jackson", 160, 19000, 0.1);
        assertFalse(company.addEmployee(employee));
    }

    @org.junit.jupiter.api.Test
    void removeEmployee() {
        Employee employee=company.removeEmployee(3000);
        assertEquals(firmEmplyee[2],employee);
        assertEquals(3, company.quantity());
        assertNull( company.removeEmployee(3000));

    }

    @org.junit.jupiter.api.Test
    void findEmployee() {
        assertEquals(firmEmplyee[1],company.findEmployee(2000));
        assertNull(company.findEmployee(5000));

    }

    @org.junit.jupiter.api.Test
    void totalSalary() {
        assertEquals(12280, company.totalSalary(),.01);
    }

    @org.junit.jupiter.api.Test
    void quantity() {
        assertEquals(4, company.quantity());
    }

    @org.junit.jupiter.api.Test
    void avgSalary() {
        assertEquals(12280.0 / 4, company.avgSalary(), 0.01);
    }

    @org.junit.jupiter.api.Test
    void totalSales() {
        assertEquals(39000, company.totalSales(),.01);
    }

    @org.junit.jupiter.api.Test
    void printEmployees() {
        company.printEmployees();
    }
}