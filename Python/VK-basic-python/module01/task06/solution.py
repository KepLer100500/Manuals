import re


def task(a):
    counter = len(re.findall('[!@#%]', a))
    clean_string = re.sub('[!@#%]', '', a.lower())

    return counter, clean_string


def main():
    a = input()
    count, result = task(a)
    print(count)
    print(result)


if __name__ == '__main__':
    main()
