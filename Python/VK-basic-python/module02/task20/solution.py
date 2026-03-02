a = 0


def task() -> int:
    global a
    a += 10
    return a


def main():
    global a
    a = int(input())
    result = task()
    print(result)


if __name__ == '__main__':
    main()
