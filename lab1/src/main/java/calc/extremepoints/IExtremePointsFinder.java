package calc.extremepoints;

import calc.polynomials.IPolynomial;

import java.util.List;

public interface IExtremePointsFinder {
    List<Double> findExtremePoints(IPolynomial p);
}
