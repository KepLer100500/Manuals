import unittest
from solution import task


class TestCleanString(unittest.TestCase):

    def test01(self):
        result = task('letter')
        self.assertEqual(result, False)
        result = task('start')
        self.assertEqual(result, True)


if __name__ == '__main__':
    unittest.main()
