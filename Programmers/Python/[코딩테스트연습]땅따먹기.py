def solution(land):
    for i in range(1, len(land)):
        for j in range(4):
            land[i][j] += max(land[i-1][k] for k in range(4) if k != j)

    return max(land[-1])

#print(solution([[1,2,3,5],[5,6,7,8],[4,3,2,1]]))
#print(solution([[1,2,3,5],[5,6,7,8],[4,3,2,1],[1,2,3,5],[5,6,7,8],[4,3,2,1]]))
#print(solution( [[1, 1, 99, 100], [1, 1, 1, 99]]))
#print(solution([[1,2,3,5],[5,6,7,100],[4,3,2,1]]))
#print(solution([[1, 100, 15, 3], [1, 2, 3, 4], [100, 99, 98, 97], [97, 98, 99, 100], [4, 3, 2, 1], [100, 100, 100, 100], [1, 1, 1, 1]]))
print(solution([[4, 3, 2, 1], [2, 2, 2, 1], [6, 6, 6, 4], [8, 7, 6, 5]]))


# def solution(land):
#     step = 1
#     best_scores = land[0]
#     last_steps = [0, 1, 2, 3]
#
#     while step < len(land):
#         for i in range(4):
#             scores = []
#             idx = []
#
#             for j in range(4):
#                 if j != last_steps[i]:
#                     idx.append(j)
#                     scores.append(best_scores[i] + land[step][j])
#             best_scores[i] = max(scores)
#             last_steps[i] = idx[scores.index(max(scores))]
#         step += 1
#
#     return max(best_scores)
