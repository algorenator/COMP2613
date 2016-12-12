package examples.packages;

import java.util.Arrays;

import examples.packages.data.Employee;

/**
 * This program tests the Employee class.
 * 
 */
public class EmployeeTest {
	public static void main(String[] args) {
		// fill the staff array with three Employee objects
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Carl Cracker", 75000L, 1987, 12, 15);
		staff[1] = new Employee("Harry Hacker", 50000L, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000L, 1990, 3, 15);

		// give everyone a 5% raise
		for (Employee employee : staff) {
			employee.raiseSalary(5.0);
		}

		// quick way to print out the staff
		System.out.println(Arrays.toString(staff));
		
		// print out information about all Employee objects
		for (Employee employee : staff) {
			System.out.println(employee);
		}
		
	}
}
