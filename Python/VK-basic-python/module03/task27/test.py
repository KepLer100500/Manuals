import unittest
from solution import Pendulum


class TestCleanString(unittest.TestCase):

    def test01(self):
        result = Pendulum.calculate_period(10)
        self.assertEqual(result, 6.28)


if __name__ == '__main__':
    unittest.main()
