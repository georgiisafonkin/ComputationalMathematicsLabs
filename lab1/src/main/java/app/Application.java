package app;

import calc.extremepoints.ExtremePointsFinder;
import calc.extremepoints.IExtremePointsFinder;
import calc.polynomials.IPolynomial;
import calc.polynomials.Polynomial;
import calc.root.multiplicity.IRootMultiplicityFinder;
import calc.root.multiplicity.RootMultiplicityFinder;
import calc.root.seekers.IRootSeeker;
import calc.root.seekers.RootSeeker;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static void printRootsWithMultiplicity(List<Double> roots, IRootMultiplicityFinder multiplicityFinder) {
        System.out.println("in printRootsWithMultiplicity");
        System.out.println("roots length " + roots.toArray().length);
        for (double r : roots) {
            System.out.println(r + " - " + multiplicityFinder.findRootMultiplicity(r));
        }
    }
    public static void main(String[] args) {
        double a, b, c, d, epsilon, delta;

        Scanner scanner = new Scanner(System.in);

        a = 1;
        b = scanner.nextDouble();
        c = scanner.nextDouble();
        d = scanner.nextDouble();
        epsilon = scanner.nextDouble();
        delta = scanner.nextDouble();

        System.out.println("here\n");

        IPolynomial polynomial = new Polynomial(3, Arrays.asList(a,b,c,d));
        IRootMultiplicityFinder multiplicityFinder = new RootMultiplicityFinder(polynomial, epsilon);
        IExtremePointsFinder extremePointsFinder = new ExtremePointsFinder();
        List<Double> extremePoints = extremePointsFinder.findExtremePoints(polynomial);
        IRootSeeker rootSeeker = new RootSeeker(polynomial, epsilon, delta);
        List<Double> roots = null;
        //TODO finish algorithm
        if (extremePoints == null) {
            roots = Arrays.asList(rootSeeker.findRootIfNoExtremum());
        }else if (extremePoints.toArray().length == 1) {
            roots = Arrays.asList(rootSeeker.findRootWithSingleExtremum(extremePoints));
        } else if (extremePoints.toArray().length == 2) {
            roots = rootSeeker.findRootsWithExtremums(extremePoints);
        }
        System.out.println("done!");
        printRootsWithMultiplicity(roots, multiplicityFinder);
    }
}
