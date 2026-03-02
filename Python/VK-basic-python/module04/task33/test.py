import unittest
from solution import write_and_read


class TestCleanString(unittest.TestCase):

    def test01(self):
        result = write_and_read('www')
        self.assertEqual(result, 'www')


if __name__ == '__main__':
    unittest.main()
