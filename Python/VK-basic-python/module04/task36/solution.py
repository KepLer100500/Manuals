from itertools import zip_longest
from typing import List, Tuple


def fill_missing_values(values_list_1: List[int], values_list_2: List[int]) -> List[Tuple[int, int]]:
    result = []
    for el1, el2 in zip_longest(values_list_1, values_list_2, fillvalue=1):
        result.append((el1, el2))
    return result


def main():
    code = []
    while data := input():
        code.append(data)
    code = "\n".join(code)
    exec(code)


if __name__ == "__main__":
    main()

'''
print(fill_missing_values([1, 2, 3], [2, 3, 4, 5]))
'''
