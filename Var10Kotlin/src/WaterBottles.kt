import java.util.Scanner // Импорт класса Scanner из пакета java.util для считывания ввода пользователя

fun main() { // Основная функция программы
    val scanner = Scanner(System.`in`) // Создание объекта Scanner для считывания ввода пользователя
    print("Введите количество банок с водой: ") // Вывод приглашения к вводу количества банок с водой
    val bottles = scanner.nextInt() // Считывание количества банок с водой
    print("Введите курс обмена пустых банок на новые: ") // Вывод приглашения к вводу курса обмена
    val rate = scanner.nextInt() // Считывание курса обмена

    val bottlesDrank = drinkWater(bottles, rate) // Вызов функции для расчета максимального числа банок, которое можно выпить
    println("Максимальное число банок, которое можно выпить: $bottlesDrank") // Вывод результата
}

fun drinkWater(bottles: Int, rate: Int): Int { // Функция для расчета максимального числа банок, которое можно выпить
    var bottlesDrank = bottles // Изначально количество выпитых банок равно начальному количеству банок
    var emptyBottles = bottles // Изначально количество пустых банок равно начальному количеству банок
    var steps = 1 // Счетчик шагов итерации

    println("Дано: ") // Вывод информации о начальном состоянии
    printHappyFaces(bottles) // Вывод смайликов ☺
    println("Шаг: $steps") // Вывод номера текущего шага
    printEmptyBottles(emptyBottles) // Вывод пустых банок

    while (emptyBottles >= rate) { // Пока есть пустые банки для обмена
        val exchangedBottles = emptyBottles / rate // Расчет количества обмененных банок
        bottlesDrank += exchangedBottles // Увеличение количества выпитых банок
        val remainingEmptyBottles = emptyBottles % rate // Остаток пустых банок после обмена
        emptyBottles = exchangedBottles + remainingEmptyBottles // Обновление количества пустых банок
        steps++ // Увеличение счетчика шагов

        println("Шаг: $steps") // Вывод номера текущего шага
        printHappyFaces(exchangedBottles) // Вывод смайликов ☺
        printEmptyBottles(remainingEmptyBottles) // Вывод оставшихся пустых банок

        steps++ // Увеличение счетчика шагов
        println("Шаг: $steps") // Вывод номера текущего шага
        printEmptyBottles(emptyBottles) // Вывод пустых банок
    }

    println("Количество итераций: $steps") // Вывод количества итераций
    return bottlesDrank // Возврат количества выпитых банок
}

fun printHappyFaces(n: Int) { // Функция для вывода смайликов ☺
    for (i in 1..n) { // Цикл по количеству банок
        print("☺") // Вывод смайлика ☺
        if (i % 3 == 0) { // Если достигнуто количество банок, кратное 3
            println() // Вывод перевода строки
        }
        if (i == n && i % 3 != 0) { // Если достигнуто количество банок, не кратное 3
            println() // Вывод перевода строки
        }
    }
}

fun printEmptyBottles(n: Int) { // Функция для вывода пустых банок
    for (i in 1..n) { // Цикл по количеству банок
        print("©") // Вывод символа пустой банки ©
        if (i % 3 == 0) { // Если достигнуто количество банок, кратное 3
            println() // Вывод перевода строки
        }
        if (i == n && i % 3 != 0) { // Если достигнуто количество банок, не кратное 3
            println() // Вывод перевода строки
        }
    }
}
