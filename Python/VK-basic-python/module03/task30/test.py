import unittest
from solution import Dictionary


class TestCleanString(unittest.TestCase):

    def test01(self):
        dictionary = Dictionary({1: 2, 2: 1, 3: 3})
        result = dictionary(1)
        self.assertEqual(result, 2)


if __name__ == '__main__':
    unittest.main()
