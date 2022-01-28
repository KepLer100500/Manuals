class Point:
    def __init__(self, x=0, y=0):
        self.__x = x
        self.__y = y

    def __str__(self):
        return f'({self.__x}, {self.__y})'


class Pos:
    def __init__(self):
        self._sp = Point(10, 20)
        self._ep = Point(30, 40)
        super().__init__()


class Styles:
    def __init__(self):
        self._color = 'red'
        self._width = 1
        super().__init__()


class Line(Pos, Styles):
    def __init__(self):
        super().__init__()

    def draw(self):
        print(f'Drawing line: {self._sp}, {self._ep}, {self._color}, {self._width}')


def main():
    line = Line()
    line.draw()
    print(Line.__mro__)


if __name__ == '__main__':
    main()
