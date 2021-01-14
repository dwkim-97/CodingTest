def solution(n):
    answer = 0
    array = []
    while n >= 10:
        array.append(str(n % 10))
        n = n // 10
    array.append(str(n % 10))
    array.sort(reverse=True)

    return int("".join(array))