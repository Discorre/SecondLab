// Функция для вычисления суммы цифр числа
function sumOfDigits(num) {
    let sum = 0;  // Инициализация переменной для хранения суммы цифр
    // Если число отрицательное, меняем знак
    if (num < 0) num *= -1;  // Изменение знака числа на положительный
    while (num !== 0) {  // Пока число не равно нулю
        sum += num % 10;  // Добавляем последнюю цифру числа к сумме
        num = Math.floor(num / 10);  // Удаляем последнюю цифру числа
    }
    return sum;  // Возвращаем сумму цифр числа
}

function main() {
    const readline = require('readline');  // Импорт модуля readline для взаимодействия с консолью
    const rl = readline.createInterface({  // Создание интерфейса для чтения из консоли
        input: process.stdin,  // Использование стандартного ввода
        output: process.stdout  // Использование стандартного вывода
    });

    rl.question("Enter the number of numbers: ", function (n) {  // Запрос ввода количества чисел
        rl.question("Enter numbers: ", function (numbers) {  // Запрос ввода чисел
            numbers = numbers.split(' ').map(Number);  // Разделение введенной строки на числа и преобразование в массив чисел
            for (let i = 0; i < n; ++i) {  // Перебор каждого числа
                const number = numbers[i];  // Получение текущего числа
                // Проверяем, что сумма цифр числа состоит из одной цифры
                if (sumOfDigits(number) < 10 && number > -10) {  // Если условие выполняется
                    process.stdout.write(number + " ");  // Вывод числа в консоль
                }
            }
            process.stdout.write("\n");  // Переход на новую строку
            rl.close();  // Закрытие интерфейса чтения
        });
    });
}

main();  // Вызов основной функции
