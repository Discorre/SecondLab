const readline = require('readline'); // Импорт модуля readline для взаимодействия с консолью

const rl = readline.createInterface({ // Создание интерфейса для ввода-вывода
    input: process.stdin, // Ввод из стандартного потока ввода (консоль)
    output: process.stdout // Вывод в стандартный поток вывода (консоль)
});

function main() {
    rl.question("Введите количество банок с водой: ", (bottlesInput) => { // Запрос ввода количества банок с водой
        const bottles = parseInt(bottlesInput); // Преобразование введенной строки в число

        rl.question("Введите курс обмена пустых банок на новые: ", (rateInput) => { // Запрос ввода курса обмена
            const rate = parseInt(rateInput); // Преобразование введенной строки в число

            const bottlesDrank = drinkWater(bottles, rate); // Вызов функции для вычисления максимального количества выпитых банок
            console.log(`Максимальное число банок, которое можно выпить: ${bottlesDrank}`); // Вывод результата в консоль
            rl.close(); // Закрытие интерфейса ввода-вывода
        });
    });
}

function drinkWater(bottles, rate) {
    let bottlesDrank = bottles; // Инициализация переменной для хранения количества выпитых банок
    let emptyBottles = bottles; // Инициализация переменной для хранения количества пустых банок
    let steps = 1; // Инициализация переменной для подсчета шагов

    console.log("Дано: "); // Вывод сообщения о начале работы программы
    printHappyFaces(bottles); // Вывод изображения смайликов в консоль
    console.log("Шаг: " + steps); // Вывод текущего шага в консоль
    printEmptyBottles(emptyBottles); // Вывод изображения пустых банок в консоль

    while (emptyBottles >= rate) { // Пока количество пустых банок больше или равно курсу обмена
        const exchangedBottles = Math.floor(emptyBottles / rate); // Вычисление количества обмененных банок
        bottlesDrank += exchangedBottles; // Обновление общего количества выпитых банок
        const remainingEmptyBottles = emptyBottles % rate; // Вычисление оставшихся пустых банок
        emptyBottles = exchangedBottles + remainingEmptyBottles; // Обновление количества пустых банок
        steps++; // Увеличение счетчика шагов

        console.log("Шаг: " + steps); // Вывод текущего шага в консоль
        printHappyFaces(exchangedBottles); // Вывод изображения смайликов для обмененных банок в консоль
        printEmptyBottles(remainingEmptyBottles); // Вывод изображения пустых банок в консоль

        steps++; // Увеличение счетчика шагов
        console.log("Шаг: " + steps); // Вывод текущего шага в консоль
        printEmptyBottles(emptyBottles); // Вывод изображения пустых банок в консоль
    }

    console.log("Количество итераций: " + steps); // Вывод количества итераций в консоль
    return bottlesDrank; // Возврат общего количества выпитых банок
}

function printHappyFaces(n) {
    let happyFaces = '☺'.repeat(n); // Формирование строки смайликов
    if (n % 3 !== 0) happyFaces += '\n'; // Добавление переноса строки, если количество смайликов не кратно 3
    console.log(happyFaces); // Вывод строки смайликов в консоль
}

function printEmptyBottles(n) {
    let emptyBottles = '©'.repeat(n); // Формирование строки пустых банок
    if (n % 3 !== 0) emptyBottles += '\n'; // Добавление переноса строки, если количество пустых банок не кратно 3
    console.log(emptyBottles); // Вывод строки пустых банок в консоль
}

main(); // Вызов основной функции
