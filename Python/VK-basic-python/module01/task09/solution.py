def task(a: str) -> str:
    return ' '.join(sorted(set(a.lower()))).strip()


def main():
    a = input()
    result = task(a)

    print(result)


if __name__ == '__main__':
    main()
