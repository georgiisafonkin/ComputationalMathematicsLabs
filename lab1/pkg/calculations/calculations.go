package calculations

import (
	"fmt"
	"math"
)

type Calculator struct {
}

func (calc Calculator) FindRoots() {
	coefficients

	// fmt.Println(calc.A, calc.B, calc.C, calc.Epsilon, calc.Delta)
}

func (calc Calculator) p(x float64, order int32, coefficients []float64) float64 {
	switch order {
	case 3:
		return coefficients[0] * math.Pow(x, 3) + coefficients[1] * math.Pow(x, 2) + coefficients[2] * x + coefficients[3]
	case 2:
		return  coefficients[0] * math.Pow(x, 2) + coefficients[1] * x + coefficients[2]
	case 1:
		return coefficients[0] * x + coefficients[1]
	default:
		return nil
	}
}

func (calc Calculator) getExtremumPoints(a, b, c float64) []float64 {
	switch d := getDiscriminant(a, b, c); {
	case d < 0.0:
		return nil
	case d == 0.0:
	case d > 0.0:
	}
	return nil
}

func getDiscriminant(a, b, c float64) float64 {
	var discriminant float64

	discriminant = math.Pow(b, 2) - 4 * a * c
	
	return discriminant
}

//if order == 3, coefficients len is 4
//if order == 2, coefficients len is 3
//etc.
func getDerivative(order int32, coefficients []float64) []float64 {
	switch order {
	case 3:
		rv := [3]float64 //0 - a, 1 - b, 2 - c
		rv[0] = 3 * coefficients[0]
		rv[1] = 2 * coefficients[1]
		rv[2] = coefficients[2]
		return rv
	case 2:
		rv := [2]float64
		rv[0] = 2 * coefficients[0]
		rv[1] = coefficients[1]
		return rv
	case 1:
		rv := [1]float64
		rv[0] = coefficients[0]
		return rv
	}
	return nil
}

func moveRight() {

}

func moveLeft() {

}