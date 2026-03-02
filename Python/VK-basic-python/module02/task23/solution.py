from typing import List


def get_indexes(nums1: List[int], nums2: List[int]) -> List[int]:
    result = []
    for idx, (value1, value2) in enumerate(zip(nums1, nums2)):
        if value1 < value2:
            result.append(idx)
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
nums1=[10, 8, 6, 4]
nums2=[4, 6, 8, 10]
print(get_indexes(nums1, nums2))
'''
