def solution(n):
    answer = 0
    for i in range(1, n + 1):
        for j in range(i, n + 1):
            if (j + 1 - i) * (i + j) / 2 == n:
                answer += 1
            elif (j + 1 - i) * (i + j) / 2 > n:
                break

    return answer


print(solution(15))