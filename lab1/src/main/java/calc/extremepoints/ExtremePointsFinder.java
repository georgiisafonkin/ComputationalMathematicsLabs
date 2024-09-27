package calc.extremepoints;

import calc.derivatives.DerivativeCalc;
import calc.derivatives.IDerivativeCalc;
import calc.equation.solvers.IEquationSolver;
import calc.equation.solvers.QuadraticEquationSolver;
import calc.polynomials.IPolynomial;

import java.util.List;

public class ExtremePointsFinder implements IExtremePointsFinder {
    IEquationSolver equationSolver = new QuadraticEquationSolver();
    IDerivativeCalc derivativeCalc = new DerivativeCalc();
    @Override
    public List<Double> findExtremePoints(IPolynomial p) {
        return equationSolver.solveEquation(derivativeCalc.calcDerivatives(p));
    }
}
