# -*- coding: utf-8 -*-

def write_to_file(file_name):
    with open(file_name, 'w', encoding='utf-8') as file:
        single_line = 'awesome text\n'
        list_of_strings = ['Один', 'Два', 'Три']
        file.write(single_line)
        file.writelines(word + '\n' for word in list_of_strings)


def read_from_file(file_name):
    with open(file_name, 'r', encoding='utf-8') as file:
        for line in file:
            print(line, end='')
        print(file.readlines())


def main():
    file_name = 'test.txt'
    write_to_file(file_name)
    read_from_file(file_name)


if __name__ == '__main__':
    main()
