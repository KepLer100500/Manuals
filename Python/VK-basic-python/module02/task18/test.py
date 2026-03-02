import unittest
from solution import cache_deco

@cache_deco
def fib(k):
    if k <= 2:
        return 1
    return fib(k - 1) + fib(k - 2)


class TestCleanString(unittest.TestCase):

    def test01(self):
        result = fib(30)

        self.assertEqual(result, 832040)


if __name__ == '__main__':
    unittest.main()
