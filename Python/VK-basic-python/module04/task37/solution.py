import datetime


def shift_time(days: int, seconds: int):
    default_dt = datetime.datetime.strptime('01.01.2023 12:30:00', '%d.%m.%Y %H:%M:%S')
    delta = datetime.timedelta(days=days, seconds=seconds)
    shifted_time = default_dt + delta
    return shifted_time.date().day, shifted_time.time().second

def main():
    days, seconds = int(input()), int(input())
    print(shift_time(days, seconds))


if __name__ == "__main__":
    main()
