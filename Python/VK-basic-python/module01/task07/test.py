import unittest
from solution import task


class TestCleanString(unittest.TestCase):

    def test01(self):
        result = task('Hello World!')
        self.assertEqual(result, 5.5)
        result = task('Sums start and the items of an iterable from left to right and returns the total.')
        self.assertEqual(result, 4.12)


if __name__ == '__main__':
    unittest.main()
