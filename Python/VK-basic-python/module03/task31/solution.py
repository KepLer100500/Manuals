class ContextDictionary:
    def __init__(self):
        self.dictionary = None

    def __enter__(self):
        self.dictionary = dict()

    def __exit__(self, exc_type, exc_val, exc_tb):
        self.dictionary = None

    def put(self, key, value):
        self.dictionary[key] = value

    def get(self, key):
        return self.dictionary[key]


def main():
    code = []
    while data := input():
        code.append(data)
    code = "\n".join(code)
    exec(code)


if __name__ == "__main__":
    main()

'''
context_dictionary = ContextDictionary()
with context_dictionary:
    context_dictionary.put(2,3)
    print(context_dictionary.get(2))
print(context_dictionary.dictionary is None)
'''
