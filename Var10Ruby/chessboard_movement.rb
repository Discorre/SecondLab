# Функция проверки допустимости хода
def is_valid_move(x, y, n, m, move)
  case move
  when 'L'
    y > 1
  when 'R'
    y < m
  when 'U'
    x > 1
  when 'D'
    x < n
  else
    false
  end
end

# Функция поиска начальной позиции
def find_start_position(n, m, s)
  (1..n).each do |i|
    (1..m).each do |j|
      x, y = i, j
      valid = true
      s.each_char do |move|
        unless is_valid_move(x, y, n, m, move)
          valid = false
          break
        end
        case move
        when 'L'
          y -= 1
        when 'R'
          y += 1
        when 'U'
          x -= 1
        when 'D'
          x += 1
        end
      end
      return [i, j] if valid
    end
  end
  [-1, -1] # Если не удалось найти начальную позицию
end

# Основная программа
print "Введите размеры доски (N M): "
n, m = gets.chomp.split.map(&:to_i)

print "Введите строку команд: "
s = gets.chomp

start_pos = find_start_position(n, m, s)

if start_pos == [-1, -1]
  puts "Невозможно выполнить все команды, не выходя за пределы доски."
else
  puts "Результат: #{start_pos}"
end
