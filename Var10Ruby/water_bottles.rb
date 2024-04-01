def main
  puts "Введите количество банок с водой: "
  bottles = gets.chomp.to_i  # Ввод количества банок с водой

  puts "Введите курс обмена пустых банок на новые: "
  rate = gets.chomp.to_i  # Ввод курса обмена пустых банок на новые

  bottles_drank = drink_water(bottles, rate)  # Вызов функции для определения максимального числа банок, которое можно выпить
  puts "Максимальное число банок, которое можно выпить: #{bottles_drank}"  # Вывод результата
end

def drink_water(bottles, rate)
  bottles_drank = bottles  # Инициализация переменной с количеством выпитых банок
  empty_bottles = bottles  # Инициализация переменной с количеством пустых банок
  steps = 1  # Инициализация переменной с количеством шагов

  puts "Дано: "  # Вывод заголовка
  print_happy_faces(bottles)  # Вызов функции для вывода смайликов
  puts "Шаг: #{steps}"  # Вывод номера текущего шага
  print_empty_bottles(empty_bottles)  # Вызов функции для вывода пустых банок

  while empty_bottles >= rate do  # Проверка, есть ли еще пустые банки для обмена
    exchanged_bottles = empty_bottles / rate  # Вычисление количества банок для обмена
    bottles_drank += exchanged_bottles  # Увеличение количества выпитых банок
    remaining_empty_bottles = empty_bottles % rate  # Вычисление оставшихся пустых банок
    empty_bottles = exchanged_bottles + remaining_empty_bottles  # Обновление количества пустых банок
    steps += 1  # Увеличение числа шагов

    puts "Шаг: #{steps}"  # Вывод номера текущего шага
    print_happy_faces(exchanged_bottles)  # Вызов функции для вывода смайликов
    print_empty_bottles(remaining_empty_bottles)  # Вызов функции для вывода пустых банок

    steps += 1  # Увеличение числа шагов
    puts "Шаг: #{steps}"  # Вывод номера текущего шага
    print_empty_bottles(empty_bottles)  # Вызов функции для вывода пустых банок
  end

  puts "Количество итераций: #{steps}"  # Вывод количества итераций
  bottles_drank  # Возвращаем количество выпитых банок
end

def print_happy_faces(n)
  print "☺" * n  # Вывод смайликов
  puts
end

def print_empty_bottles(n)
  print "©" * n  # Вывод пустых банок
  puts
end

main  # Вызов основной функции
