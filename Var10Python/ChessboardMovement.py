# Функция isValidMove, которая проверяет, является ли передвижение по координатам (x, y)
# в пределах доски размера N x M, исходя из направления move ('L' - влево, 'R' - вправо, 'U' - вверх, 'D' - вниз).
def is_valid_move(x, y, N, M, move):
    if move == 'L' and y > 1:
        return True
    elif move == 'R' and y < M:
        return True
    elif move == 'U' and x > 1:
        return True
    elif move == 'D' and x < N:
        return True
    return False

# Функция findStartPosition, которая находит стартовую позицию на доске размера N x M,
# с учетом строки команд s.
def find_start_position(N, M, s):
    for i in range(1, N+1):
        for j in range(1, M+1):
            x, y = i, j
            valid = True

            for move in s:
                if not is_valid_move(x, y, N, M, move):
                    valid = False
                    break

                if move == 'L':
                    y -= 1
                elif move == 'R':
                    y += 1
                elif move == 'U':
                    x -= 1
                elif move == 'D':
                    x += 1

            if valid:
                return (i, j)
    return (-1, -1)

# Основная функция программы.
def main():
    # Запрос на ввод размеров доски.
    N, M = map(int, input("Enter size (N M): ").split())

    # Запрос на ввод строки команд.
    s = input("Enter string of commands: ")

    # Нахождение стартовой позиции на доске с учетом строки команд.
    start_pos = find_start_position(N, M, s)

    # Вывод результата: стартовой позиции или сообщения о невозможности выполнения всех команд.
    if start_pos == (-1, -1):
        print("It is impossible to complete all commands without leaving the board.")
    else:
        print("Result:", start_pos)

# Вызов основной функции программы.
if __name__ == "__main__":
    main()
