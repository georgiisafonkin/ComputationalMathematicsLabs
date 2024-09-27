package app;

import calc.extremepoints.ExtremePointsFinder;
import calc.extremepoints.IExtremePointsFinder;
import calc.polynomials.IPolynomial;
import calc.polynomials.Polynomial;

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
        IExtremePointsFinder extremePointsFinder = new ExtremePointsFinder();
        List<Double> extremePoints = extremePointsFinder.findExtremePoints(polynomial);

        //TODO finish algorithm
//        if (extremePoints == null) {
//            if (Math.abs(polynomial.calcValue(0)) < epsilon) {
//
//            }
//        } else if () {
//
//        } else {
//
//        }
    }
}
