package examples.packages.data;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class Employee {
	private int id;
	private String name;
	private long salary;
	private Date hireDay;

	private static int nextId;

	// static initialization block
	// this is an example of how to use static initializers, typically the ID would be set outside the Employee class
	static {
		Random generator = new Random();
		// set nextId to a random number between 0 and 9999
		nextId = generator.nextInt(10000);
	}

	// object initialization block
	{
		id = nextId;
		nextId++;
	}

	public Employee(String name, long salary, int year, int month, int day) {
		this.name = name;
		this.salary = salary;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		// GregorianCalendar uses 0 for January
		hireDay = calendar.getTime();
	}

	public Employee(String name, long salary) {
		this.name = name;
		this.salary = salary;
		// GregorianCalendar uses 0 for January
		hireDay = new GregorianCalendar().getTime();
	}

	public Employee(long salary) {
		this.salary = salary;
		// GregorianCalendar uses 0 for January
		hireDay = new GregorianCalendar().getTime();
	}

	public Employee() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Date getHireDay() {
		return hireDay;
	}

	public void setHireDay(Date hireDay) {
		this.hireDay = hireDay;
	}

	public static Integer getNextId() {
		return nextId;
	}

	public static void setNextId(Integer nextId) {
		Employee.nextId = nextId;
	}

	public Integer getId() {
		return id;
	}

	public void raiseSalary(Double byPercent) {
		Double raise = salary * byPercent / 100;
		salary += raise;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", hireDay=" + hireDay + "]";
	}

}
