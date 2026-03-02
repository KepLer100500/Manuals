import unittest
from solution import repeat_deco


@repeat_deco(4)
def hello():
    print("hello")


hello()


class TestCleanString(unittest.TestCase):

    def test01(self):
        result = hello()


if __name__ == '__main__':
    unittest.main()
