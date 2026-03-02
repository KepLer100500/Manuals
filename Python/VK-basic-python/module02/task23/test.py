import unittest
from solution import get_indexes


class TestCleanString(unittest.TestCase):

    def test01(self):
        nums1 = [10, 8, 6, 4]
        nums2 = [4, 6, 8, 10]

        result = get_indexes(nums1, nums2)

        self.assertEqual(result, [2, 3])


if __name__ == '__main__':
    unittest.main()
