import unittest
from solution import task


class TestCleanString(unittest.TestCase):

    def test01(self):
        result = task('1 2 3 4')
        self.assertEqual(result, 2.5)


if __name__ == '__main__':
    unittest.main()
