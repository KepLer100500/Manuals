extends CharacterBody2D

# Player_test.gd
class_name Player_test  # регистрирует глобальный тип

var speed: float = 200.0
var health: int = 100

func _physics_process(delta: float) -> void:
	var direction = Input.get_vector("left", "right", "up", "down")
	velocity = direction * speed
	move_and_slide()

func take_damage(amount: int) -> void:
	health -= amount
	if health <= 0:
		die()

func die():
	queue_free()

# -----------------

class Weapon:
	var damage: int
	
	func _init(dmg: int):
		damage = dmg
	
	func attack():
		print("Damage:", damage)

func _ready():
	var sword = Weapon.new(25)
	sword.attack()

# -----------------

# Enemy.gd
extends CharacterBody2D

var health: int = 50

func attack():
	print("Enemy attacks!")

# Boss.gd
extends "res://Enemy.gd"

func attack():
	print("Boss powerful attack!")
