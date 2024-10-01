package calc.root.multiplicity;

import calc.derivatives.DerivativeCalc;
import calc.derivatives.IDerivativeCalc;
import calc.polynomials.IPolynomial;

public class RootMultiplicityFinder implements IRootMultiplicityFinder{
    private IPolynomial p;
    private double epsilon;
    private IDerivativeCalc derivativeCalc = new DerivativeCalc();
    public RootMultiplicityFinder(IPolynomial p, double epsilon) {
        this.p = p;
        this.epsilon = epsilon;
    }
    @Override
    public int findRootMultiplicity(double root) {
        int i = 0;
        IPolynomial d = p;
        while (Math.abs(d.calcValue(root)) < epsilon) {
            d = derivativeCalc.calcDerivatives(d);
            ++i;
        }
        return i;
    }
}
