class Circle:
    pi = 3.14

    def calculate_area(self, radius):
        return self.pi *radius ** 2


def main():
    code = []
    while data := input():
        code.append(data)
    code = "\n".join(code)
    exec(code)


if __name__ == "__main__":
    main()

'''
circle = Circle()
print(circle.calculate_area(2))
'''
