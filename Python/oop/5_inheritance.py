class Point:
    def __init__(self, x=0, y=0):
        self.__x = x
        self.__y = y

    def __str__(self):
        return f'({self.__x}, {self.__y})'


class Prop:
    def __init__(self, sp: Point, ep: Point, color: str = 'red', width: int = 1):
        self._sp = sp
        self._ep = ep
        self._color = color
        self.__width = width

    def getWidth(self):
        return self.__width


class Line(Prop):
    def __init__(self, *args):
        print('Class Line is redefine!')
        super().__init__(*args, 'green', 2)

    def drawLine(self):
        print(f'Drawing line: {self._sp} - {self._ep}, {self._color}, {self.getWidth()}')


class Rect(Prop):
    def drawRect(self):
        print(f'Drawing rectangle: {self._sp} - {self._ep}, {self._color}, {self.getWidth()}')


def main():
    line = Line(Point(0, 0), Point(10, 20))
    line.drawLine()
    rect = Rect(Point(1, 1), Point(11, 22))
    rect.drawRect()


if __name__ == '__main__':
    main()
