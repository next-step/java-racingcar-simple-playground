public class Print {

    public static void print(Car[] cars) {
        for (Car car : cars) {
            String str = makingDis(car.getDistance());
            System.out.println(car.getName() + " : " + str);
        }
        System.out.println();
    }

    public static String makingDis(int dis) {
        String result = "";
        for (int i = 0; i < dis; i++) {
            result += "-";
        }
        return result;
    }
}
