import unittest
from solution import SquareWithMixin


class TestCleanString(unittest.TestCase):

    def test01(self):
        square_with_mixin1 = SquareWithMixin(3)
        square_with_mixin2 = SquareWithMixin(2)
        result = square_with_mixin1 + square_with_mixin1
        self.assertEqual(result, 18)


if __name__ == '__main__':
    unittest.main()
