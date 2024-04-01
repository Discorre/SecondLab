import java.util.Scanner;

public class ChessboardMovement {

    // Функция, проверяющая, является ли данный ход допустимым для данной позиции на доске
    public static boolean isValidMove(int x, int y, int n, int m, char move) {
        if (move == 'L' && y > 1) {
            return true; // Если ход влево и y больше 1, возвращаем true.
        } else if (move == 'R' && y < m) {
            return true; // Если ход вправо и y меньше m, возвращаем true.
        } else if (move == 'U' && x > 1) {
            return true; // Если ход вверх и x больше 1, возвращаем true.
        } else if (move == 'D' && x < n) {
            return true; // Если ход вниз и x меньше n, возвращаем true.
        }
        return false; // В прочих случаях возвращаем false.
    }

    // Функция, ищущая стартовую позицию для выполнения всех команд
    public static int[] findStartPosition(int n, int m, String s) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int x = i, y = j;
                boolean valid = true;
                for (char move : s.toCharArray()) {
                    if (!isValidMove(x, y, n, m, move)) {
                        valid = false;
                        break;
                    }
                    if (move == 'L') y--; // Уменьшаем y при ходе влево.
                    else if (move == 'R') y++; // Увеличиваем y при ходе вправо.
                    else if (move == 'U') x++; // Уменьшаем x при ходе вверх.
                    else if (move == 'D') x--; // Увеличиваем x при ходе вниз.
                }
                if (valid) {
                    return new int[]{i, j}; // Если все команды могут быть выполнены, возвращаем позицию.
                }
            }
        }
        return new int[]{-1, -1}; // Если не удалось найти подходящую позицию, возвращаем {-1, -1}.
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размеры доски (N M): ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        System.out.print("Введите строку команд: ");
        String s = scanner.next();

        int[] startPos = findStartPosition(n, m, s); // Находим стартовую позицию для выполнения всех команд.

        if (startPos[0] == -1 && startPos[1] == -1) {
            System.out.println("Невозможно выполнить все команды, не выходя за пределы доски.");
        } else {
            System.out.println("Результат: (" + startPos[0] + "," + startPos[1] + ")");
        }
    }
}
