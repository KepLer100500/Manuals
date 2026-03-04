extends Node

func file_write():
	var file = FileAccess.open("user://save.txt", FileAccess.WRITE)
	file.store_string("Hello world")
	file.close()


func file_read():
	if not FileAccess.file_exists("user://save.txt"):
		return
	
	var file = FileAccess.open("user://save.txt", FileAccess.READ)
	var content = file.get_as_text()
	file.close()
	
	print(content)
