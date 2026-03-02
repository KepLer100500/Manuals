import unittest
from solution import task


class TestCleanString(unittest.TestCase):

    def test01(self):
        result = task([1, 10, 1, 2, 3])
        self.assertEqual(result, True)
        result = task([1, 10, 1, 20, 3])
        self.assertEqual(result, False)


if __name__ == '__main__':
    unittest.main()
