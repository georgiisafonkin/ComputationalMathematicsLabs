package calc.root.seekers;

import calc.polynomials.IPolynomial;

public class RootSeeker implements IRootSeeker {
    IPolynomial polynomial;
    private double epsilon;
    private double delta;
    public RootSeeker(IPolynomial polynomial, double epsilon, double delta) {
        this.polynomial = polynomial;
        this.epsilon = epsilon;
        this.delta = delta;
    }
    @Override
    public double seekRootOnTheLeft() {
        double possibleRoot = Double.MIN_VALUE;
        while (true) {
            if (!(Math.abs(polynomial.calcValue(possibleRoot)) < epsilon)) {
                possibleRoot += delta;
                continue;
            }
            break;
        }
        return possibleRoot;
    }

    @Override
    public double seekRootOnTheRight() {
        double possibleRoot = Double.MAX_VALUE;
        while (true) {
            if (!(Math.abs(polynomial.calcValue(possibleRoot)) < epsilon)) {
                possibleRoot -= delta;
                continue;
            }
            break;
        }
        return possibleRoot;
    }
}
