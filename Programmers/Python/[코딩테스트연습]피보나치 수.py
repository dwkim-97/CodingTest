def solution(n):
    answer = 0
    fibo = [0,1]
    for i in range(n):
        if len(fibo) == n+1:
            return fibo[n] % 1234567
        else:
            fibo.append(fibo[-1]+fibo[-2])
    return answer