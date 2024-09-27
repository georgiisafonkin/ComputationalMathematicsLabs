package calc.polynomials;

import java.util.List;

public class Polynomial implements IPolynomial{
    private int order;
    private List<Double> coefficients;
    public Polynomial(int order, List<Double> coefficients) {
        this.order = order;
        this.coefficients = coefficients;
    }
    @Override
    public int getPolynomialOrder() {
        return order;
    }

    @Override
    public List<Double> getCoefficients() {
        return coefficients;
    }

    @Override
    public double calcValue(float x) {
        float value = 0;
        int i = 0;
        int j = order;
        for (double c: coefficients) {
            value += coefficients.get(i++) * Math.pow(x, j--);
        }
        return value;
    }
}
