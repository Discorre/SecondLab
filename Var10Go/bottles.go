package main

import (
	"fmt"
)

func main() {
	var bottles, rate int
	fmt.Print("Введите количество банок с водой: ")
	fmt.Scanln(&bottles) // Считываем количество банок с водой
	fmt.Print("Введите курс обмена пустых банок на новые: ")
	fmt.Scanln(&rate) // Считываем курс обмена пустых банок на новые

	bottlesDrank := drinkWater(bottles, rate) // Вызываем функцию для определения максимального числа банок, которое можно выпить
	fmt.Println("Максимальное число банок, которое можно выпить:", bottlesDrank) // Выводим результат
}

func drinkWater(bottles, rate int) int {
	bottlesDrank := bottles // Инициализируем переменную для подсчета количества выпитых банок
	emptyBottles := bottles // Инициализируем переменную для отслеживания количества пустых банок
	steps := 1 // Инициализируем счетчик шагов

	fmt.Println("Дано: ") // Выводим заголовок для начала алгоритма
	printHappyFaces(bottles) // Выводим смайлики для текущего количества банок с водой
	fmt.Println("Шаг:", steps) // Выводим текущий шаг
	printEmptyBottles(emptyBottles) // Выводим пустые банки

	for emptyBottles >= rate { // Пока есть достаточно пустых банок для обмена
		exchangedBottles := emptyBottles / rate // Вычисляем количество обменяемых банок
		bottlesDrank += exchangedBottles // Увеличиваем общее количество выпитых банок
		remainingEmptyBottles := emptyBottles % rate // Вычисляем количество оставшихся пустых банок после обмена
		emptyBottles = exchangedBottles + remainingEmptyBottles // Обновляем количество пустых банок
		steps++ // Увеличиваем счетчик шагов

		fmt.Println("Шаг:", steps) // Выводим номер текущего шага
		printHappyFaces(exchangedBottles) // Выводим смайлики для обменяемых банок
		printEmptyBottles(remainingEmptyBottles) // Выводим пустые банки после обмена

		steps++ // Увеличиваем счетчик шагов
		fmt.Println("Шаг:", steps) // Выводим номер текущего шага
		printEmptyBottles(emptyBottles) // Выводим пустые банки после обмена
	}

	fmt.Println("Количество итераций:", steps) // Выводим общее количество итераций
	return bottlesDrank // Возвращаем общее количество выпитых банок
}

func printHappyFaces(n int) {
	for i := 1; i <= n; i++ { // Итерируемся от 1 до количества банок с водой
		fmt.Print("☺") // Выводим смайлик для каждой банки
		if i%3 == 0 { // Если текущий номер кратен 3
			fmt.Println() // Выводим пустую строку
		}
		if i == n && i%3 != 0 { // Если последняя итерация и количество не кратно 3
			fmt.Println() // Выводим пустую строку
		}
	}
}

func printEmptyBottles(n int) {
	for i := 1; i <= n; i++ { // Итерируемся от 1 до количества пустых банок
		fmt.Print("©") // Выводим пустую банку для каждой пустой банки
		if i%3 == 0 { // Если текущий номер кратен 3
			fmt.Println() // Выводим пустую строку
		}
		if i == n && i%3 != 0 { // Если последняя итерация и количество не кратно 3
			fmt.Println() // Выводим пустую строку
		}
	}
}
