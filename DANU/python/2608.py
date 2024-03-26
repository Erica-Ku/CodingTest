import sys

def arabia(word, nums, two_nums):
    answer = 0
    visited = [False] * len(word)

    for i in range(len(word)):
        if not visited[i]:
            if len(word) > i + 1 and word[i: i + 2] in two_nums:
                visited[i: i + 2] = True, True
                answer += two_nums[word[i: i + 2]]
            else:
                visited[i] = True
                answer += nums[word[i]]

    return answer

def roma(num_string):
    answer = ""

    for i in range(len(num_string), 0, -1):
        n = int(num_string[-i])

        if i == 4:
            answer += 'M' * n
        elif i == 3:
            if n == 9:
                answer += 'CM'
            elif n == 4:
                answer += 'CD'
            else:
                if n >= 5:
                    answer += 'D'
                answer += 'C' * (n % 5)
        elif i == 2:
            if n == 9:
                answer += 'XC'
            elif n == 4:
                answer += 'XL'
            else:
                if n >= 5:
                    answer += 'L'
                answer += 'X' * (n % 5)
        elif i == 1:
            if n == 9:
                answer += 'IX'
            elif n == 4:
                answer += 'IV'
            else:
                if n >= 5:
                    answer += 'V'
                answer += 'I' * (n % 5)
    return answer

def main():
    nums = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    two_nums = {'IV': 4, 'IX': 9, 'XL': 40, 'XC': 90, 'CD': 400, 'CM': 900}

    first_word = str(sys.stdin.readline().rstrip('\n'))
    second_word = str(sys.stdin.readline().rstrip('\n'))
    total = arabia(first_word, nums, two_nums) + arabia(second_word, nums, two_nums)
    print(total)
    print(roma(str(total)))

if __name__ == "__main__":
    main()
