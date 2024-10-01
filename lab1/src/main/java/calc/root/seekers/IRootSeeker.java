package calc.root.seekers;

import java.util.List;

public interface IRootSeeker {
    double seekRootOnTheLeft(double rightEdge);
    double seekRootOnTheRight(double leftEdge);
    double findRootIfNoExtremum();
    List<Double> findRootsWithExtremum(List<Double> extremums);
    double seekRootBetween(double leftEdge, double rightEdge);
}
