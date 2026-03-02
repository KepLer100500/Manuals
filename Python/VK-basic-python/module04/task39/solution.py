import datetime
from collections import Counter
from typing import List


def most_common_months(dates: List[str], n) -> List[int]:
    m = []
    for cur_date in dates:
        m.append(datetime.datetime.strptime(cur_date, '%Y-%m-%dT%H:%M:%S').month)
    c = Counter(m)
    return [i[0] for i in c.most_common(n)]


def main():
    code = []
    while data := input():
        code.append(data)
    code = "\n".join(code)
    exec(code)


if __name__ == "__main__":
    main()

'''
dates=["2023-01-01T23:59:59", "2023-01-01T23:59:59", "2023-02-01T23:59:59"]
print(most_common_months(dates, 2))
'''
