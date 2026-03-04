extends Node

func _ready():
	# --- Примитивные типы ---
	
	var a = 10               # int (целое число)
	var b = 3.14             # float (число с плавающей точкой)
	var c = true             # bool
	var d = "Hello"          # String
	var e = null             # null
	
	# --- Явная типизация (рекомендуется в Godot 4) ---
	
	var x: int = 5
	var y: float = 2.5
	var name: String = "Alex"
	var flag: bool = false
	
	# --- Variant (любой тип) ---
	var anything: Variant = 42
	
	# --- Константа ---
	const MAX_SPEED: int = 200
	
	print(typeof(a))  # выводит enum типа


func array_examples():
	var arr: Array[int] = [1, 2, 3]
	
	arr.append(4)
	arr.push_back(5)
	arr.insert(1, 99)
	arr.remove_at(0)
	
	print(arr.size())
	print(arr.has(3))
	print(arr[0])
	
	for element in arr:
		print(element)


func dictionary_examples():
	var dict: Dictionary = {
		"name": "Hero",
		"hp": 100
	}
	
	dict["mana"] = 50
	
	print(dict["name"])
	print(dict.get("hp", 0))  # безопасное получение
	
	for key in dict.keys():
		print(key, dict[key])


func packed_arrays(): 
	var arr: PackedInt32Array = [1, 2, 3] # Используются для производительности
	arr.append(4)


func math_examples():
	var a: int = 10
	var b: int = 3

	print(a + b)  # сложение
	print(a - b)  # вычитание
	print(a * b)  # умножение
	print(a / b)  # деление (float)
	print(a % b)  # остаток

	print(pow(2, 3))         # 8
	print(abs(-5))           # 5
	print(clamp(15, 0, 10))  # 10


func datetime_examples():
	var now = Time.get_datetime_dict_from_system()
	
	print(now["year"])
	print(now["month"])
	print(now["day"])
	
	var unix_time = Time.get_unix_time_from_system()
	print(unix_time)
	
	var formatted = "%04d-%02d-%02d" % [
		now.year, now.month, now.day
	]
	print(formatted)
