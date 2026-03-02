import unittest
from solution import Circle


class TestCleanString(unittest.TestCase):

    def test01(self):
        circle = Circle()
        result = circle.calculate_area(2)
        self.assertEqual(result, 12.56)


if __name__ == '__main__':
    unittest.main()
