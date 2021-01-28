def solution(triangle):
    dp = [triangle[-1]]
    for i in range(len(triangle)-2, -1, -1):
        dp.append([])
        print('i', i)
        print('tri', triangle[i])
        for j in range(len(triangle[i])):
            print('j',j)
            print(dp)
            dp[-1].append(max(dp[-2][j], dp[-2][j+1])+triangle[i][j])

    return dp[-1][0]

print(solution([[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]))