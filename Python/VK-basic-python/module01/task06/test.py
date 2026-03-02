import unittest
from solution import task


class TestCleanString(unittest.TestCase):

    def test01(self):
        counter, clean_string = task('Hello World!@#%')
        self.assertEqual(counter, 4)
        self.assertEqual(clean_string, 'hello world')


if __name__ == '__main__':
    unittest.main()
