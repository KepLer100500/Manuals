extends Node

func divide(a: float, b: float) -> float:
	assert(b != 0, "Division by zero!")
	return a / b


func load_resource(path: String):
	var res = load(path)
	if res == null:
		push_error("Не удалось загрузить ресурс")
		return null
	return res
