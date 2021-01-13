def solution(n):
    check = [False]*2 + ([True] * (n-1))
    for i in range(2, n+1):
        print("i",i)
        if check[i]:
            for j in range(i*2, n+1, i):
                print("j",j, "i", i)
                check[j] = False
                print(check)

    print(check)
    return check.count(True)


print(solution(10))