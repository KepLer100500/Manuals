extends Node

func condition_example(value: int):
	if value > 10:
		print("Больше 10")
	elif value == 10:
		print("Равно 10")
	else:
		print("Меньше 10")


# Аналог switch — match
func match_example(state: String):
	match state:
		"idle":
			print("Стоит")
		"run":
			print("Бежит")
		_:
			print("Неизвестное состояние")


func loop_examples():
	# --- for по диапазону ---
	for i in range(5):
		print(i)  # 0..4
	
	# --- for с шагом ---
	for i in range(0, 10, 2):
		print(i)  # 0,2,4,6,8
	
	# --- while ---
	var x = 0
	while x < 5:
		print(x)
		x += 1
	
	# --- break / continue ---
	for i in range(10):
		if i == 3:
			continue
		if i == 7:
			break
		print(i)
