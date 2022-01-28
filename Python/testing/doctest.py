def is_simple(x):
    """
    Function return True if input number is simple
    Function return False if input number is complex
    x - int positive number
    >>> is_simple(19)
    True
    >>> is_simple(4)
    False
    """
    divisor = 2
    while x > divisor:
        if x % divisor == 0:
            return False
        else:
            divisor += 1
    return True


def main():
    import doctest
    doctest.testmod()
    print(is_simple(int(input())))


if __name__ == '__main__':
    main()
