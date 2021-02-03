def solution(n):
    return hanoi(n, 1, 3, 2)


def hanoi(n, start, end, bypass):
    if n == 1:
        return [[start, end]]
    else:
        return hanoi(n - 1, start, bypass, end) + [[start, end]] + hanoi(n - 1, bypass, end, start)
