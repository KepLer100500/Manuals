import unittest
from solution import ContextDictionary


class TestCleanString(unittest.TestCase):

    def test01(self):
        context_dictionary = ContextDictionary()
        with context_dictionary:
            context_dictionary.put(2, 3)
            self.assertEqual(context_dictionary.get(2), 3)
        self.assertEqual(context_dictionary.dictionary is None, True)


if __name__ == '__main__':
    unittest.main()
