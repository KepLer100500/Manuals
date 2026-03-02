from collections import defaultdict
from typing import List, Tuple


def fill_specializations(specializations: List[Tuple[str, str]]):
    result = defaultdict(list)
    for specialization in specializations:
        result[specialization[0]].append(specialization[1])
    return dict(result)


def main():
    code = []
    while data := input():
        code.append(data)
    code = "\n".join(code)
    exec(code)


if __name__ == "__main__":
    main()

'''
specs=[('Sales', 'John Doe'), ('Sales', 'Martin Smith'), ('Accounting', 'Jane Doe'), ('Marketing', 'Elizabeth Smith'), ('Marketing', 'Adam Doe')]
print(fill_specializations(specs))

specs=[]
print(fill_specializations(specs))
'''
