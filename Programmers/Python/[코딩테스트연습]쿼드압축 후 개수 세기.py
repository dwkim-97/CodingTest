import numpy as np

def solution(arr):
    dic = {0:0, 1:0}
    arr = np.array(arr)
    dic = quad(np.array(arr), dic)
    return [dic[0], dic[1]]


def quad(arr, dic):
    if arr.sum() == len(arr)**2:
        dic[1] += 1
    elif arr.sum() == 0:
        dic[0] += 1
    else:
        dic = quad(arr[:len(arr) // 2, :len(arr) // 2], dic)
        dic = quad(arr[:len(arr) // 2, len(arr) // 2:], dic)
        dic = quad(arr[len(arr) // 2:, :len(arr) // 2], dic)
        dic = quad(arr[len(arr) // 2:, len(arr) // 2:], dic)

    return dic

print(solution([[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]))

