package executor

import (
	"lab1/pkg/calculations"
)

type Executor {
	A float64
	B float64
	C float64
	Epsilon float64
	Delta float64
	calc calculations.Calculator
}

func (e executor) findRoots() {
	coefficients := [4]float64{0, A, B, C}
	p2 := calc.getDerivative(coefficients)
	extemums := getExtremumPoints(coefficients)
	if extemums == nil {
		
	}
}

func (e Executor) findOnTheLeft(float64 possibleRoot) {

}

func (e Executor) findOnTheRight(float64 possibleRoot) {
		
}
