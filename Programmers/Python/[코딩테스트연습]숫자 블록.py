def solution(begin, end):
    answer = []
    MAX = 10000000
    for num in range(begin, end + 1):
        if num == 1:
            answer.append(0)
            continue
        else:
            start = 2 if num % 2 == 0 else 3
            answer.append(1)
            for i in range(start, int(num ** 0.5) + 1):
                if num != i and num % i == 0:
                    if num // i <= MAX:
                        answer[-1] = num // i
                        break
    return answer