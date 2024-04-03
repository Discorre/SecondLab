import Foundation

// Функция проверки допустимости хода
func isValidMove(x: Int, y: Int, n: Int, m: Int, move: Character) -> Bool {
    switch move {
    case "L":
        return y > 1
    case "R":
        return y < m
    case "U":
        return x > 1
    case "D":
        return x < n
    default:
        return false
    }
}

// Функция поиска начальной позиции
func findStartPosition(n: Int, m: Int, s: String) -> (Int, Int) {
    for i in 1...n {
        for j in 1...m {
            var x = i, y = j
            var valid = true
            for move in s {
                if !isValidMove(x: x, y: y, n: n, m: m, move: move) {
                    valid = false
                    break
                }
                switch move {
                case "L":
                    y -= 1
                case "R":
                    y += 1
                case "U":
                    x += 1
                case "D":
                    x -= 1
                default:
                    break
                }
            }
            if valid {
                return (i, j)
            }
        }
    }
    return (-1, -1) // Если не удалось найти начальную позицию
}

// Основная программа
print("Введите размеры доски (N M): ")
if let boardSize = readLine(), let sizes = boardSize.split(separator: " ").map({ Int($0) }) {
    let n = sizes[0]
    let m = sizes[1]

    print("Введите строку команд: ")
    if let commands = readLine() {
        let startPos = findStartPosition(n: n, m: m, s: commands)
        
        if startPos == (-1, -1) {
            print("Невозможно выполнить все команды, не выходя за пределы доски.")
        } else {
            print("Результат: \(startPos)")
        }
    }
}
