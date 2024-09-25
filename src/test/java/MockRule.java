import domain.Rule;

public class MockRule{

    public static class MoreThan4NumberGenerator implements Rule {
        @Override
        public boolean canGo() {
            return true;
        }
    }

    public static class LessThan4NumberGenrator implements Rule {

        @Override
        public boolean canGo() {
            return false;
        }
    }
}
