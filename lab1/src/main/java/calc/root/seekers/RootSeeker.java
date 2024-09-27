package calc.root.seekers;

public class RootSeeker implements IRootSeeker {
    private double epsilon;
    private double delta;
    public RootSeeker(double epsilon, double delta) {
        this.epsilon = epsilon;
        this.delta = delta;
    }
    @Override
    public float seekRootOnTheLeft() {
        return 0;
    }

    @Override
    public float seekRootOnTheRight() {
        return 0;
    }
}
