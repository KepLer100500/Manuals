import unittest
from solution import parse_time


class TestCleanString(unittest.TestCase):

    def test01(self):
        result = parse_time('2023 03 03 12 30 00')
        self.assertEqual(result, 4)


if __name__ == '__main__':
    unittest.main()
