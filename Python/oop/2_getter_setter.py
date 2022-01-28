class Point:
    def __init__(self, x=0, y=0):
        self.__x = x
        self.__y = y

    def __checkValue(value):
        return True if isinstance(value, int) else False

    def __getCoordX(self):
        return self.__x

    def __setCoordX(self, x):
        if Point.__checkValue(x):
            self.__x = x
        else:
            print('Entered non int value')

    def __delCoordX(self):
        print('Coord X is deleted')
        del self.__x

    coordX = property(__getCoordX, __setCoordX, __delCoordX)

    @property
    def coordY(self):
        return self.__y

    @coordY.setter
    def coordY(self, y):
        if Point.__checkValue(y):
            self.__y = y
        else:
            print('Entered non int value')

    @coordY.deleter
    def coordY(self):
        print('Coord Y is deleted')
        del self.__y


def main():
    pt = Point(500, 300)
    print(pt.coordX)
    pt.coordX = 100
    print(pt.coordX)
    del pt.coordX

    print(pt.coordY)
    pt.coordY = 200
    print(pt.coordY)
    del pt.coordY


if __name__ == '__main__':
    main()
