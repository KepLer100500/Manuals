import re


def clean_words(line: str) -> str:
    return re.sub('[!,.?;:#$%^&*()\"\'“]', '', line).lower()


def filter_chars(line: str) -> list:
    return sorted([word for word in line.split() if len(word) >= 5 and len(set(word)) >= 4])


def often_encountered(words: list) -> list:
    wordbook = {}
    for word in words:
        if word not in wordbook:
            wordbook[word] = 1
        else:
            wordbook[word] = wordbook[word] + 1

    return sorted([word for word, periodicity in wordbook.items() if periodicity > 2])


def task(line: str) -> list:
    line = clean_words(line)
    words = filter_chars(line)
    result = often_encountered(words)

    return result


def main():
    # a = input()
    a = 'It is a herbaceous perennial which produces flowers in the typical aroid structure: a densely crowded inflorescence called a spadix is subtended by one large bract called a spathe (occasionally two spathes are produced, with the upper spathe smaller). The spadix is generally cream or ivory when young, and turns green with age; the spathe is generally white or white with green nerves distally from the margin, turning green with age. Leaves are basal, glossy and somewhat deeply veined, ovate and acuminate. The petioles are long and the leaves arch gracefully. The plant produces offsets at the base and in time becomes a dense clump. Spathiphyllum wallisii is one of approximately 40 species in a genus of tropical evergreens. It was discovered in the late 19th century growing wild in Colombia. A number of cultivars, many of hybrid origin, are commercially available, such as the larger hybrids "Mauna Loa", named after the Hawaiian volcano, and the even larger “Sensation", which are both popular indoor plants. "Domino" is a finely variegated variety of intermediate size. Its wide natural range includes parts of Mexico, the Caribbean Islands, and northern South America.'
    result = task(a)

    for word in result:
        print(word)


if __name__ == '__main__':
    main()
