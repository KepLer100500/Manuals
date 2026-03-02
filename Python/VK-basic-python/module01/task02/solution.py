def task(a: str, b: str) -> str:
    return f"Current location is {a} and time is {b}"


def main():
    a = input()
    b = input()
    result = task(a, b)

    print(result)


if __name__ == '__main__':
    main()
