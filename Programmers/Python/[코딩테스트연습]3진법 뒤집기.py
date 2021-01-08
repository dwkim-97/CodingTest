def solution(n):
    answer = 0
    ternary = ""
    while n != 0:
        ternary += str(n % 3)
        n = n // 3

    for t in range(len(ternary)):
        answer += int(ternary[ta]) * pow(3, (len(ternary) - 1) - t)

    return answer