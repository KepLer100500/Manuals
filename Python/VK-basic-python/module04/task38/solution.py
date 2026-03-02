import datetime


def parse_time(s):
    dt = datetime.datetime.strptime(s, '%Y %m %d %H %M %S')
    delta = datetime.timedelta(days=1)
    new_dt = dt + delta
    return new_dt.date().day


def main():
    string_datetime = input()
    print(parse_time(string_datetime))


if __name__ == "__main__":
    main()
