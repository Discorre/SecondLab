class Program
{
    // Функция для вычисления суммы цифр числа
    static int SumOfDigits(int num)
    {
        int sum = 0;
        // Если число отрицательное, меняем знак
        if (num < 0)
            num *= -1;
        while (num != 0)
        {
            sum += num % 10; // Добавляем к сумме последнюю цифру числа
            num /= 10; // Удаляем последнюю цифру числа
        }
        return sum; // Возвращаем сумму цифр числа
    }

    static void Main(string[] args)
    {
        Console.Write("Enter the number of numbers: "); // Приглашение к вводу количества чисел
        int n = int.Parse(Console.ReadLine()); // Ввод количества чисел

        Console.Write("Enter numbers separated by space: "); // Приглашение к вводу чисел через пробел
        string[] numbersStr = Console.ReadLine().Split(' '); // Ввод чисел и разделение строки по пробелам
        int[] numbers = Array.ConvertAll(numbersStr, int.Parse); // Преобразование строковых чисел в массив целых чисел

        foreach (int number in numbers)
        {
            // Проверяем, что сумма цифр числа состоит из одной цифры и число не меньше -9
            if (SumOfDigits(number) < 10 && number > -10)
            {
                Console.Write(number + " "); // Выводим число
            }
        }
        Console.WriteLine(); // Переход на новую строку
    }
}