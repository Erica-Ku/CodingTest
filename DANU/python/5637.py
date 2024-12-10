import sys

def get_words():
    input = sys.stdin.readline
    words = []

    while True:
        S = input().rstrip().split(' ')
        if S[-1] == 'E-N-D':
            break
        for maybe_word in S:
            word = ''
            for char in maybe_word:
                if ('a' <= char <= 'z' or 'A' <= char <= 'Z' or '-' == char):
                    word += char
            words.append(word)

    return words

def find_longest_word(words):
    return max(words, key = lambda x: len(x)).lower()

def main():
    words = get_words()
    longest_word = find_longest_word(words)
    print(longest_word)

if __name__ == "__main__":
    main()
