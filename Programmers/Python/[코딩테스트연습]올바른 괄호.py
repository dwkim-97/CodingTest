def solution(s):
    if s.count('(') != s.count(")"):
        return False

    check = 0
    for i in s:
        if i == '(':
            check += 1
        else:
            check -= 1

        if check < 0:
            return False

    return True