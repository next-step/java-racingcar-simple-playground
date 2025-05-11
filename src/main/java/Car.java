public class Car {

	String name;
	int distance;

	public Car(String name) {
		this.name = name;
		this.distance = 0;
	}

	public String getName() {
		return name;
	}

	public int getDistance() {
		return distance;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
}
