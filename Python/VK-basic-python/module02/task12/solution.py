def task(line: str) -> float:
    return round(sum([int(value) for value in line.split()]) / len(line.split()), 2)


def main():
    while True:
        line = input()
        if not line:
            break
        else:
            print(task(line))


if __name__ == '__main__':
    main()
