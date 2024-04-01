package main

import (
	"fmt"
)

func isValidMove(x, y, n, m int, move byte) bool {
	switch move {
	case 'L':
		return y > 1
	case 'R':
		return y < m
	case 'U':
		return x > 1
	case 'D':
		return x < n
	default:
		return false
	}
}

func findStartPosition(n, m int, s string) (int, int) {
	for i := 1; i <= n; i++ {
		for j := 1; j <= m; j++ {
			x, y := i, j
			valid := true
			for _, move := range s {
				if !isValidMove(x, y, n, m, byte(move)) {
					valid = false
					break
				}
				switch move {
				case 'L':
					y--
				case 'R':
					y++
				case 'U':
					x++
				case 'D':
					x--
				}
			}
			if valid {
				return i, j
			}
		}
	}
	return -1, -1
}

func main() {
	var n, m int
	var s string

	fmt.Print("Введите размеры доски (N M): ")
	fmt.Scan(&n, &m)

	fmt.Print("Введите строку команд: ")
	fmt.Scan(&s)

	startPos1, startPos2 := findStartPosition(n, m, s)

	if startPos1 == -1 && startPos2 == -1 {
		fmt.Println("Невозможно выполнить все команды, не выходя за пределы доски.")
	} else {
		fmt.Printf("Результат: (%d, %d)\n", startPos1, startPos2)
	}
}
