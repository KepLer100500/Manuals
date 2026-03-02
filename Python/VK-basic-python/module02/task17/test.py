import unittest
from solution import task


class TestCleanString(unittest.TestCase):

    def test01(self):
        result = tuple(task(eval('lambda x: x ** 2'), eval('range(-10, 11, 2)')))
        self.assertEqual(result, (100, 64, 36, 16, 4, 0, 4, 16, 36, 64, 100))


if __name__ == '__main__':
    unittest.main()
