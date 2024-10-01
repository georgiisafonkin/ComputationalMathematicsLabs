package app;

import calc.extremepoints.ExtremePointsFinder;
import calc.extremepoints.IExtremePointsFinder;
import calc.polynomials.IPolynomial;
import calc.polynomials.Polynomial;
import calc.root.multiplicity.IRootMultiplicityFinder;
import calc.root.multiplicity.RootMultiplicityFinder;
import calc.root.seekers.IRootSeeker;
import calc.root.seekers.RootSeeker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        double a, b, c, d, epsilon, delta;

        Scanner scanner = new Scanner(System.in);

        a = 1;
        b = scanner.nextDouble();
        c = scanner.nextDouble();
        d = scanner.nextDouble();
        epsilon = scanner.nextDouble();
        delta = scanner.nextDouble();

        IPolynomial polynomial = new Polynomial(3, Arrays.asList(a,b,c,d));
        IRootMultiplicityFinder multiplicityFinder = new RootMultiplicityFinder(polynomial);
        IExtremePointsFinder extremePointsFinder = new ExtremePointsFinder();
        List<Double> extremePoints = extremePointsFinder.findExtremePoints(polynomial);
        IRootSeeker rootSeeker = new RootSeeker(polynomial, epsilon, delta);

        //TODO finish algorithm
        if (extremePoints == null) {
            if (Math.abs(polynomial.calcValue(0)) < epsilon) {
                System.out.println("Roots:\n0 - " + multiplicityFinder.findRootMultiplicity(0));
            }
            else if (polynomial.calcValue(0) < -epsilon) {
                double root = rootSeeker.seekRootOnTheRight();
                System.out.println("Roots:\n" + root + " - " + multiplicityFinder.findRootMultiplicity(root));
            } else if (polynomial.calcValue(0) > -epsilon) {
                double root = rootSeeker.seekRootOnTheLeft();
                System.out.println("Roots:\n" + root + " - " + multiplicityFinder.findRootMultiplicity(root));
            }
        } else {

        }
    }
}
