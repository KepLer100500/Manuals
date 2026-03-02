from re import sub


def task(line: str) -> str:
    return sub('[!@#%]', '', line).lower() if line[0] != '!' else sub('[!@#%]', '', line).upper()


def main():
    while True:
        line = input()
        if not line:
            break
        else:
            print(task(line))


if __name__ == '__main__':
    main()
