import unittest

from solution import changed_div


class TestCleanString(unittest.TestCase):

    def test01(self):
        result = changed_div(1, 2)
        self.assertEqual(result, 0.5)


if __name__ == '__main__':
    unittest.main()
