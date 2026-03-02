import unittest
from solution import SemiCircle


class TestCleanString(unittest.TestCase):

    def test01(self):
        semi_circle = SemiCircle(2)
        result = semi_circle.calculate_area()
        self.assertEqual(result, 6.28)


if __name__ == '__main__':
    unittest.main()
