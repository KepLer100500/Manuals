def task(a: str):
    return round(sum(len(word) for word in a.split(' ')) / len(a.split(' ')), 2)


def main():
    a = input()
    result = task(a)

    print(result)


if __name__ == '__main__':
    main()
