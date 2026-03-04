extends Node

func regex_example1():
	var regex = RegEx.new()
	regex.compile("\\d+")  # поиск чисел
	
	var result = regex.search("Age: 25")
	
	if result:
		print(result.get_string())  # 25


func regex_example2():
	var regex = RegEx.new()
	regex.compile("(\\w+)@(\\w+\\.\\w+)")
	var match = regex.search("mail@test.com")

	if match:
		print(match.get_string(1))  # mail
		print(match.get_string(2))  # test.com
