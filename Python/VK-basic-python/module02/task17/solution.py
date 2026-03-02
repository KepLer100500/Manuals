def task(func_in: callable, seq_in: iter) -> iter:
    for i in seq_in:
        if func_in(i):
            yield i


def main():
    func_in, seq_in = eval(input()), eval(input())
    for n in task(func_in, seq_in):
        print(n)


if __name__ == '__main__':
    main()
