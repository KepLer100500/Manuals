import unittest
from solution import task


class TestCleanString(unittest.TestCase):

    def test01(self):
        result = task(['3', ';', '1 2 3', ';', '2', ';', '4 5 6 7', ';'])
        self.assertEqual(result, '7;3;2')


if __name__ == '__main__':
    unittest.main()
