def main():
    bottles = int(input("Введите количество банок с водой: "))  # Ввод количества банок с водой
    rate = int(input("Введите курс обмена пустых банок на новые: "))  # Ввод курса обмена пустых банок на новые

    bottles_drank = drink_water(bottles, rate)  # Вызов функции для расчета максимального числа выпитых банок
    print(f"Максимальное число банок, которое можно выпить: {bottles_drank}")  # Вывод результата

def drink_water(bottles, rate):
    bottles_drank = bottles  # Инициализация переменной с количеством выпитых банок
    empty_bottles = bottles  # Инициализация переменной с количеством пустых банок
    steps = 1  # Инициализация переменной с количеством шагов

    print("Дано: ")  # Вывод заголовка
    print_happy_faces(bottles)  # Вызов функции для вывода смайликов
    print("Шаг:", steps)  # Вывод номера текущего шага
    print_empty_bottles(empty_bottles)  # Вызов функции для вывода пустых банок

    while empty_bottles >= rate:  # Проверка, есть ли еще пустые банки для обмена
        exchanged_bottles = empty_bottles // rate  # Вычисление количества банок для обмена
        bottles_drank += exchanged_bottles  # Увеличение количества выпитых банок
        remaining_empty_bottles = empty_bottles % rate  # Вычисление оставшихся пустых банок
        empty_bottles = exchanged_bottles + remaining_empty_bottles  # Обновление количества пустых банок
        steps += 1  # Увеличение числа шагов

        print("Шаг:", steps)  # Вывод номера текущего шага
        print_happy_faces(exchanged_bottles)  # Вызов функции для вывода смайликов
        print_empty_bottles(remaining_empty_bottles)  # Вызов функции для вывода пустых банок

        steps += 1  # Увеличение числа шагов
        print("Шаг:", steps)  # Вывод номера текущего шага
        print_empty_bottles(empty_bottles)  # Вызов функции для вывода пустых банок

    print("Количество итераций:", steps)  # Вывод количества итераций
    return bottles_drank  # Возвращаем количество выпитых банок

def print_happy_faces(n):
    happy_faces = "☺" * n  # Создание строки из смайликов
    if n % 3 != 0:  # Проверка, нужно ли перейти на новую строку
        happy_faces += '\n'  # Добавление перехода на новую строку
    print(happy_faces)  # Вывод смайликов

def print_empty_bottles(n):
    empty_bottles = "©" * n  # Создание строки из пустых банок
    if n % 3 != 0:  # Проверка, нужно ли перейти на новую строку
        empty_bottles += '\n'  # Добавление перехода на новую строку
    print(empty_bottles)  # Вывод пустых банок

main()  # Вызов основной функции программы
