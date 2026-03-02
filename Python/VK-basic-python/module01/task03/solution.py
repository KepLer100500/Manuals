def task(values: list) -> bool:
    begin = values[0]
    end = values[1]
    return all(True if (end >= value >= begin) else False for value in values[2:])


def main():
    begin = int(input())
    end = int(input())
    values = [begin, end]

    while True:
        value = input()
        if not value:
            break
        else:
            values.append(int(value))

    result = task(values)

    print(result)


if __name__ == '__main__':
    main()
