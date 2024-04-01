
#include <iostream>
#include <string>

using namespace std;

// Объявление функции isValidMove, которая проверяет, является ли передвижение по координатам (x, y)
// в пределах доски размера N x M, исходя из направления move ('L' - влево, 'R' - вправо, 'U' - вверх, 'D' - вниз).
bool isValidMove(int x, int y, int N, int M, char move) {
    // Проверка, можно ли совершить передвижение влево (move == 'L') и координата y больше 1.
    if (move == 'L' && y > 1) {
        return true;
    }
        // Проверка, можно ли совершить передвижение вправо (move == 'R') и координата y меньше M.
    else if (move == 'R' && y < M) {
        return true;
    }
        // Проверка, можно ли совершить передвижение вверх (move == 'U') и координата x больше 1.
    else if (move == 'U' && x > 1) {
        return true;
    }
        // Проверка, можно ли совершить передвижение вниз (move == 'D') и координата x меньше N.
    else if (move == 'D' && x < N) {
        return true;
    }
    // Если ни одно из условий не выполнилось, возвращается false.
    return false;
}

// Объявление функции findStartPosition, которая находит стартовую позицию на доске размера N x M,
// с учетом строки команд s.
pair<int, int> findStartPosition(int N, int M, const string& s) {
    // Проход по всем клеткам доски.
    for (int i = 1; i <= N; ++i) {
        for (int j = 1; j <= M; ++j) {
            int x = i, y = j; // Установка текущих координат.
            bool valid = true; // Флаг, показывающий, является ли текущая позиция допустимой.
            // Проверка каждой команды из строки s.
            for (char move : s) {
                // Если передвижение не допустимо, устанавливаем флаг valid в false и прерываем цикл.
                if (!isValidMove(x, y, N, M, move)) {
                    valid = false;
                    break;
                }
                // Обновление координат в соответствии с выполненной командой.
                if (move == 'L') y--;
                else if (move == 'R') y++;
                else if (move == 'U') x++;
                else if (move == 'D') x--;
            }
            // Если все команды выполняются допустимо, возвращается текущая позиция.
            if (valid) {
                return make_pair(i, j);
            }
        }
    }
    // Если ни одна позиция не является допустимой, возвращается (-1, -1).
    return make_pair(-1, -1);
}

// Основная функция программы.
int main() {
    int N, M; // Переменные для хранения размеров доски.
    string s; // Строка команд.

    // Вывод запроса на ввод размеров доски.
    cout << "Enter size (N M): ";
    cin >> N >> M;
    // Вывод запроса на ввод строки команд.
    cout << "Enter string of commands: ";
    cin >> s;

    // Нахождение стартовой позиции на доске с учетом строки команд.
    pair<int, int> startPos = findStartPosition(N, M, s);

    // Вывод результата: стартовой позиции или сообщения о невозможности выполнения всех команд.
    if (startPos.first == -1 && startPos.second == -1) {
        cout << "It is impossible to complete all commands without leaving the board.\n";
    } else {
        cout << "Result: (" << startPos.first << "," << startPos.second << ")\n";
    }

    return 0;
}

