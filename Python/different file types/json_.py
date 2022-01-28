# -*- coding: utf-8 -*-
from json import dumps, loads


def write_to_file(file_name):
    dict_options = {'option1': 'anything',
                    'option2': 500, 'option3': 'Тыдыщ!'}      # Основа для json файла
    data = dumps(dict_options, ensure_ascii=False, indent=4)  # Сериализует словарь в json
    with open(file_name, 'w', encoding='utf-8') as file:      # Записать в файл
        file.write(data)


def read_from_file(file_name):
    with open(file_name, 'r', encoding='utf-8') as file:  # Открыть файл
        lines = ''.join(file.readlines())                 # Конвертировать в одну строку список строк из файла
        data = loads(lines)                               # Десериализовать из json в словарь
        print(data)
        for key in data:
            print(key, data[key], sep=' - ')


def main():
    file_name = 'test.json'
    write_to_file(file_name)
    read_from_file(file_name)


if __name__ == '__main__':
    main()
