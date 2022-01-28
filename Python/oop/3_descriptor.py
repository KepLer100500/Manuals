class CoordValue:
    def __checkValue(value):
        return True if isinstance(value, int) else False

    def __set_name__(self, owner, name):
        self.__name = name

    def __get__(self, instance, owner):
        return instance.__dict__[self.__name]

    def __set__(self, instance, value):
        if CoordValue.__checkValue(value):
            instance.__dict__[self.__name] = value
        else:
            print('Entered non int value')

    def __delete__(self, instance):
        print('Coord ' + self.__name + ' is deleted')
        del instance.__dict__[self.__name]


class Point:
    coordX = CoordValue()
    coordY = CoordValue()

    def __init__(self, x=0, y=0):
        self.coordX = x
        self.coordY = y


def main():
    pt = Point(1, 2)
    pt.coordX = '333'
    print(pt.coordX)
    del pt.coordX

    pt.coordY = 500
    print(pt.coordY)
    del pt.coordY


if __name__ == '__main__':
    main()
