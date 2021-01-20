def solution(n,a,b):
    i = 0
    while a+1 != b and b+1 != a:
        a = (a + 1) // 2
        b = (b + 1) // 2
        i += 1

    return i + 1

print(solution(8,4,7))
print(solution(8,1,2))
print(solution(8,1,4))