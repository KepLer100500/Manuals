import unittest
from solution import most_common_months


class TestCleanString(unittest.TestCase):

    def test01(self):
        dates = ["2023-01-01T23:59:59", "2023-01-01T23:59:59", "2023-02-01T23:59:59"]
        result = most_common_months(dates, 2)
        self.assertEqual(result, [1, 2])


if __name__ == '__main__':
    unittest.main()
