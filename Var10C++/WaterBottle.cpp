
#include <iostream>

using namespace std;

// Функция для печати счастливых лиц
void printHappyFaces(int n) {
    for (int i = 1; i <= n; i++) { // Цикл по количеству лиц
        cout << "&"; // Выводим символ лица
        if (i % 3 == 0) { // Если номер лица кратен 3
            cout << endl; // Переходим на новую строку
        }
        if (i == n && i % 3 != 0) { // Если последнее лицо и оно не кратно 3
            cout << endl; // Переходим на новую строку
        }
    }
}

// Функция для печати пустых бутылок
void printEmptyBottles(int n) {
    for (int i = 1; i <= n; i++) { // Цикл по количеству бутылок
        cout << "$"; // Выводим символ пустой бутылки
        if (i % 3 == 0) { // Если номер бутылки кратен 3
            cout << endl; // Переходим на новую строку
        }
        if (i == n && i % 3 != 0) { // Если последняя бутылка и она не кратна 3
            cout << endl; // Переходим на новую строку
        }
    }
}

// Функция для питья воды
int drinkWater(int bottles, int rate) {
    int bottlesDrank = bottles; // Изначально количество выпитых бутылок равно общему количеству бутылок
    int emptyBottles = bottles; // Изначально количество пустых бутылок равно общему количеству бутылок
    int steps = 1; // Номер текущего шага

    cout << "Given: " << endl; // Выводим заголовок
    printHappyFaces(bottles); // Выводим счастливые лица
    cout << "Step: " << steps << endl; // Выводим номер шага
    printEmptyBottles(emptyBottles); // Выводим пустые бутылки

    while (emptyBottles >= rate) { // Пока количество пустых бутылок больше или равно курсу обмена
        int exchangedBottles = emptyBottles / rate; // Вычисляем количество обмененных бутылок
        bottlesDrank += exchangedBottles; // Увеличиваем количество выпитых бутылок
        int remainingEmptyBottles = emptyBottles % rate; // Вычисляем оставшиеся пустые бутылки после обмена
        emptyBottles = exchangedBottles + remainingEmptyBottles; // Обновляем количество пустых бутылок
        steps++; // Увеличиваем номер шага

        cout << "Step: " << steps << endl; // Выводим номер шага
        printHappyFaces(exchangedBottles); // Выводим счастливые лица за текущий обмен
        printEmptyBottles(remainingEmptyBottles); // Выводим оставшиеся пустые бутылки

        steps++; // Увеличиваем номер шага
        cout << "Step: " << steps << endl; // Выводим номер шага
        printEmptyBottles(emptyBottles); // Выводим оставшиеся пустые бутылки после всех обменов
    }

    cout << "Number of iterations: " << steps << endl; // Выводим количество итераций
    return bottlesDrank; // Возвращаем количество выпитых бутылок
}

int main() {
    int bottles, rate;
    cout << "Enter the number of water bottles: "; // Приглашение к вводу количества бутылок с водой
    cin >> bottles; // Ввод количества бутылок с водой
    cout << "Enter the exchange rate of empty bottles for new ones: "; // Приглашение к вводу курса обмена
    cin >> rate; // Ввод курса обмена

    int bottlesDrank = drinkWater(bottles, rate); // Вызов функции для питья воды
    cout << "Maximum number of bottles that can be drunk: " << bottlesDrank << endl; // Вывод максимального количества бутылок, которое можно выпить

    return 0; // Возвращаем 0, чтобы обозначить успешное завершение программы
}

