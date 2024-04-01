import java.util.Scanner // Импорт класса Scanner из пакета java.util для считывания ввода пользователя

object SumOfDigits { // Объявление объекта SumOfDigits
    // Функция для вычисления суммы цифр числа
    fun sumOfDigits(num: Int): Int {
        var number = num // Инициализация переменной number значением num
        var sum = 0 // Инициализация переменной sum нулем
        // Если число отрицательное, меняем знак
        if (number < 0) number *= -1 // Если number меньше нуля, меняем его знак на противоположный
        while (number != 0) { // Пока number не равен нулю
            sum += number % 10 // Увеличиваем сумму на остаток от деления number на 10
            number /= 10 // Делим number на 10 (отбрасываем последнюю цифру)
        }
        return sum // Возвращаем сумму цифр числа
    }

    @JvmStatic
    fun main(args: Array<String>) { // Основная функция программы
        val scanner = Scanner(System.`in`) // Создаем объект Scanner для считывания ввода пользователя

        print("Enter the number of numbers: ") // Выводим приглашение для ввода количества чисел
        val n = scanner.nextInt() // Считываем количество чисел

        print("Enter numbers: ") // Выводим приглашение для ввода чисел
        for (i in 0 until n) { // Цикл от 0 до n (не включительно)
            val number = scanner.nextInt() // Считываем число
            // Проверяем, что сумма цифр числа состоит из одной цифры
            if (sumOfDigits(number) < 10 && number > -10) { // Если сумма цифр числа меньше 10 и число больше -10
                print("$number ") // Выводим число
            }
        }
        println() // Переходим на новую строку
    }
}
