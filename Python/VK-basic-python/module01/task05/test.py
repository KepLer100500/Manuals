import unittest
from solution import task


class TestCleanString(unittest.TestCase):

    def test01(self):
        a, b, c = task('102', '3.1415926535', '1127')
        self.assertEqual(a, '+000000102')
        self.assertEqual(b, '######3.14')
        self.assertEqual(c, '0000_0100_0110_0111')


if __name__ == '__main__':
    unittest.main()
