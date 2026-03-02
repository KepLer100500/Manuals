def task(values: list) -> str:
    n = int(values[0])
    lines = [str(line).split(' ') for line in values[1:] if line != ';']
    result = []
    for line in lines[:n]:
        tmp_line = []
        for value in line:
            tmp_line.append(int(value))
        result.append(str(max(tmp_line)))

    return ';'.join(sorted(result))[::-1]


def main():
    values = []
    while True:
        value = input()
        if not value:
            break
        else:
            values.append(value)
            values.append(';')

    result = task(values)

    print(result)


if __name__ == '__main__':
    main()
