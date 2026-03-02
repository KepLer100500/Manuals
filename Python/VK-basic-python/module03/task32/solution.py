class Rectangle:
    def __init__(self, a, b):
        self.a = a
        self.b = b

    def calculate_area(self):
        return self.a * self.b


class Square(Rectangle):
    def __init__(self, a):
        super().__init__(a, a)


class CalculatePerimeterMixin(Rectangle):
    def calculate_perimeter(self):
        return self.a * 2 + self.b * 2


class SquareWithMixin(CalculatePerimeterMixin, Square):
    def __eq__(self, other):
        return self.a == other.a and self.b == other.b

    def __gt__(self, other):
        return self.calculate_area() > other.calculate_area()

    def __add__(self, other):
        return self.calculate_area() + other.calculate_area()


def main():
    code = []
    while data := input():
        code.append(data)
    code = "\n".join(code)
    exec(code)


if __name__ == "__main__":
    main()

'''
square_with_mixin1 = SquareWithMixin(3)
square_with_mixin2 = SquareWithMixin(2)
print(square_with_mixin1.calculate_area())
print(square_with_mixin1.calculate_perimeter())
print(square_with_mixin1 == square_with_mixin1)
print(square_with_mixin1 == square_with_mixin2)
print(square_with_mixin1 > square_with_mixin2)
print(square_with_mixin1 > square_with_mixin1)
print(square_with_mixin1 + square_with_mixin1)
'''
