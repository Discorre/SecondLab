package main // Объявление пакета main

import "fmt" // Импорт пакета fmt для форматированного ввода-вывода

// Функция для вычисления суммы цифр числа
func sumOfDigits(num int) int {
	sum := 0 // Инициализация переменной для хранения суммы цифр числа
	if num < 0 { // Проверка, является ли число отрицательным
		num = -num // Если число отрицательное, меняем знак на положительный
	}
	for num != 0 { // Пока число не равно 0
		sum += num % 10 // Добавляем к сумме последнюю цифру числа
		num /= 10 // Удаляем последнюю цифру числа
	}
	return sum // Возвращаем сумму цифр числа
}

func main() { // Основная функция программы

	var n int // Объявляем переменную для хранения количества чисел
	fmt.Print("Enter the number of numbers: ") // Выводим приглашение для ввода количества чисел
	fmt.Scan(&n) // Считываем количество чисел

	fmt.Print("Enter numbers: ") // Выводим приглашение для ввода чисел
	var num, count int // Объявляем переменные для хранения числа и подсчета чисел, удовлетворяющих условию
	fmt.Print("Numbers whose sum of digits consists of one decimal place: ") // Выводим заголовок для вывода чисел
	for i := 0; i < n; i++ { // Итерируемся от 0 до n-1
		fmt.Scan(&num) // Считываем число
		if sumOfDigits(num) < 10 && num > -10 { // Проверяем условие на сумму цифр и размер числа
			fmt.Printf("%d ", num) // Выводим число
			count++ // Увеличиваем счетчик чисел, удовлетворяющих условию
		}
	}
	if count == 0 { // Если не было найдено чисел, удовлетворяющих условию
		fmt.Println("No such numbers found.") // Выводим сообщение об отсутствии таких чисел
	} else { // В противном случае
		fmt.Println() // Переходим на новую строку
	}
}
