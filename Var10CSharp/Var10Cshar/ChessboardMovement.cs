/*
class Program
{
    // Функция проверки допустимости хода
    static bool IsValidMove(int x, int y, int n, int m, char move)
    {
        switch (move)
        {
            case 'L':
                return y > 1;
            case 'R':
                return y < m;
            case 'U':
                return x > 1;
            case 'D':
                return x < n;
            default:
                return false;
        }
    }

    // Функция поиска начальной позиции
    static Tuple<int, int> FindStartPosition(int n, int m, string s)
    {
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                int x = i, y = j;
                bool valid = true;
                foreach (char move in s)
                {
                    if (!IsValidMove(x, y, n, m, move))
                    {
                        valid = false;
                        break;
                    }
                    switch (move)
                    {
                        case 'L':
                            y--;
                            break;
                        case 'R':
                            y++;
                            break;
                        case 'U':
                            x--;
                            break;
                        case 'D':
                            x++;
                            break;
                    }
                }
                if (valid)
                {
                    return Tuple.Create(i, j); // Возвращаем координаты начальной позиции
                }
            }
        }
        return Tuple.Create(-1, -1); // Если не удалось найти начальную позицию
    }

    static void Main(string[] args)
    {
        Console.Write("Введите размеры доски (N M): ");
        string[] sizes = Console.ReadLine().Split();
        int n = int.Parse(sizes[0]);
        int m = int.Parse(sizes[1]);

        Console.Write("Введите строку команд: ");
        string s = Console.ReadLine();

        Tuple<int, int> startPos = FindStartPosition(n, m, s);

        if (startPos.Item1 == -1 && startPos.Item2 == -1)
        {
            Console.WriteLine("Невозможно выполнить все команды, не выходя за пределы доски.");
        }
        else
        {
            Console.WriteLine($"Результат: ({startPos.Item1}, {startPos.Item2})");
        }
    }
}
*/
