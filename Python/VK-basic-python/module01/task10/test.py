import unittest
from solution import task


class TestCleanString(unittest.TestCase):

    def test01(self):
        result = task('Python is an easy to learn, powerful programming language. It has efficient high-level data structures and a simple but effective approach to object-oriented programming.')
        self.assertEqual(result, 'to 2')
        

if __name__ == '__main__':
    unittest.main()
