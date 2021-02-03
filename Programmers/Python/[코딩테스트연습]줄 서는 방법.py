def solution(n, k):
    answer = []
    numbers = [i + 1 for i in range(n)]
    total = [1]
    for i in range(1, n + 1):
        total.append(total[i - 1] * i)

    n -= 1
    k -= 1
    while len(numbers) != 1:
        index = k // total[n]
        answer.append(numbers[index])
        numbers.pop(index)
        k = k % total[n]
        n -= 1

    answer += numbers

    return answer