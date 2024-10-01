package calc.polynomials;

import java.util.List;

public interface IPolynomial {
    int getPolynomialOrder();
    List<Double> getCoefficients();
    double calcValue(double x);
}
