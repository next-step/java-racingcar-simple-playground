public class CarName {

  private final String name;

  private CarName(String name) {
    validate(name);
    this.name = name;
  }

  public static CarName of(String name) {
    return new CarName(name);
  }

  private static void validate(String name) {
    if (name == null || name.isBlank() || name.length() > 5) {
      throw new IllegalArgumentException("이름은 1글자에서 5글자 사이여야 합니다.");
    }
  }

  public String getName() {
    return name;
  }
}
