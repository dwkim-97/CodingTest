import math

# <<<DIJKSTRA'S ALGORITHM>>>
def solution(N, road, K):
    answer = 0
    visited = []
    distance = [0] + [math.inf for i in range(1, N)]
    roads = {i: {} for i in range(N)}
    for r in road:
        if r[1] - 1 in roads and r[0] - 1 in roads[r[1] - 1]:
            if roads[r[1] - 1][r[0] - 1] > r[2]:
                roads[r[1] - 1][r[0] - 1] = r[2]
                roads[r[0] - 1][r[1] - 1] = r[2]
        else:
            roads[r[1] - 1][r[0] - 1] = r[2]
            roads[r[0] - 1][r[1] - 1] = r[2]

    for i in roads[0]:
        distance[i] = roads[0][i]

    while len(visited) != N:
        minimum = math.inf
        for i in range(1, N):
            if i not in visited and distance[i] < minimum:
                minimum = distance[i]
                town = i

        visited.append(town)
        for i in roads[town]:
            if distance[i] > distance[town] + roads[town][i]:
                distance[i] = distance[town] + roads[town][i]

    for d in distance:
        if d <= K:
            answer += 1

    return answer


print(solution(5, [[1, 2, 1], [2, 3, 3], [5, 2, 2], [1, 4, 2], [5, 3, 1], [5, 4, 2]], 3))
print(solution(6, [[1, 2, 1], [1, 3, 2], [2, 3, 2], [3, 4, 3], [3, 5, 2], [3, 5, 3], [5, 6, 1]], 4))
print(solution(3, [[1, 2, 1], [1, 2, 3], [1, 3, 1], [1, 3, 6], [2, 3, 5], [2, 3, 1]], 3))

## <<<FLOYD - WARSHALL ALGORITHM>>>
# def solution(N, road, K):
#     answer = 0
#     roads = [[math.inf for i in range(N)] for j in range(N)]
#     for r in road:
#         if roads[r[1] - 1][r[0] - 1] > r[2]:
#             roads[r[1] - 1][r[0] - 1] = r[2]
#             roads[r[0] - 1][r[1] - 1] = r[2]
#
#     for i in range(N):
#         roads[i][i] = 0
#
#     for path in range(N):
#         for i in range(N):
#             for j in range(N):
#                 if roads[i][j] > roads[i][path] + roads[path][j]:
#                     roads[i][j] = roads[i][path] + roads[path][j]
#
#     for i in range(N):
#         if roads[0][i] <= K:
#             answer += 1
#
#     return answer
