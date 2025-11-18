void learnPatternMatchingDestructuring() {
  // Destructuring (деструктуризация) с записями (records)
  var person = (name: 'Alice', age: 30);
  var (name: name, age: age) = person; // Извлечение в переменные
  print('Имя: $name, Возраст: $age');

  // Извлечение с именованными полями
  var (name: extractedName, age: extractedAge) = person;
  print('Извлечено: $extractedName, $extractedAge');

  // Destructuring в цикле
  List<(String, int)> people = [
    ('Bob', 25),
    ('Charlie', 35)
  ];
  for (var (name, age) in people) {
    print('$name, $age лет');
  }

  // Pattern Matching в switch (Dart 3.0+)
  Object value = 42;
  String result = switch (value) {
    int n when n >= 0 => 'Положительное число', // Охранные выражения
    int => 'Отрицательное число',
    String s when s.length > 5 => 'Длинная строка: $s',
    String => 'Короткая строка',
    _ => 'Другое', // default
  };
  print(result);

  // Pattern Matching с коллекциями
  List<int> list = [1, 2, 3];
  var listMatch = switch (list) {
    [var first, _, var last] => 'Первый: $first, Последний: $last', // Извлечение
    [] => 'Пустой список',
    _ => 'Другой список',
  };
  print(listMatch);

  // Pattern Matching с Map
  Map<String, dynamic> user = {'name': 'Dave', 'age': 40};
  var userMatch = switch (user) {
    {'name': String name, 'age': int age} => 'Имя: $name, Возраст: $age',
    _ => 'Неполные данные',
  };
  print(userMatch);

  // Использование when (охранные выражения)
  int number = 10;
  String evenOrOdd = switch (number) {
    int n when n % 2 == 0 => 'чётное',
    int n when n % 2 != 0 => 'нечётное',
    _ => 'не число',
  };
  print('Число $number — $evenOrOdd');

  // 1. Деструктурирование списка
  List<int> numbers = [1, 2, 3, 4];
  var [first, second, _, fourth] = numbers; // Пропуск третьего
  print('1. Первый: $first, Второй: $second, Четвёртый: $fourth');

  // С остатком
  var [head, ...rest] = numbers;
  print('Голова: $head, Остальные: $rest');

  // 2. Деструктурирование записи
  var personRecord = (name: 'Alice', age: 30, city: 'NYC');
  var (name: n, age: a, city: c) = personRecord;
  print('2. Имя: $n, Возраст: $a, Город: $c');

  // Краткая форма для анонимных записей
  var (x, y) = (10, 20);
  print('Координаты: $x, $y');

  // 3. Деструктурирование мэпы (таблицы)
  Map<String, dynamic> user1 = {'name': 'Bob', 'age': 25, 'active': true};
  var {'name': userName, 'age': userAge} = user1;
  print('3. Имя: $userName, Возраст: $userAge');

  // С остатком (Dart не поддерживает ... в деструктуре Map напрямую)
  // Но можно вручную извлечь
  String nameFromMap = user['name'];
  int ageFromMap = user['age'];
  print('Извлечено: $nameFromMap, $ageFromMap');

  // 4. Деструктурирование экземпляра класса
  var person1 = Person('Charlie', 35, 'LA');
  var [pName, pAge, pCity] = person1.destructure();
  print('4. Имя: $pName, Возраст: $pAge, Город: $pCity');

  // Альтернатива — через геттеры
  String className = person.name;
  int classAge = person.age;
  print('Через геттеры: $className, $classAge');
}

// Класс для примера деструктурирования
class Person {
  final String name;
  final int age;
  final String city;

  Person(this.name, this.age, this.city);

  // Добавляем метод для деструктуризации
  List<Object?> destructure() => [name, age, city];
}

void learnBasicConstructions() {
  // if / else
  int score = 85;
  if (score >= 90) {
    print('Отлично!');
  } else if (score >= 75) {
    print('Хорошо');
  } else {
    print('Нужно подтянуть');
  }

  // Тернарный оператор
  String result = score >= 80 ? 'Прошёл' : 'Не прошёл';
  print('Результат: $result');

  // switch для int/string
  String grade = 'B';
  String description = switch (grade) {
    'A' => 'Отлично',
    'B' => 'Хорошо',
    'C' => 'Удовлетворительно',
    _ => 'Другое',
  };
  print('Оценка: $description');

  // switch с охранными выражениями
  int value = 10;
  String evenOrPositive = switch (value) {
    int n when n % 2 == 0 => 'чётное',
    int n when n > 0 => 'положительное нечётное',
    _ => 'другое',
  };
  print('Число: $evenOrPositive');

  // Цикл for (традиционный)
  for (int i = 0; i < 3; i++) {
    print('for: $i');
  }

  // for-in для итерируемых объектов
  List<String> items = ['a', 'b', 'c'];
  for (var item in items) {
    print('for-in: $item');
  }

  // while
  int counter = 3;
  while (counter > 0) {
    print('while: $counter');
    counter--;
  }

  // do-while (выполнится хотя бы раз)
  int x = 0;
  do {
    print('do-while: $x');
    x++;
  } while (x < 3);

  // break и continue
  for (int i = 0; i < 5; i++) {
    if (i == 1) continue; // Пропустить 1
    if (i == 3) break;    // Выйти при 3
    print('continue/break: $i');
  }

  // Метки для вложенных циклов
  outerLoop: for (int i = 0; i < 2; i++) {
    for (int j = 0; j < 3; j++) {
      if (i == 1 && j == 1) break outerLoop; // Выйти из внешнего
      print('i: $i, j: $j');
    }
  }

  // for с деструктуризацией (если список записей)
  List<(int, String)> data = [(1, 'один'), (2, 'два')];
  for (var (num, name) in data) {
    print('Деструкт: $num - $name');
  }

  // Оператор ?? возвращает левый операнд, если он не null, иначе правый
  String? nullableValue;
  String defaultValue = 'default';
  String result1 = nullableValue ?? defaultValue;
  print('Результат: $result1'); // Выведет 'default'

  // С правой стороны выражение выполняется только если левый null
  String expensive() {
    print('Выполняется дорогостоящая операция');
    return 'результат';
  }
  String? nullStr;
  String res2 = nullStr ?? expensive(); // Вызовется expensive()
  print('С дорогостоящим выражением: $res2');

  String? nonNullStr = 'уже есть';
  String res3 = nonNullStr ?? expensive(); // expensive() не вызывается
  print('Без вызова expensive: $res3');

  // С числами
  int? number;
  int fallback = 42;
  int finalNumber = number ?? fallback;
  print('Число: $finalNumber');

  // Цепочка ?? (справа налево)
  String? a, b;
  String c = 'финальное значение';
  String chain = a ?? b ?? c;
  print('Цепочка: $chain');

  // В отличие от ||, ?? работает только с null, а не с "ложными" значениями
  String? emptyStr = '';
  String? zeroNum = '0';
  bool? falseBool = false;

  print(emptyStr ?? 'пусто'); // ''
  print(zeroNum ?? 'другое'); // '0'
  print(falseBool ?? true);   // false
}
