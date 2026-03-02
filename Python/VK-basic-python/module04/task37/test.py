import unittest
from solution import shift_time


class TestCleanString(unittest.TestCase):

    def test01(self):
        result = shift_time(1, 0)
        self.assertEqual(result, (2, 0))


if __name__ == '__main__':
    unittest.main()
