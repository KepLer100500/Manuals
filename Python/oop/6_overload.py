class Point:
    def __init__(self, x=0, y=0):
        self.__x = x
        self.__y = y

    def __str__(self):
        return f'({self.__x}, {self.__y})'

    def isInt(self):
        if isinstance(self.__x, int) and isinstance(self.__y, int):
            return True
        else:
            return False

    def isDigit(self):
        if isinstance(self.__x, int) or isinstance(self.__x, float) and \
                isinstance(self.__y, int) or isinstance(self.__y, float):
            return True
        else:
            return False


class Prop:
    def __init__(self, sp: Point, ep: Point, color: str = 'red', width: int = 1):
        self._sp = sp
        self._ep = ep
        self._color = color
        self.__width = width

    def getWidth(self):
        return self.__width

    def setCoords(self, sp, ep):
        if sp.isDigit() and ep.isDigit():
            self._sp = sp
            self._ep = ep
        else:
            print('Entered non digit values!')


class Line(Prop):
    def __init__(self, *args):
        super().__init__(*args, 'green', 5)  # redefine

    def drawLine(self):
        print(f'Drawing line: {self._sp} - {self._ep}, {self._color}, {self.getWidth()}')

    def __settingOnePoint(self, sp: Point):
        if sp.isInt():
            self._sp = sp
        else:
            print('Entered non integer values')

    def __settingTwoPoint(self, sp: Point, ep: Point):
        if sp.isInt() and ep.isInt():
            Prop.setCoords(self, sp, ep)
        else:
            print('Entered non integer values')

    def setCoords(self, sp: Point, ep: Point = None):
        if ep is None:
            self.__settingOnePoint(sp)
        else:
            self.__settingTwoPoint(sp, ep)


def main():
    line = Line(Point(1, 1), Point(10, 20))
    line.drawLine()
    line.setCoords(Point(5.0, 5), Point(100, 200))
    line.drawLine()
    line.setCoords(Point(5, 5), Point(100, 200))
    line.drawLine()
    line.setCoords(Point(0, 0))
    line.drawLine()


if __name__ == '__main__':
    main()
