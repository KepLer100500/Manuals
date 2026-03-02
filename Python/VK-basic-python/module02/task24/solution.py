def cache_deco(func):
    cache = {}

    def wrapper(*args):
        if args not in cache:
            cache[args] = func(*args)
        return cache[args]

    return wrapper


def solution(func_map, func_filter, data):
    filtered = (x for x in data if func_filter(x))
    mapped = (func_map(x) for x in filtered)
    index = 0
    for item in mapped:
        if index % 2 == 0:
            yield item
        index += 1


def main():
    def calc():
        count = 0

        @cache_deco
        def calc_(x):
            nonlocal count
            count += 1
            print("Call:", count)
            return x

        return calc_

    for i in solution(calc(), lambda x: x % 2 == 1, (1, 1, 2, 2, 2, 3, 1, 2, 3, 1)):
        print(i)


if __name__ == "__main__":
    main()
