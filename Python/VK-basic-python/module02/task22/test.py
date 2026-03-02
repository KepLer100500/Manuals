import unittest
from solution import make_most_common_keys


class TestCleanString(unittest.TestCase):

    def test01(self):
        d = {5: 3, 3: 5, 0: 2, 4: 6, 7: 10}
        result = make_most_common_keys(d)

        self.assertEqual(result, [7, 4, 3, 5, 0])


if __name__ == '__main__':
    unittest.main()
