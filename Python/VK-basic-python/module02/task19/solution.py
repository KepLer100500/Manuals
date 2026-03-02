def repeat_deco(n=1):
    def func_deco(func):
        def wrapper(*args, **kwargs):
            for i in range(n):
                func(*args, **kwargs)

        return wrapper

    return func_deco


def main():
    code = []
    while data := input():
        code.append(data)
    code = "\n".join(code)
    exec(code)


if __name__ == '__main__':
    main()

'''
@repeat_deco(4)
def hello():
    print("hello")
hello()
'''
