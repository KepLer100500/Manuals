import re


def task(a, b, c):
    b = float(b)
    c = int(c)

    a = "+" + a.zfill(9) if int(a) >= 0 else a.zfill(10)
    b = '#' * (10 - len(f"{b:.2f}")) + f"{b:.2f}"
    c = re.sub('(.{4})(.{4})(.{4})(.{4})', r'\1_\2_\3_\4', bin(c - 65535 if c > 65535 else c)[2:].zfill(16))

    return a, b, c


def main():
    a = input()
    b = input()
    c = input()

    a, b, c = task(a, b, c)

    print(str(a)[:10])
    print(b)
    print(c)


if __name__ == '__main__':
    main()
