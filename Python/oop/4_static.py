class Point:
    __count = 0

    def __init__(self):
        Point.__count += 1

    @staticmethod
    def getCount():
        return Point.__count


def main():
    pt1 = Point()
    print(Point.getCount())
    pt2 = Point()
    print(Point.getCount())


if __name__ == '__main__':
    main()
