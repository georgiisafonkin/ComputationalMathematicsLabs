package calc.root.seekers;

import calc.polynomials.IPolynomial;

import java.util.ArrayList;
import java.util.List;

public class RootSeeker implements IRootSeeker {
    IPolynomial p;
    private double epsilon;
    private double delta;
    public RootSeeker(IPolynomial polynomial, double epsilon, double delta) {
        this.p = polynomial;
        this.epsilon = epsilon;
        this.delta = delta;
    }
    @Override
    public double seekRootOnTheLeft(double rightEdge) {
        double leftEdge = rightEdge - delta;
        while(!(p.calcValue(leftEdge) < 0 && p.calcValue(rightEdge) > 0)) {
            rightEdge = leftEdge;
            leftEdge -= delta;
        }
        return seekRootBetween(leftEdge, rightEdge);
    }

    @Override
    public double seekRootOnTheRight(double leftEdge) {
        double rightEdge = leftEdge + delta;
        while (!(p.calcValue(leftEdge) < -epsilon && p.calcValue(rightEdge) > epsilon)) {
            leftEdge = rightEdge;
            rightEdge += delta;
        }
        return seekRootBetween(leftEdge, rightEdge);
    }

    @Override
    public double findRootIfNoExtremum() {
        System.out.println("in findRootIfNoExtremum...");
        if (Math.abs(p.calcValue(0)) < epsilon) {
            return 0.0;
        }
        else if (p.calcValue(0) < -epsilon) {
            return seekRootOnTheRight(0.0);
        } else if (p.calcValue(0) > -epsilon) {
            return seekRootOnTheLeft(0.0);
        }
        throw new RuntimeException("findRootIfNoExtremum: no suitable conditional");
    }

    @Override
    public List<Double> findRootsWithExtremums(List<Double> extremums) {
        System.out.println("in findRootsWithExtremum...");
        double alpha = extremums.get(0);
        double beta = extremums.get(1);
        System.out.println("alpha: " + alpha);
        System.out.println("beta: " + beta);
        List<Double> rv = new ArrayList<>();
        if (p.calcValue(alpha) > epsilon && p.calcValue(beta) > epsilon) {
            System.out.println("left alpha");
            rv.add(seekRootOnTheLeft(alpha));
        } else if (p.calcValue(alpha) < -epsilon && p.calcValue(beta) < -epsilon) {
            System.out.println("right beta");
            rv.add(seekRootOnTheRight(beta));
        } else if (Math.abs(p.calcValue(alpha)) < epsilon && p.calcValue(beta) < -epsilon) {
            System.out.println("alpha + right beta");
            rv.add(seekRootOnTheRight(beta));
            rv.add(alpha);
        } else if (Math.abs(p.calcValue(beta)) < epsilon && p.calcValue(alpha) > epsilon) {
            System.out.println("beta + left alpha");
            rv.add(seekRootOnTheLeft(alpha));
            rv.add(beta);
        } else if (p.calcValue(alpha) > epsilon && p.calcValue(beta) < -epsilon) {
            System.out.println("three roots");
            rv.add(seekRootOnTheLeft(alpha));
            rv.add(seekRootOnTheRight(beta));
            rv.add(seekRootBetween(beta, alpha));
        } else if (Math.abs(p.calcValue(alpha)) < epsilon && Math.abs(p.calcValue(beta)) < epsilon) {
            rv.add((alpha + beta)/2);
        }
        return rv;
    }

    @Override
    public double findRootWithSingleExtremum(List<Double> extremums) {
        double extremum = extremums.get(0);
        if (!(Math.abs(p.calcValue(extremum)) < epsilon)) {
            if (p.calcValue(extremum) < -epsilon) {
                return seekRootOnTheRight(0.0);
            } else if (p.calcValue(extremum) > epsilon) {
                return seekRootOnTheLeft(0.0);
            }
        }
        return extremum;
    }

    @Override
    public double seekRootBetween(double leftEdge, double rightEdge) {
        System.out.println("leftEdge: " + leftEdge);
        System.out.println("rightEdge: " + rightEdge);
        System.out.println(p.calcValue(leftEdge) * p.calcValue(rightEdge) < 0);
        double c = (leftEdge + rightEdge) / 2;
        if (!(Math.abs(p.calcValue(c)) < epsilon)) {

            if (p.calcValue(c) > epsilon) {
                return seekRootBetween(leftEdge, c);
            } else if (p.calcValue(c) < -epsilon) {
                return seekRootBetween(c, rightEdge);
            }
        }
        System.out.println("---ROOT: " + c + "---");
        return c;
    }
}
