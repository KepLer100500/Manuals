def changed_div(numerator, denominator):
    try:
        result = numerator / denominator
    except ZeroDivisionError:
        result = numerator
    return result


def main():
    numerator, denominator = int(input()), int(input())
    print(changed_div(numerator, denominator))


if __name__ == '__main__':
    main()
