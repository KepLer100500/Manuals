cache_fib = {}


def cache_deco(func):
    def wrapper(n):

        if n in cache_fib:
            return cache_fib[n]
        else:
            cache_fib[n] = func(n)
        return cache_fib[n]

    return wrapper


if __name__ == "__main__":
    code = []
    while data := input():
        code.append(data)
    code = "\n".join(code)
    exec(code)

'''
@cache_deco
def fib(k):
    if k <= 2:
        return 1
    return fib(k - 1) + fib(k - 2)
print(fib(300))
'''