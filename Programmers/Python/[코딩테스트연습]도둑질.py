def solution(money):

    money2 = money[:-1]
    money = money[1:]

    print(money2)
    print(money)

    dp = money[:2] + [money[0]+money[2]] + [0 for i in range(len(money)-3)]
    dp2 = money2[:2] + [money2[0]+money2[2]] + [0 for i in range(len(money2)-3)]
    for i in range(3, len(money)):
        dp[i] = max(dp[i-2], dp[i-3]) + money[i]
        dp2[i] = max(dp2[i-2], dp2[i-3]) + money2[i]
    print(dp)
    print(dp2)
    return max(dp[-2:] + dp2[-2:])


print(solution([1,2,3,1]))
print(solution([1, 7, 9, 5, 10]))