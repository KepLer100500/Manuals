extends Node

# Функция без возврата
func say_hello(name: String) -> void:
	print("Hello ", name)


# Функция с возвратом
func add(a: int, b: int) -> int:
	return a + b


# Значение по умолчанию
func power(base: int, exp: int = 2) -> int:
	return pow(base, exp)


# Вариативные аргументы
func sum_all(args: Array) -> int:
	var total = 0
	for x in args:
		total += x
	return total


func lambda_example():
	var double = func(x: int) -> int:
		return x * 2
	
	print(double.call(5))
	
	# Передача в сортировку
	var arr = [5, 2, 9]
	arr.sort_custom(func(a, b): return a < b)
