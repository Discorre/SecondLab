
/*
class WaterBottles
{
    static void Main()
    {
        // Ввод количества банок с водой
        Console.Write("Введите количество банок с водой: ");
        int bottles = int.Parse(Console.ReadLine());
        // Ввод курса обмена пустых банок на новые
        Console.Write("Введите курс обмена пустых банок на новые: ");
        int rate = int.Parse(Console.ReadLine());

        // Вызов функции DrinkWater для определения максимального числа выпитых банок
        int bottlesDrank = DrinkWater(bottles, rate);
        // Вывод результата
        Console.WriteLine("Максимальное число банок, которое можно выпить: " + bottlesDrank);
    }

    // Функция DrinkWater для вычисления максимального числа выпитых банок
    static int DrinkWater(int bottles, int rate)
    {
        int bottlesDrank = bottles; // Изначально количество выпитых банок равно начальному количеству
        int emptyBottles = bottles; // Изначально количество пустых банок равно начальному количеству
        int steps = 1; // Изначально количество шагов равно 1

        // Вывод информации о начальном состоянии
        Console.WriteLine("Дано: ");
        PrintHappyFaces(bottles);
        Console.WriteLine("Шаг: " + steps);
        PrintEmptyBottles(emptyBottles);

        // Пока количество пустых банок больше или равно курсу обмена
        while (emptyBottles >= rate)
        {
            int exchangedBottles = emptyBottles / rate; // Вычисление количества обмененных банок
            bottlesDrank += exchangedBottles; // Увеличение общего числа выпитых банок
            int remainingEmptyBottles = emptyBottles % rate; // Оставшиеся пустые банки после обмена
            emptyBottles = exchangedBottles + remainingEmptyBottles; // Обновление количества пустых банок
            steps++; // Увеличение количества шагов

            // Вывод информации о текущем состоянии
            Console.WriteLine("Шаг: " + steps);
            PrintHappyFaces(exchangedBottles);
            PrintEmptyBottles(remainingEmptyBottles);

            steps++; // Увеличение количества шагов
            Console.WriteLine("Шаг: " + steps);
            PrintEmptyBottles(emptyBottles);
        }

        // Вывод информации о количестве шагов и возврат общего числа выпитых банок
        Console.WriteLine("Количество итераций: " + steps);
        return bottlesDrank;
    }

    // Функция для вывода символов "☺", обозначающих выпитые банки
    static void PrintHappyFaces(int n)
    {
        for (int i = 1; i <= n; i++)
        {
            Console.Write("☺");
            if (i % 3 == 0)
            {
                Console.WriteLine();
            }
            if (i == n && i % 3 != 0)
            {
                Console.WriteLine();
            }
        }
    }

    // Функция для вывода символов "©", обозначающих пустые банки
    static void PrintEmptyBottles(int n)
    {
        for (int i = 1; i <= n; i++)
        {
            Console.Write("©");
            if (i % 3 == 0)
            {
                Console.WriteLine();
            }
            if (i == n && i % 3 != 0)
            {
                Console.WriteLine();
            }
        }
    }
}
*/

