def task(a: str) -> str:
    counter = {}
    for word in a.lower().split():
        if not counter.get(word):
            counter[word] = 1
        else:
            counter[word] = counter[word] + 1

    max_key = ''
    max_value = 0
    for key, value in counter.items():
        if value > max_value:
            max_value = value
            max_key = key

    return f'{max_key} {max_value}'


def main():
    a = input()
    result = task(a)

    print(result)


if __name__ == '__main__':
    main()
