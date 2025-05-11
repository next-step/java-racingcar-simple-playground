public class CarRacing {

	public boolean isForward(int randomNum) {
		return randomNum >= 4 && randomNum <= 9;
	}

	public boolean isStop(int randomNum) {
		return randomNum >= 0 && randomNum <= 3;
	}

	public int forward(int distance) {
		return distance + 1;
	}

	public int stop(int distance) {
		return distance;
	}

	public int moveCar(int randomNum, int distance) {
		if (isForward(randomNum)) {
			return forward(distance);
		}

		if (isStop(randomNum)) {
			return stop(distance);
		}

		return distance;
	}

}
