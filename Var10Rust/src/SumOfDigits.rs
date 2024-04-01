use std::io;

// Функция для вычисления суммы цифр числа
fn sum_of_digits(mut num: i32) -> i32 {
    let mut sum = 0;
    // Если число отрицательное, меняем знак
    if num < 0 {
        num *= -1;
    }
    while num != 0 {
        sum += num % 10;
        num /= 10;
    }
    sum
}

fn main() {
    println!("Enter the number of numbers:");
    let mut input = String::new();
    io::stdin().read_line(&mut input).expect("Failed to read line");
    let n: i32 = input.trim().parse().expect("Please enter a valid number");

    println!("Enter numbers separated by space:");
    input.clear();
    io::stdin().read_line(&mut input).expect("Failed to read line");
    let numbers: Vec<i32> = input
        .split_whitespace()
        .map(|s| s.parse().expect("Please enter valid numbers"))
        .collect();

    for number in numbers.iter() {
        // Проверяем, что сумма цифр числа состоит из одной цифры
        if sum_of_digits(*number) < 10 && *number > -10 {
            print!("{} ", number);
        }
    }
    println!();
}
