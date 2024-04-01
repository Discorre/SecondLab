import java.util.Scanner; // Импорт класса Scanner из пакета java.util для считывания ввода пользователя

public class WaterBottles { // Объявление публичного класса WaterBottles
    public static void main(String[] args) { // Основной метод программы
        Scanner in = new Scanner(System.in); // Создание объекта Scanner для считывания ввода пользователя из стандартного потока ввода

        System.out.print("Введите количество банок с водой: "); // Вывод приглашения для ввода количества банок
        int bottles = in.nextInt(); // Считывание количества банок

        System.out.print("Введите курс обмена пустых банок на новые: "); // Вывод приглашения для ввода курса обмена
        int rate = in.nextInt(); // Считывание курса обмена

        int bottlesDrank = drinkWater(bottles, rate); // Вызов метода drinkWater для вычисления максимального числа выпитых банок
        System.out.println("Максимальное число банок, которое можно выпить:  " + bottlesDrank); // Вывод результата
    }

    public static int drinkWater(int bottles, int rate) { // Метод для вычисления максимального числа выпитых банок
        int bottlesDrank = bottles; // Инициализация переменной bottlesDrank числом банок, переданных в качестве аргумента

        int emptyBottles = bottles; // Инициализация переменной emptyBottles числом банок, переданных в качестве аргумента
        int steps = 1; // Инициализация переменной steps

        System.out.println("Дано: "); // Вывод строки "Дано: "
        printHappyFaces(bottles); // Вызов метода printHappyFaces для печати улыбающихся лиц
        System.out.println("Шаг: " + steps); // Вывод номера шага
        printEmptyBottles(emptyBottles); // Вызов метода printEmptyBottles для печати пустых банок

        while (emptyBottles >= rate) { // Цикл, выполняющийся пока количество пустых банок больше или равно курсу обмена
            int exchangedBottles = emptyBottles / rate; // Вычисление количества обмененных банок
            bottlesDrank += exchangedBottles; // Увеличение общего числа выпитых банок на количество обмененных банок

            int remainingEmptyBottles = emptyBottles % rate; // Вычисление оставшихся пустых банок после обмена
            emptyBottles = exchangedBottles + remainingEmptyBottles; // Обновление числа пустых банок
            steps++; // Увеличение счетчика шагов

            System.out.println("Шаг: " + steps); // Вывод номера шага
            printHappyFaces(exchangedBottles); // Вызов метода printHappyFaces для печати улыбающихся лиц
            printEmptyBottles(remainingEmptyBottles); // Вызов метода printEmptyBottles для печати пустых банок

            steps++; // Увеличение счетчика шагов
            System.out.println("Шаг: " + steps); // Вывод номера шага
            printEmptyBottles(emptyBottles); // Вызов метода printEmptyBottles для печати пустых банок
        }

        System.out.println("Количество итераций: " + steps); // Вывод количества итераций
        return bottlesDrank; // Возвращение общего числа выпитых банок
    }

    public static void printHappyFaces(int n) { // Метод для печати улыбающихся лиц
        for (int i = 1; i <= n; i++) { // Цикл для печати улыбающихся лиц
            System.out.print("☺"); // Вывод улыбающегося лица
            if (i % 3 == 0) { // Проверка, является ли текущее лицо третьим в строке
                System.out.println(); // Переход на новую строку
            }
            if (i == n & i % 3 != 0){ // Проверка, является ли текущее лицо последним и не третьим в строке
                System.out.println(); // Переход на новую строку
            }
        }
    }

    public static void printEmptyBottles(int n) { // Метод для печати пустых банок
        for (int i = 1; i <= n; i++) { // Цикл для печати пустых банок
            System.out.print("©"); // Вывод пустой банки
            if (i % 3 == 0) { // Проверка, является ли текущая банка третьей в строке
                System.out.println(); // Переход на новую строку
            }
            if (i == n & i % 3 != 0){ // Проверка, является ли текущая банка последней и не третьей в строке
                System.out.println(); // Переход на новую строку
            }
        }
    }
}
