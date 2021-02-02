def solution(s):
    answer = 1
    for i in range(len(s) - 1):
        
        if i != 0 and s[i - 1] == s[i + 1]:
            count = check(s, i-1, i+1, 1)
            answer = count if answer < count else answer

        if s[i] == s[i + 1]:
            count = check(s, i, i+1, 0)
            answer = count if answer < count else answer

    return answer

def check(s, left, right, count):
    while s[left] == s[right]:
        count += 2
        left -= 1
        right += 1
        if left == -1 or right == len(s):
            break
    return count


print('s', solution('abcdcba'))
print('s', solution('abacde'))
print('s', solution('abba'))
print('s', solution('dbaabce'))
print('s', solution('a'))
print('s', solution('dddddddd'))
