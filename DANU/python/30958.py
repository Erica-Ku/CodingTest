def count_alphabet_frequencies(song):
    alpha = [0 for _ in range(0, 26)]
    for i in song:
        if i in (' ', ',', '.'):
            continue
        else:
            alpha[ord(i) % 97] += 1
    return max(alpha)

def main():
    N = int(input())
    song = input()
    max_frequency = count_alphabet_frequencies(song)
    print(max_frequency)

if __name__ == "__main__":
    main()
