import 'dart:convert';
import 'dart:io';

void learnNumbers() {
  // int: целые числа
  int age = 25;
  int hexValue = 0xFF;        // Шестнадцатеричный литерал
  int binaryValue = int.parse('1010', radix: 2); // Бинарный как строка
  int octalValue = int.parse('777', radix: 8);   // Восьмеричный как строка
  print('age: $age, hex: $hexValue, bin: $binaryValue, oct: $octalValue');

  // Операции с int
  int sum = 10 + 5;
  int diff = 10 - 3;
  int product = 7 * 8;
  int divInt = 15 ~/ 4;       // Целочисленное деление
  int remainder = 15 % 4;     // Остаток от деления
  print('Сумма: $sum, Разность: $diff, Произведение: $product');
  print('Цел. деление: $divInt, Остаток: $remainder');

  // double: числа с плавающей точкой
  double price = 19.99;
  double scientific = 1.23e-4; // Экспоненциальная запись
  print('Цена: $price, Научная запись: $scientific');

  // Операции с double
  double result = 3.5 + 2.1;
  double division = 10.0 / 3.0;
  print('Сложение double: $result, Деление: $division');

  // num: родительский тип для int и double
  num n = 42;     // Может быть int
  n = 3.14;       // А потом double
  print('num как int: ${n is int}, как double: ${n is double}');

  // Преобразования
  int fromDouble = result.toInt(); // double -> int
  double fromInt = age.toDouble(); // int -> double
  String strNum = age.toString();  // int -> String
  print('double к int: $fromDouble, int к double: $fromInt, int к строке: $strNum');

  // Проверки
  bool isFinite = price.isFinite;   // Проверка на конечность
  bool isNaN = (0.0 / 0.0).isNaN;   // Проверка на NaN
  print('Конечное ли число: $isFinite, NaN ли: $isNaN');

  // Константы
  print('Максимальный int: ${9223372036854775807}');
  print('Минимальный int: ${-9223372036854775808}');
  print('double.infinity: ${double.infinity}');
  print('double.nan: ${double.nan}');
}

void learnStrings() {
  // Объявление строк
  String s1 = 'Простая строка';
  String s2 = "Строка в двойных кавычках";
  String s3 = 'Эsc\'ape'; // Экранирование
  String s4 = "Экранирование \"кавычек\"";
  print('$s1, $s2, $s3, $s4');

  // Многострочные строки
  String multiline = '''
Это
многострочная
строка
''';
  print(multiline);

  // Интерполяция (вставка значений)
  int age = 25;
  String name = 'Alice';
  String greeting = 'Привет, $name! Тебе $age лет.';
  print(greeting);

  // Интерполяция выражений
  String expr = 'Результат 2 + 3 = ${2 + 3}';
  print(expr);

  // Конкатенация
  String concat = 'Hello, ' + 'World!';
  print(concat);

  // Основные методы строк
  String text = '  Dart Programming  ';
  print(text.length);           // Длина
  print(text.toLowerCase());    // В нижний регистр
  print(text.toUpperCase());    // В верхний регистр
  print(text.trim());           // Удалить пробелы по краям
  print(text.startsWith('  D')); // Начинается с
  print(text.endsWith('  '));   // Заканчивается на
  print(text.contains('Pro'));  // Содержит подстроку

  // Получение подстроки
  print(text.substring(2, 6));  // Символы с 2 по 6 (не включая)

  // Разделение строки
  List<String> parts = 'one,two,three'.split(',');
  print(parts); // ['one', 'two', 'three']

  // Проверки
  bool isEmpty = ''.isEmpty;
  bool isNotEmpty = 'text'.isNotEmpty;
  print('Пустая строка: $isEmpty, Не пустая: $isNotEmpty');

  // Работа с символами ( runes )
  String emoji = ' Dart 🚀 ';
  print(emoji.runes.toList()); // Коды символов
  print(emoji.trim());         // Убираем пробелы, включая эмодзи-пробелы
}

void learnBooleans() {
  // Объявление логических значений
  bool isActive = true;
  bool isComplete = false;
  print('isActive: $isActive, isComplete: $isComplete');

  // Операторы сравнения (возвращают bool)
  int a = 10, b = 20;
  print('a > b: ${a > b}');       // false
  print('a <= b: ${a <= b}');     // true
  print('a == b: ${a == b}');     // false
  print('a != b: ${a != b}');     // true

  // Логические операторы
  bool x = true, y = false;
  print('x && y: ${x && y}');     // false (И)
  print('x || y: ${x || y}');     // true (ИЛИ)
  print('!x: ${!x}');             // false (НЕ)

  // Преобразование в bool
  bool fromString = 'non-empty'.isNotEmpty; // true
  bool fromInt = (5 > 0);                   // true
  print('Строка не пустая: $fromString, 5 > 0: $fromInt');

  // Условия в if, while и т.д.
  if (isActive && !isComplete) {
    print('Активен, но не завершён');
  }

  // Проверка на null (до null-safety было важно)
  String? nullableStr;
  bool isNull = nullableStr == null;
  print('Строка null: $isNull');

  // Оператор "если null, то" (??) в сочетании с bool
  bool? maybeBool;
  bool definiteBool = maybeBool ?? false; // Если null, то false
  print('Определённый bool: $definiteBool');
}

void learnLists() {
  // Создание списков
  List<int> numbers = [1, 2, 3, 4, 5];           // Типизированный список
  var fruits = <String>['apple', 'banana'];      // Вывод типа через var
  var dynamicList = [1, 'text', true];           // Список с разными типами (dynamic)
  print('numbers: $numbers, fruits: $fruits, dynamic: $dynamicList');

  // Пустые списки
  List<String> emptyList1 = [];                  // Пустой изменяемый
  var emptyList2 = <int>[];                      // Пустой с выводом типа
  print('Пустые: $emptyList1, $emptyList2');

  // Доступ к элементам
  print('Первый: ${numbers[0]}, Последний: ${numbers.last}');
  print('Длина: ${numbers.length}, Пустой ли: ${emptyList1.isEmpty}');

  // Изменение списка
  numbers[0] = 100;                              // Изменить по индексу
  numbers.add(6);                                // Добавить элемент
  numbers.addAll([7, 8]);                        // Добавить несколько
  print('После изменений: $numbers');

  // Вставка и удаление
  numbers.insert(1, 99);                         // Вставить по индексу
  numbers.removeAt(0);                           // Удалить по индексу
  numbers.removeWhere((item) => item > 4);       // Удалить по условию
  print('После вставки и удалений: $numbers');

  // Перебор
  for (var item in numbers) {
    print('Элемент: $item');
  }

  // Фильтрация, отображение и т.д.
  var doubled = numbers.map((e) => e * 2).toList(); // Удвоить все
  var evens = numbers.where((e) => e % 2 == 0).toList(); // Только чётные
  print('Удвоенные: $doubled, Чётные: $evens');

  // Проверки
  bool hasThree = numbers.contains(3);
  int index = numbers.indexOf(4);
  print('Есть 3? $hasThree, Индекс 4: $index');

  // Подсписки
  var subList = numbers.sublist(1, 3);           // С 1 по 3 (не включая)
  print('Подсписок: $subList');

  // Константный список (неизменяемый)
  const constList = [1, 2, 3];                  // Время компиляции
  // constList.add(4); // Ошибка! Нельзя изменить
  print('Константный: $constList');

  // Фиксированный размер
  var fixedList = List.filled(3, 0, growable: false); // [0, 0, 0], не растёт
  print('Фиксированный: $fixedList');
}

void learnRecords() {
  // Объявление и инициализация анонимной записи (record)
  var person = ('Alice', 25); // (String, int)
  print(person); // Вывод: (Alice, 25)

  // Обращение к элементам записи по индексу
  print(person.$1); // Первый элемент: Alice
  print(person.$2); // Второй элемент: 25

  // Именованные записи (named record)
  var personNamed = (name: 'Bob', age: 30); // (String name, int age)
  print(personNamed); // Вывод: (name: Bob, age: 30)

  // Обращение к элементам записи по имени
  print(personNamed.name); // Bob
  print(personNamed.age);  // 30

  // Деструктуризация (разбор) записи на переменные
  var (name, age) = person;
  print('Имя: $name, Возраст: $age');

  // Деструктуризация с именованными полями
  var (name: firstName, age: years) = personNamed;
  print('Имя: $firstName, Возраст: $years');

  // Вложенные записи
  var location = (city: 'Moscow', coords: (x: 37.6173, y: 55.7558));
  print(location.coords.x); // 37.6173

  // Возврат именованной записи из функции
  var result = getUserInfoNamed();
  print(result.name); // Charlie
  print(result.id);   // 12345

  // Использование именованных записей в типах
  String describeUser(({String name, int id}) userInfo) {
    return 'Пользователь: ${userInfo.name}, ID: ${userInfo.id}';
  }

  print(describeUser(result));
}

// Функция, возвращающая именованную запись
({String name, int id}) getUserInfoNamed() {
  return (name: 'Charlie', id: 12345);
}

void learnSets() {
  // Создание множеств
  Set<String> tags = {'dart', 'flutter', 'mobile'}; // Типизированное множество
  var uniqueNumbers = <int>{1, 2, 3, 2, 1};        // Вывод типа через var
  var dynamicSet = {1, 'text', true};               // dynamic
  print('tags: $tags, uniqueNumbers: $uniqueNumbers, dynamic: $dynamicSet');

  // Пустое множество
  Set<String> emptySet = <String>{};                // Явное указание типа
  var anotherEmpty = <int>{};                       // Вывод типа
  print('Пустые: $emptySet, $anotherEmpty');

  // Добавление элементов
  tags.add('web');                                  // Один элемент
  tags.addAll({'backend', 'mobile'});               // Несколько (повторы игнорируются)
  print('После добавления: $tags');

  // Проверки
  print('Размер: ${tags.length}, Пустое ли: ${emptySet.isEmpty}');
  bool hasDart = tags.contains('dart');
  print('Есть dart? $hasDart');

  // Удаление
  tags.remove('mobile');                            // Удалить один
  print('После удаления mobile: $tags');

  // Перебор
  for (var tag in tags) {
    print('Тег: $tag');
  }

  // Операции над множествами
  Set<int> setA = {1, 2, 3};
  Set<int> setB = {3, 4, 5};

  Set<int> union = setA.union(setB);                // Объединение
  Set<int> intersection = setA.intersection(setB);  // Пересечение
  Set<int> difference = setA.difference(setB);      // Разность (A - B)
  print('Объединение: $union, Пересечение: $intersection, Разность: $difference');

  // Проверки множеств (вручную, т.к. методов нет)
  bool isSubset = {1, 2}.every(setA.contains);      // Все ли элементы {1,2} в setA?
  bool isSuperset = setA.every({1}.contains);       // Все ли элементы {1} в setA?
  print('1,2 подмножество A? $isSubset, A надмножество для {1}? $isSuperset');

  // Конвертация
  List<int> listFromSet = setA.toList();            // В список
  Set<int> setFromList = [1, 2, 2, 3].toSet();      // Из списка (убирает дубликаты)
  print('Сет в лист: $listFromSet, Лист в сет: $setFromList');

  // Константное множество
  const constSet = {'a', 'b'};                      // Неизменяемое
  print('Константное: $constSet');
}

void learnMaps() {
  // Создание таблиц (Map)
  Map<String, int> ages = {'Alice': 25, 'Bob': 30}; // Типизированная
  var capitals = <String, String>{'Russia': 'Moscow', 'France': 'Paris'}; // Вывод типа
  var dynamicMap = {'key1': 1, 'key2': 'text', 3: true}; // dynamic
  print('ages: $ages, capitals: $capitals, dynamic: $dynamicMap');

  // Пустая таблица
  Map<String, int> emptyMap = <String, int>{};      // Явное указание типа
  var anotherEmpty = <int, String>{};               // Вывод типа
  print('Пустые: $emptyMap, $anotherEmpty');

  // Доступ к значениям
  print('Возраст Alice: ${ages['Alice']}');         // По ключу
  print('Неизвестный ключ: ${ages['Unknown'] ?? 'Нет в словаре'}'); // С дефолтом

  // Добавление и изменение
  ages['Charlie'] = 35;                             // Новая пара
  ages['Alice'] = 26;                               // Изменить значение
  ages.addAll({'David': 40, 'Eve': 28});            // Добавить несколько
  print('После добавлений: $ages');

  // Проверки
  print('Размер: ${ages.length}, Пустая ли: ${emptyMap.isEmpty}');
  bool hasBob = ages.containsKey('Bob');
  bool hasAge = ages.containsValue(30);
  print('Есть Bob? $hasBob, Есть возраст 30? $hasAge');

  // Удаление
  ages.remove('Bob');                               // По ключу
  print('После удаления Bob: $ages');

  // Перебор
  ages.forEach((key, value) => print('$key: $value')); // forEach
  for (var entry in ages.entries) {                 // Перебор Entry
    print('${entry.key} => ${entry.value}');
  }

  // Получение ключей и значений
  var keys = ages.keys;                             // Iterable по ключам
  var values = ages.values;                         // Iterable по значениям
  print('Ключи: $keys, Значения: $values');

  // Преобразования
  var doubledAges = Map.fromEntries(                 // Изменить значения
      ages.entries.map((e) => MapEntry(e.key, e.value * 2))
  );
  print('Удвоенные возрасты: $doubledAges');

  // Условное добавление
  ages.putIfAbsent('Frank', () => 22);              // Добавить, если нет
  print('После putIfAbsent: $ages');

  // Константная таблица
  const constMap = {'a': 1, 'b': 2};                // Неизменяемая
  print('Константная: $constMap');
}

void learnRunesSymbols() {
  // Runes — представление Unicode-символов (ранее использовалось для эмодзи и др.)
  // В Dart 2.0+ строки используют UTF-16, но Runes позволяют работать с кодами
  String emoji = 'dart 🚀';
  print('Строка: $emoji');
  print('Коды (Runes): ${emoji.runes.toList()}'); // Список кодов символов

  // Создание строки из кодов
  Runes inputRunes = Runes(r'Hello \u{1F680}'); // \u{1F680} — код ракеты
  print('Строка из кодов: ${String.fromCharCodes(inputRunes)}');

  // Пример с эмодзи
  String flag = '🇩🇪'; // Флаг Германии (состоит из двух кодов)
  print('Флаг: $flag, Кодов: ${flag.runes.length}');

  // Symbols — неизменяемые имена, используются редко, например, в рефлексии (ранее)
  Symbol symbol = #someIdentifier; // Символ из литерала
  print('Symbol: $symbol');

  // Преобразование строки в Symbol
  Symbol stringToSymbol = Symbol('anotherIdentifier');
  print('String to Symbol: $stringToSymbol');

  // Сравнение Symbol'ов
  print('Сравнение: ${#test == Symbol("test")}'); // true

  // Важно: Symbols не используются в обычной разработке, в отличие от Runes
}

void learnFinalConstLate() {
  // final — значение устанавливается при создании и не меняется (динамическая константа)
  final DateTime now = DateTime.now(); // Вычисляется при выполнении
  final List<int> numbers = [1, 2, 3];
  // now = DateTime.now(); // Ошибка! final
  numbers.add(4); // OK! Объект изменяем, но ссылка final
  print('final now: $now, numbers: $numbers');

  // const — значение вычисляется на этапе компиляции (статическая константа)
  const int maxUsers = 100; // Известно на этапе компиляции
  const List<int> constNumbers = [1, 2, 3]; // Неизменяемый список
  // constNumbers.add(4); // Ошибка! const список
  print('const maxUsers: $maxUsers, constNumbers: $constNumbers');

  // late — отложенная инициализация
  late String description; // Объявлена, но не инициализирована
  description = 'Описание после инициализации'; // Теперь инициализирована
  print('late description: $description');

  // late final — отложенная инициализация + неизменяемость
  late final String expensiveValue = computeExpensiveValue();
  print('late final: $expensiveValue');

  // late const — невозможно, т.к. const вычисляется на этапе компиляции
  // late const int x = 5; // Ошибка!

  // Пример с null-safe и late
  late String? nullableValue; // Может быть null, но инициализируется позже
  nullableValue = 'assigned later';
  print('late nullable: $nullableValue');
}

String computeExpensiveValue() {
  print('Вычисление дорогостоящего значения...');
  return 'Результат';
}

void learnNullSafety() {
  // Обычная переменная не может быть null
  String name = 'Alice';
  // name = null; // Ошибка! Переменная не может быть null

  // Переменная, допускающая null
  String? nullableName;
  print('nullableName: $nullableName'); // null

  // Присвоение значения
  nullableName = 'Bob';
  print('nullableName после присвоения: $nullableName');

  // Условие для null
  if (nullableName != null) {
    print('Длина имени: ${nullableName.length}');
  }

  // Оператор ! (принудительно не null)
  String? str = 'Hello';
  int len = str!.length; // Говорим компилятору: "я уверен, что str не null"
  print('Длина: $len');

  // Оператор ?? (если null, то...)
  String? input;
  String output = input ?? 'default';
  print('Выход: $output');

  // Оператор ??=
  String? config;
  config ??= 'значение по умолчанию';
  print('Config: $config');

  // Оператор условного доступа ?.
  String? address;
  int? length = address?.length; // Если address null, то length тоже null
  print('Длина адреса: $length');

  // Работа с коллекциями
  List<String>? names;
  int? count = names?.length; // null, т.к. names null
  print('Количество имён: $count');

  // Функция, возвращающая null
  String? findName(int id) {
    if (id == 1) return 'Alice';
    return null;
  }

  String? result = findName(2);
  if (result != null) {
    print('Найденное имя: $result');
  } else {
    print('Имя не найдено');
  }

  // Проверка и приведение
  dynamic value = 'some string';
  String? strValue = value as String?; // Приведение с возможностью null
  print('Приведённое значение: $strValue');
}

void learnDynamicVsObject() {
  // dynamic — отключение статической проверки типов
  dynamic dyn = 'строка';
  print(dyn.toUpperCase()); // OK: строка
  dyn = 123;
  print(dyn.isEven);        // OK: число
  dyn = true;
  print(dyn.runtimeType);   // bool

  // Object — базовый класс, но тип всё равно проверяется на этапе компиляции
  Object obj = 'строка';
  // obj.toUpperCase(); // Ошибка компиляции! Object не имеет toUpperCase
  String str = obj as String; // Явное приведение
  print(str.toUpperCase());   // OK

  // Object может хранить любой тип
  Object objNum = 42;
  Object objBool = true;
  print('Число: $objNum, Булево: $objBool');

  // dynamic позволяет вызывать любые методы (ошибка в рантайме, если нет)
  dynamic dyn2 = 'hello';
  // print(dyn2.anyMethod()); // Ошибка в рантайме: метода нет

  // Object — неизменяемый тип в момент присвоения
  Object fixedObj = 42;
  // fixedObj = fixedObj.toLowerCase(); // Ошибка компиляции

  // Когда использовать:
  // dynamic — когда тип неизвестен и нужно отключить проверки (редко)
  // Object — когда нужен общий тип, но хочется явного приведения
}

void learnKeyboardRead() async {
  // Чтение всей строки до символа перевода строки
  stdout.write('Введите имя: ');
  String? name = stdin.readLineSync(); // Синхронное чтение
  print('Привет, $name!');

  // Преобразование строки в число
  stdout.write('Введите возраст: ');
  String? ageInput = stdin.readLineSync();
  int? age = int.tryParse(ageInput ?? ''); // Безопасное преобразование
  if (age != null) {
    print('Вам $age лет.');
  } else {
    print('Некорректный ввод возраста.');
  }

  // Чтение одного символа (например, подтверждение)
  stdout.write('Продолжить? (y/n): ');
  String? choice = stdin.readLineSync()?.toLowerCase();
  if (choice == 'y') {
    print('Продолжаем!');
  } else {
    print('Выход.');
  }

  // Чтение с клавиатуры в цикле (ожидание ввода)
  stdout.write('Введите числа через пробел: ');
  String? numbersLine = stdin.readLineSync();
  if (numbersLine != null) {
    List<int> numbers = numbersLine
        .split(' ')
        .map((s) => int.tryParse(s))
        .where((n) => n != null)
        .cast<int>()
        .toList();
    print('Числа: $numbers');
  }

  // Асинхронное чтение (для более сложных сценариев)
  print('Асинхронное чтение (введите что-нибудь и нажмите Enter):');
  stdin.transform(Utf8Decoder()).listen((data) {
    print('Получено: $data');
  });

  // Для завершения асинхронного примера (иначе программа не завершится)
  await Future.delayed(Duration(seconds: 2));
}