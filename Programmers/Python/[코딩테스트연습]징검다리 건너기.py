def solution(stones, k):
    left = 1
    right = max(stones) + 1
    while left < right - 1:
        mid = (left + right) // 2
        if check(stones, mid, k):
            left = mid
        else:
            right = mid

    return left


def check(stones, n, k):
    count = 0
    for s in stones:
        if s < n:
            count += 1
        else:
            count = 0
        if count >= k:
            return False
    return True



print(solution([2, 4, 5, 3, 2, 1, 4, 2, 5, 1], 3))
print(solution([3,3,3,3], 3))