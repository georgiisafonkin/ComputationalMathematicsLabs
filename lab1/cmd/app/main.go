package main

import (
	"lab1/pkg/calculations"
	"fmt"
)

func main() {
	var a, b, c, epsilon, delta float64
	
	fmt.Printf("enter the values of a, b, c, epsilon, delta: ")
	
	fmt.Scanln(&a, &b, &c, &epsilon, &delta)	
	
	var calc calculations.Calculator = calculations.Calculator {
		A: a,
		B: b,
		C: c,
		Epsilon: epsilon,
		Delta: delta,
	}

	calc.FindRoots()
}