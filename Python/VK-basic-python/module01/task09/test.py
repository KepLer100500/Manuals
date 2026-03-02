import unittest
from solution import task


class TestCleanString(unittest.TestCase):

    def test01(self):
        result = task('abcabcaaabb12bbbaaa')
        self.assertEqual(result, '1 2 a b c')
        

if __name__ == '__main__':
    unittest.main()
