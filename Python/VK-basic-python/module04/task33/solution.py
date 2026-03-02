import os


def write_and_read(text):
    open('text.txt', 'w').write(text)
    return open('text.txt', 'r').read()


def main():
    text = input()
    print(write_and_read(text))


if __name__ == '__main__':
    main()
