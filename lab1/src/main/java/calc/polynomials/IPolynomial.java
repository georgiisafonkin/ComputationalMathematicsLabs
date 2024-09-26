package calc;

import java.util.List;

public interface IPolynomial {
    int getPolynomialOrder();
    List<Float> getCoefficients();
    float calcValue(float x);
}
