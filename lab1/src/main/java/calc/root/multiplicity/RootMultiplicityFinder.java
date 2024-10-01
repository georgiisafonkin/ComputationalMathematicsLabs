package calc.root.multiplicity;

import calc.polynomials.IPolynomial;

public class RootMultiplicityFinder implements IRootMultiplicityFinder{
    private IPolynomial p;
    public RootMultiplicityFinder(IPolynomial p) {
        this.p = p;
    }
    @Override
    public int findRootMultiplicity(double root) {
        return 0;
    }
}
