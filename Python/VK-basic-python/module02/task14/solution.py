def task(start: int, end: int, step: int) -> map:
    return map(lambda x: x ** 2 if x % 2 == 1 else -x, range(start, end, step))


def main():
    start, end, step = input().split()
    result = task(int(start), int(end), int(step))
    for n in result:
        print(n)


if __name__ == '__main__':
    main()
