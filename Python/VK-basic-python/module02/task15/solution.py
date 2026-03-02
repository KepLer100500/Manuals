cache_fib = {}


def task(n: int) -> int:
    if n <= 2:
        return 1

    if n in cache_fib:
        return cache_fib[n]
    else:
        cache_fib[n] = task(n - 1) + task(n - 2)
        return cache_fib[n]


def main():
    n = input()
    result = task(int(n))
    print(result)


if __name__ == '__main__':
    main()
