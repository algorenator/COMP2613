package examples.collections;

/**
 package examples.collections;

 @version 1.20 1998-04-07
 @author Cay Horstmann
 */

import java.util.Arrays;

public class EmployeeSortTest {
	public static void main(String[] args) {
		Employee[] staff = new Employee[3];

		staff[0] = new Employee("Harry Hacker", 35000);
		staff[1] = new Employee("Carl Cracker", 75000);
		staff[2] = new Employee("Tony Tester", 38000);

		Arrays.sort(staff);

		// print out information about all Employee objects
		for (int i = 0; i < staff.length; i++) {
			Employee e = staff[i];
			System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
		}
	}
}
