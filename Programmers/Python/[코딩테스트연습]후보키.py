import numpy as np
from itertools import combinations


def solution(relation):
    answer = 0
    n_rel = np.array(relation).T
    candidates = []

    for grouping_num in range(1, len(n_rel)+1):
        comb = list(combinations([n_rel[i] for i in range(len(n_rel))], grouping_num))
        index_comb = list(combinations([i for i in range(len(n_rel))], grouping_num))
        for c in range(len(comb)):
            group = []
            for i in range(len(comb[c][0])):
                group.append(tuple(comb[c][j][i] for j in range(len(comb[c]))))
            if len(group) == len(set(group)):
                candidates.append(set(index_comb[c]))

    for c in range(len(candidates[::-1])):
        check = True
        for i in range(c):
            if candidates[i].issubset(candidates[c]):
                check = False
                break
        if check:
            answer += 1

    return answer

print(solution([["100", "r"], ["200", "c"], ["300", "d"]]))
print(solution([["a", "1", "4"], ["2", "1", "5"], ["a", "2", "4"]]))
print(solution([["100", "r"], ["200", "c"], ["300", "d"]]))