package calc.derivatives;

import calc.polynomials.IPolynomial;
import calc.polynomials.Polynomial;

import java.util.ArrayList;
import java.util.List;

public class DerivativeCalc implements IDerivativeCalc{
    @Override
    public IPolynomial calcDerivatives(IPolynomial p) {
        int pOrder = p.getPolynomialOrder();
        List<Double> pCoefficients = p.getCoefficients();

        List<Double> derivativeC = new ArrayList<>(pOrder);
        int i = pOrder;
        for (int j = 0; j < pOrder; ++j) {
            derivativeC.add(pCoefficients.get(j) * i--);
        }

        IPolynomial derivativeP = new Polynomial(pOrder - 1, derivativeC);
        return derivativeP;
    }
}
