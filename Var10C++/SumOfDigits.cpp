#include <iostream>
#include <vector>

// Функция для вычисления суммы цифр числа
int sumOfDigits(int num) {
    int sum = 0;
    while (num != 0) { // Пока число не равно 0
        sum += num % 10; // Добавляем к сумме последнюю цифру числа
        num /= 10; // Удаляем последнюю цифру числа
    }
    return sum; // Возвращаем сумму цифр числа
}

int main() {
    int n;
    std::cout << "Enter the number of numbers: "; // Выводим приглашение для ввода количества чисел
    std::cin >> n; // Считываем количество чисел

    std::vector<int> numbers(n); // Создаем вектор для хранения чисел
    std::cout << "Enter numbers: "; // Выводим приглашение для ввода чисел
    for (int i = 0; i < n; ++i) { // Цикл для ввода чисел
        std::cin >> numbers[i]; // Считываем число и добавляем его в вектор
    }

    std::cout << "Numbers whose sum of digits consists of one decimal place: "; // Выводим заголовок
    for (int i = 0; i < n; ++i) { // Цикл для проверки каждого числа
        if (sumOfDigits(numbers[i]) < 10 && numbers[i] > -10) { // Если сумма цифр числа меньше 10 и число больше -10
            std::cout << numbers[i] << " "; // Выводим число
        }
    }
    std::cout << std::endl; // Переходим на новую строку

    return 0;
}
