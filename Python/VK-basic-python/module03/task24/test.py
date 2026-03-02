import unittest
from solution import Counter


class TestCleanString(unittest.TestCase):

    def test01(self):
        counter = Counter(0)
        counter.increment()

        result = counter.get()
        self.assertEqual(result, 1)


if __name__ == '__main__':
    unittest.main()
