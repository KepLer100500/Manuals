from collections import deque
from typing import List


def rotate_list(nums: List[int], n: int):
    d = deque(nums)
    for i in range(n):
        last = d.pop()
        d.appendleft(last)
    return list(d)


def main():
    code = []
    while data := input():
        code.append(data)
    code = "\n".join(code)
    exec(code)


if __name__ == "__main__":
    main()

'''
print(rotate_list([1,2,3,4], 1))
'''
