public class NeverMovable implements CarMovement {
    @Override
    public boolean isMovable() {
        return false;
    }
}
