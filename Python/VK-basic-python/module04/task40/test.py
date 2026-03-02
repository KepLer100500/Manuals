import unittest
from solution import rotate_list


class TestCleanString(unittest.TestCase):

    def test01(self):
        result = rotate_list([1, 2, 3, 4], 1)
        self.assertEqual(result, [4, 1, 2, 3])


if __name__ == '__main__':
    unittest.main()
