class Point:
    def __init__(self, x=0, y=0, z=500):
        self.__x = x  # set defalut value
        self.__y = y  # set default value
        self.__z = z  # here also call __setattr__ function!

    def __checkValue(a):
        # check, entered value is int or is float?
        return True if isinstance(a, int) or isinstance(a, float) else False

    def setCoords(self, x, y):
        # set entered values into private properties
        if Point.__checkValue(x) and Point.__checkValue(y):
            self.__x = x
            self.__y = y
        else:
            print('Incorrect values entered!!!')

    def getCoords(self):
        # getting values from private properties
        return self.__x, self.__y

    def setZ(self, z):
        self.__z = z

    def getZ(self):
        return self.__z

    def __getattribute__(self, name):
        # if i try to get self.__z - called this method
        if name == '_Point__z':
            return 'Attempt to GET value from variable __z!!!'
        else:
            return object.__getattribute__(self, name)

    def __setattr__(self, name, value):
        # if i try to set self.__z - called this method
        if name == '_Point__z':
            print('Attempt to SET value from variable __z!!!')
        else:
            self.__dict__[name] = value

    def __getattr__(self, name):
        # trying get non existent property
        return 'Variable ' + name + ' is not define in this class!!!'


def main():
    pt = Point()  # create object
    pt.setCoords(10, 30)  # getter
    print(pt.getCoords())  # setter
    pt.setCoords('20', 50)  # incorrect enter
    print(pt.getZ())  # overload __getattribute__ method
    print(pt._Point__z)  # another overload __getattribute__ method
    pt.setZ(100)  # overload __setattr__ method
    print(pt.www)  # trying get non existent property


if __name__ == '__main__':
    main()
