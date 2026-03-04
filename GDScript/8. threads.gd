extends Node

var thread: Thread

func _ready():
	thread = Thread.new()
	thread.start(Callable(self, "_thread_function"))


func _thread_function():
	for i in range(5):
		print("Working in thread:", i)
		OS.delay_msec(500)
	return "Done"


func _exit_tree():
	if thread.is_alive():
		thread.wait_to_finish()

# ----- Coroutines (await) -----

func wait_example():
	print("Start")
	await get_tree().create_timer(2.0).timeout
	print("After 2 seconds")

# ----- Signals -----

var health = 100
signal health_changed(new_health)

func take_damage(amount):
	health -= amount
	health_changed.emit(health)
