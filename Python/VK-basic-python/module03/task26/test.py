import unittest
from solution import Person


class TestCleanString(unittest.TestCase):

    def test01(self):
        person = Person(18)
        person.age = 19

        result = person.age
        self.assertEqual(result, 19)


if __name__ == '__main__':
    unittest.main()
