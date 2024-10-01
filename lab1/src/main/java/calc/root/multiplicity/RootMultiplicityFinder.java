package calc.root.multiplicity;

import calc.derivatives.DerivativeCalc;
import calc.derivatives.IDerivativeCalc;
import calc.polynomials.IPolynomial;

public class RootMultiplicityFinder implements IRootMultiplicityFinder{
    private IPolynomial p;
    private IDerivativeCalc derivativeCalc = new DerivativeCalc();
    public RootMultiplicityFinder(IPolynomial p) {
        this.p = p;
    }
    @Override
    public int findRootMultiplicity(double root) {
        int i = 0;
        IPolynomial d = p;
        while (d.calcValue(root) == 0) {
            d = derivativeCalc.calcDerivatives(d);
            ++i;
        }
        return i;
    }
}
