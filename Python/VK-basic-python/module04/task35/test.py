import unittest
from solution import fill_specializations


class TestCleanString(unittest.TestCase):

    def test01(self):
        specs = [('Sales', 'John Doe'), ('Sales', 'Martin Smith'), ('Accounting', 'Jane Doe'),
                 ('Marketing', 'Elizabeth Smith'), ('Marketing', 'Adam Doe')]
        result = fill_specializations(specs)
        self.assertEqual(result, {'Sales': ['John Doe', 'Martin Smith'], 'Accounting': ['Jane Doe'], 'Marketing': ['Elizabeth Smith', 'Adam Doe']})


if __name__ == '__main__':
    unittest.main()
