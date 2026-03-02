import unittest
from solution import task


class TestCleanString(unittest.TestCase):

    a = 0

    def test01(self):
        result = task()
        self.assertEqual(result, 10)
        

if __name__ == '__main__':
    unittest.main()
