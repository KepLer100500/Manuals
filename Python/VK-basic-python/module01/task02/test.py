import unittest
from solution import task


class TestCleanString(unittest.TestCase):

    def test01(self):
        result = task('Moscow', '12:00')
        self.assertEqual(result, 'Current location is Moscow and time is 12:00')


if __name__ == '__main__':
    unittest.main()
