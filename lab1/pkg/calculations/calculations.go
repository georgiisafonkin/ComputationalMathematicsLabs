package calculations

import (
	"fmt"
	"math"
)

type Calculator struct {
	A float64
	B float64
	C float64
	Epsilon float64
	Delta float64
}

func (calc Calculator) FindRoots() {
	fmt.Println(calc.A, calc.B, calc.C, calc.Epsilon, calc.Delta)
}

func (calc Calculator) p(x float64) float64 {
	return math.Pow(x, 3) + calc.A * math.Pow(x, 2) + calc.B * x + calc.C
}

func (calc Calculator) getExtremumPoints() []float64 {
	switch d := getDiscriminant(calc.A, calc.B, calc.C); {
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

func getDerivative(order int32, coefficients []float64) []float64 {
	
	return nil
}