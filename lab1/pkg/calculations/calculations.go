package calculations

import (
	"math"
)

type Calculator struct {
	a float32
	b float32
	c float32
	epsilon float32
	delta float32
}

func (calc Calculator) p(x float32) float32 {
	return math.Pow(x, 3) + calc.a * math.Pow(x, 2) + calc.b * x + calc.c
}

func (calc Calculator) getExtremumPoints() []float32 {
	switch d := getDiscriminant(calc.a, calc.b) {
	case d < 0:
		return nil
	case d == 0:
	case d > 0:
	}
}

func getDiscriminant(a, b float32) float32 {
	var new_a, new_b, new_c float32
	var discriminant float32

	new_a = 3
	new_b = 2 * a
	new_c = b
	
	discriminant = math.Pow(new_b, 2) - 4 * new_a * new_c
	
	return discriminant
}
