from typing import List, Dict


def make_most_common_keys(d: Dict[int, int]) -> List[int]:
    values = sorted([val for key, val in d.items()])
    values.reverse()
    result = []
    for value in values:
        for key, val in d.items():
            if value == val:
                result.append(key)

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
d = {5:3, 3:5, 0:2, 4:6, 7:10}
print(make_most_common_keys(d))
'''
