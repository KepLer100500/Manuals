# -*- coding: utf-8 -*-
import configparser as cp


def write_to_file(file_name):
    config = cp.ConfigParser()
    config['section1'] = {'config1': 'one',
                          'config2': 'two'}
    config['section2'] = {}
    config['section2']['awesome'] = 'Вот так!'
    with open(file_name, 'w', encoding='utf-8') as file:
        config.write(file)


def read_from_file(file_name):
    config = cp.ConfigParser()
    config.read(file_name, encoding='utf-8')
    print(config.sections())
    for key in config['section1']:
        print(key, '=', config['section1'][key])
    print(config['section2']['awesome'])


def main():
    file_name = 'test.ini'
    write_to_file(file_name)
    read_from_file(file_name)


if __name__ == '__main__':
    main()
