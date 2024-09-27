package calc.discriminant;

import calc.polynomials.IPolynomial;

public class DiscriminantFinder implements IDiscriminantFinder{
    @Override
    public double findDiscriminant(IPolynomial p) {
        if (p.getPolynomialOrder() != 2) {
            throw new RuntimeException("Can't find discriminant for non-quadratic polynomial");
        }
        return Math.pow(p.getCoefficients().get(1), 2) - 4 * p.getCoefficients().get(0) * p.getCoefficients().get(2);
    }
}
