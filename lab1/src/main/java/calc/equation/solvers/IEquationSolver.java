package calc.equation.solvers;

import calc.polynomials.IPolynomial;

import java.util.List;

public interface IEquationSolver {
    List<Double> solveEquation(IPolynomial p);
}
