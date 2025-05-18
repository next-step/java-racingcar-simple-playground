package racinggame.model.car.policy.evaluator;

public class GreaterThanOrEqualThresholdEvaluator implements ThresholdEvaluator {
    private final int threshold;

    public GreaterThanOrEqualThresholdEvaluator(int threshold) {
        this.threshold = threshold;
    }
    @Override
    public boolean isSatisfied(int value){
        return value >= threshold;
    }
}
