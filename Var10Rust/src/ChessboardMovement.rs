use std::io;

// Функция isValidMove, которая проверяет, является ли передвижение по координатам (x, y)
// в пределах доски размера N x M, исходя из направления move ('L' - влево, 'R' - вправо, 'U' - вверх, 'D' - вниз).
fn is_valid_move(x: i32, y: i32, n: i32, m: i32, mov: char) -> bool {
    match mov {
        'L' => y > 1,
        'R' => y < m,
        'U' => x > 1,
        'D' => x < n,
        _ => false,
    }
}

// Функция find_start_position, которая находит стартовую позицию на доске размера N x M,
// с учетом строки команд s.
fn find_start_position(n: i32, m: i32, s: &str) -> (i32, i32) {
    for i in 1..=n {
        for j in 1..=m {
            let (mut x, mut y) = (i, j);
            let mut valid = true;

            for mov in s.chars() {
                if !is_valid_move(x, y, n, m, mov) {
                    valid = false;
                    break;
                }

                match mov {
                    'L' => y -= 1,
                    'R' => y += 1,
                    'U' => x -= 1,
                    'D' => x += 1,
                    _ => (),
                }
            }

            if valid {
                return (i, j);
            }
        }
    }
    (-1, -1)
}

// Основная функция программы.
fn main() {
    let mut input = String::new();

    // Запрос на ввод размеров доски.
    println!("Enter size (N M): ");
    io::stdin().read_line(&mut input).expect("Failed to read line");
    let mut dimensions = input.trim().split_whitespace();
    let n: i32 = dimensions.next().unwrap().parse().expect("Invalid number");
    let m: i32 = dimensions.next().unwrap().parse().expect("Invalid number");
    input.clear();

    // Запрос на ввод строки команд.
    println!("Enter string of commands: ");
    io::stdin().read_line(&mut input).expect("Failed to read line");
    let commands = input.trim();

    // Нахождение стартовой позиции на доске с учетом строки команд.
    let start_pos = find_start_position(n, m, commands);

    // Вывод результата: стартовой позиции или сообщения о невозможности выполнения всех команд.
    if start_pos == (-1, -1) {
        println!("It is impossible to complete all commands without leaving the board.");
    } else {
        println!("Result: {:?}", start_pos);
    }
}
