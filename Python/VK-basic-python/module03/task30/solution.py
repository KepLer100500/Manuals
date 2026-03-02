class Dictionary:
   def __init__(self, dictionary):
       self.dictionary = dictionary

   def __call__(self, key):
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
dictionary = Dictionary({1:2, 2:1, 3:3})
print(dictionary(1))
'''
