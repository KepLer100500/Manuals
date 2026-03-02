def task():
    a = int(input())

    def task_():
        nonlocal a
        a += 10
        return a

    return task_()


def main():
    result = task()
    print(result)


if __name__ == '__main__':
    main()
