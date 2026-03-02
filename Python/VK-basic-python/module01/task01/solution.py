def task(a: str) -> str:
    return f"Hello, {a}"


def main():
    a = input()
    result = task(a)

    print(result)


if __name__ == '__main__':
    main()
