package examples;

public class TestCircle {

	public static void main(String[] args) {
		System.out.println("TestCircle start");
		Circle circle = new Circle(5);
		circle.setRadius(7);
		System.out.format("A circle with a radius of %.2f meters has a circumference of %.2f meters and area of %.2f square meters",
		        circle.getRadius(), circle.getPerimeter(), circle.getArea());
	}
}
