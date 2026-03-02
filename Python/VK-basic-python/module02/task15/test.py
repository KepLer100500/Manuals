import unittest
from solution import task


class TestCleanString(unittest.TestCase):

    def test01(self):
        result = task(50)
        self.assertEqual(result, 12586269025)


if __name__ == '__main__':
    unittest.main()
