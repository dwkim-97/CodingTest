import math

def solution(n, s, a, b, fares):
    s, a, b = s - 1, a - 1, b - 1
    inf = math.inf
    matrix = [[inf for i in range(n)] for j in range(n)]

    for f in fares:
        matrix[f[0] - 1][f[1] - 1] = f[2]
        matrix[f[1] - 1][f[0] - 1] = f[2]

    for path in range(n):
        for head in range(n):
            for tail in range(n):
                if head == tail:
                    matrix[head][tail] = 0

                elif matrix[head][tail] > matrix[head][path] + matrix[path][tail]:
                    matrix[head][tail] = matrix[head][path] + matrix[path][tail]

    min_cost = matrix[s][a] + matrix[s][b]
    for path in range(n):
        if min_cost > matrix[s][path] + matrix[path][a] + matrix[path][b]:
            min_cost = matrix[s][path] + matrix[path][a] + matrix[path][b]

    return min_cost


#print(solution(6,4,6,2,[[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]))
#print(solution(6,4,6,6,[[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]))
#print(solution(7,3,4,1,[[5, 7, 9], [4, 6, 4], [3, 6, 1], [3, 2, 3], [2, 1, 6]]))
print(solution(6,4,5,6,[[2,6,6], [6,3,7], [4,6,7], [6,5,11], [2,5,12], [5,3,20], [2,4,8], [4,3,9]]))