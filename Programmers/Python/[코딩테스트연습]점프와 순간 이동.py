def solution(n):
    answer = 1
    while n > 2:
        if n % 2 == 1:
            n -= 1
            answer += 1
        else:
            n /= 2

    return answer

print(solution(5))
print(solution(6))
print(solution(5000))