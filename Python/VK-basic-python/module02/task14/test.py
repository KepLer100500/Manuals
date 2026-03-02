import unittest
from solution import task


class TestCleanString(unittest.TestCase):

    def test01(self):
        result = tuple(task(1, 10, 1))
        self.assertEqual(result, (1, -2, 9, -4, 25, -6, 49, -8, 81))


if __name__ == '__main__':
    unittest.main()
