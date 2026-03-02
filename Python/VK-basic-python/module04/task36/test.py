import unittest
from solution import fill_missing_values


class TestCleanString(unittest.TestCase):

    def test01(self):
        result = fill_missing_values([1, 2, 3], [2, 3, 4, 5])
        self.assertEqual(result, [(1, 2), (2, 3), (3, 4), (1, 5)])


if __name__ == '__main__':
    unittest.main()
