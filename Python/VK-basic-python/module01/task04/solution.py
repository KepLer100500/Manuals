def task(value):
    value = value.lower()
    return ("a" in value or "o" in value) and "i" not in value and "e" not in value


def main():
    a = input()
    result = task(a)
    print(result)


if __name__ == '__main__':
    main()
