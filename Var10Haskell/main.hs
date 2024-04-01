-- Функция, проверяющая, является ли данный ход допустимым для данной позиции на доске
isValidMove :: Int -> Int -> Int -> Int -> Char -> Bool
isValidMove x y n m move
    | move == 'L' && y > 1 = True
    | move == 'R' && y < m = True
    | move == 'U' && x > 1 = True
    | move == 'D' && x < n = True
    | otherwise = False

-- Функция, ищущая стартовую позицию для выполнения всех команд
findStartPosition :: Int -> Int -> String -> (Int, Int)
findStartPosition n m s = head [(i, j) | i <- [1..n], j <- [1..m], isValidStart i j]
    where isValidStart i j = all (\move -> isValidMove i j n m move) s

-- Главная функция, ввод размеров доски и строки команд, и вывод результата
main :: IO ()
main = do
    putStrLn "Введите размеры доски (N M): "
    line <- getLine
    let [n, m] = map read $ words line :: [Int]
    putStrLn "Введите строку команд: "
    s <- getLine
    let startPos = findStartPosition n m s
    if startPos == (-1, -1)
        then putStrLn "Невозможно выполнить все команды, не выходя за пределы доски."
        else putStrLn $ "Результат: " ++ show startPos
