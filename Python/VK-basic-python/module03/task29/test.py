import unittest
from solution import CircleWithMixin


class TestCleanString(unittest.TestCase):

    def test01(self):
        circle_with_mixin = CircleWithMixin(2)

        result = circle_with_mixin.calculate_length()
        self.assertEqual(result, 12.56)


if __name__ == '__main__':
    unittest.main()
