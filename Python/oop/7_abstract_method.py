class Point:
    def __init__(self, x=0, y=0):
        self.__x = x
        self.__y = y

    def __str__(self):
        return f'({self.__x}, {self.__y})'


class Prop:
    def __init__(self, sp, ep):
        self._sp = sp
        self._ep = ep

    def draw(self):
        print('Method not redefine!!!')


class Line(Prop):
    def draw(self):
        print(f'Draw line: {self._sp} - {self._ep}')


class Rect(Prop):
    def draw(self):
        print(f'Draw rectangle: {self._sp} - {self._ep}')


class Ellipse(Prop):
    pass
    # def draw(self):
    #    print(f'Draw ellipse: {self._sp} - {self._ep}')


def main():
    figures = []
    figures.append(Line(Point(0, 0), Point(3, 3)))
    figures.append(Rect(Point(20, 20), Point(50, 50)))
    figures.append(Ellipse(Point(100, 100), Point(200, 200)))
    for figure in figures:
        figure.draw()


if __name__ == '__main__':
    main()
