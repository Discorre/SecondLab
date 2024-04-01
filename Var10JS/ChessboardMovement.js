// Функция isValidMove, которая проверяет, является ли передвижение по координатам (x, y)
// в пределах доски размера N x M, исходя из направления move ('L' - влево, 'R' - вправо, 'U' - вверх, 'D' - вниз).
function isValidMove(x, y, N, M, move) {
    if (move === 'L' && y > 1) {
        return true;
    } else if (move === 'R' && y < M) {
        return true;
    } else if (move === 'U' && x > 1) {
        return true;
    } else if (move === 'D' && x < N) {
        return true;
    }
    return false;
}

// Функция findStartPosition, которая находит стартовую позицию на доске размера N x M,
// с учетом строки команд s.
function findStartPosition(N, M, s) {
    for (let i = 1; i <= N; i++) {
        for (let j = 1; j <= M; j++) {
            let x = i, y = j;
            let valid = true;

            for (const move of s) {
                if (!isValidMove(x, y, N, M, move)) {
                    valid = false;
                    break;
                }

                if (move === 'L') y--;
                else if (move === 'R') y++;
                else if (move === 'U') x--;
                else if (move === 'D') x++;
            }

            if (valid) {
                return [i, j];
            }
        }
    }
    return [-1, -1];
}

// Основная функция программы.
function main() {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    rl.question("Enter size (N M): ", function(sizeInput) {
        const dimensions = sizeInput.trim().split(" ").map(Number);
        const N = dimensions[0];
        const M = dimensions[1];

        rl.question("Enter string of commands: ", function(commands) {
            const startPos = findStartPosition(N, M, commands);

            if (startPos[0] === -1 && startPos[1] === -1) {
                console.log("It is impossible to complete all commands without leaving the board.");
            } else {
                console.log("Result:", startPos);
            }

            rl.close();
        });
    });
}

// Вызов основной функции программы.
main();
