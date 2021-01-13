def solution(s, n):
    pushed = ""
    for c in s:
        if ord(c) == 32:
            pushed += " "
        elif ord(c) + n > 90 and c.isupper():
            pushed += chr(ord(c) + n - 26)
        elif ord(c) + n > 122:
            pushed += chr(ord(c) + n - 26)
        else:
            pushed += chr(ord(c) + n)

    return pushed