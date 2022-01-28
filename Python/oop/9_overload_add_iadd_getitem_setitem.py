class Clock:
    __DAY = 86400

    def __init__(self, secs: int):
        if not isinstance(secs, int):
            raise ValueError('Incorrect input, seconds must be integer value!')

        self.__secs = secs % self.__DAY

    def get_seconds(self):
        return self.__secs

    def get_format_time(self):
        s = self.__secs % 60
        m = (self.__secs // 60) % 60
        h = (self.__secs // 3600) % 24
        return f"{Clock.__get_form(h)}:{Clock.__get_form(m)}:{Clock.__get_form(s)}"

    @staticmethod
    def __get_form(val):
        return str(val) if val > 9 else ''.join(('0', str(val)))

    def __add__(self, other):
        if not isinstance(other, Clock):
            raise ArithmeticError('Incorrect input type!')

        return Clock(self.__secs + other.get_seconds())

    def __iadd__(self, other):
        if not isinstance(other, Clock):
            raise ArithmeticError('Incorrect input type!')

        self.__secs += other.get_seconds()
        return self

    def __eq__(self, other):
        return self.__secs == other.get_seconds()

    def __ne__(self, other):
        return not self.__eq__(other)

    def __getitem__(self, item):
        if not isinstance(item, str):
            raise ValueError('Key must be string value!')

        if item == 'hour':
            return (self.__secs // 3600) % 24
        elif item == 'min':
            return (self.__secs // 60) % 60
        elif item == 'sec':
            return self.__secs % 60

        return 'Incorrect key!'

    def __setitem__(self, key, value):
        if not isinstance(key, str):
            raise ValueError('Key must be string value!')

        if not isinstance(value, int):
            raise ValueError('Value must be integer value!')

        s = self.__secs % 60
        m = (self.__secs // 60) % 60
        h = (self.__secs // 3600) % 24

        if key == 'hour':
            self.__secs = s + 60 * m + value * 3600
        elif key == 'min':
            self.__secs = s + 60 * value + h * 3600
        elif key == 'sec':
            self.__secs = value + 60 * m + h * 3600


def main():
    c1 = Clock(100)
    c2 = Clock(200)
    c3 = c1 + c2
    print(c1.get_format_time(), c2.get_format_time(), c3.get_format_time(), sep='\n')
    if c3 == c1 + c2:
        print('Times c3 and c1 + c2 are equal!')
    c3 += c1 + c2
    print(c3.get_format_time())
    if c1 != c2:
        print('Times c1 and c2 are NOT equal!')
    print(c2['min'], ':', c2['sec'])
    c2['min'] = 30
    print(c2['min'], ':', c2['sec'])


if __name__ == '__main__':
    main()
