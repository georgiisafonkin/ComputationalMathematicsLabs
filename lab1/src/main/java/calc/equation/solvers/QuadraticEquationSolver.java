package calc.equation.solvers;

import calc.discriminant.DiscriminantFinder;
import calc.discriminant.IDiscriminantFinder;
import calc.polynomials.IPolynomial;

import java.util.ArrayList;
import java.util.List;

public class QuadraticEquationSolver implements IEquationSolver{
    IDiscriminantFinder discriminantFinder = new DiscriminantFinder();
    @Override
    public List<Double> solveEquation(IPolynomial p) {
        double discriminant = discriminantFinder.findDiscriminant(p);
        System.out.println("solving quadratic equation...");
        List<Double> roots;
        if (discriminant > 0) {
            roots = new ArrayList<>(2);
            roots.add((-p.getCoefficients().get(1) - Math.sqrt(discriminant))/(2 * p.getCoefficients().get(0)));
            roots.add((-p.getCoefficients().get(1) + Math.sqrt(discriminant))/(2 * p.getCoefficients().get(0)));
        } else if (discriminant == 0) {
            roots = new ArrayList<>(1);
            roots.add((-p.getCoefficients().get(1))/(2 * p.getCoefficients().get(0)));
        } else { //discriminant < 0
            roots = null;
        }
        return roots;
    }
}
