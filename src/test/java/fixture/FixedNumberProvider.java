package fixture;

import util.NumberProvider;

public class FixedNumberProvider {

    public static class Number3Provider implements NumberProvider {

        public int provide() {
            return 3;
        }
    }

    public static class Number4Provider implements NumberProvider {

        public int provide() {
            return 4;
        }
    }
}
