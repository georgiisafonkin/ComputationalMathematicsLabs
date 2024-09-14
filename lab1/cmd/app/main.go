package main

import (
	"fmt"
)

func main() {
	var a, b, c, epsilon, delta float32
	
	fmt.Printf("enter the values of a, b, c, epsilon, delta: ")
	
	fmt.Scanln(&a, &b, &c, &epsilon, &delta)	
	
	fmt.Println()
	fmt.Printf("Your input: %f, %f, %f, %f, %f\n", a, b, c, epsilon, delta)
}