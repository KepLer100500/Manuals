import unittest
from solution import task


class TestCleanString(unittest.TestCase):

    def test01(self):
        result = task('Ivan')
        self.assertEqual(result, 'Hello, Ivan')


if __name__ == '__main__':
    unittest.main()
