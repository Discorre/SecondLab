import java.util.Scanner

fun isValidMove(x: Int, y: Int, n: Int, m: Int, move: Char): Boolean {
    return when (move) {
        'L' -> y > 1
        'R' -> y < m
        'U' -> x > 1
        'D' -> x < n
        else -> false
    }
}

fun findStartPosition(n: Int, m: Int, s: String): Pair<Int, Int> {
    for (i in 1..n) {
        for (j in 1..m) {
            var x = i
            var y = j
            var valid = true
            for (move in s) {
                if (!isValidMove(x, y, n, m, move)) {
                    valid = false
                    break
                }
                when (move) {
                    'L' -> y--
                    'R' -> y++
                    'U' -> x++
                    'D' -> x--
                }
            }
            if (valid) {
                return Pair(i, j)
            }
        }
    }
    return Pair(-1, -1)
}

fun main() {
    val scanner = Scanner(System.`in`)

    print("Введите размеры доски (N M): ")
    val n = scanner.nextInt()
    val m = scanner.nextInt()

    print("Введите строку команд: ")
    val s = scanner.next()

    val startPos = findStartPosition(n, m, s)

    if (startPos == Pair(-1, -1)) {
        println("Невозможно выполнить все команды, не выходя за пределы доски.")
    } else {
        println("Результат: $startPos")
    }
}
