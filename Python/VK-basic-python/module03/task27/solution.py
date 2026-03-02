class Pendulum:
    g = 10
    pi = 3.14

    @classmethod
    def calculate_period(cls, length):
        return 2 * cls.pi * (length / cls.g) ** 0.5


def main():
    code = []
    while data := input():
        code.append(data)
    code = "\n".join(code)
    exec(code)


if __name__ == "__main__":
    main()

'''
print(Pendulum.calculate_period(10))
'''
