words = input()
for i in words:
    if ord(i) < 68:
        print(chr(ord(i) + 23), end='')
    else:
        print(chr(ord(i) - 3), end='')
