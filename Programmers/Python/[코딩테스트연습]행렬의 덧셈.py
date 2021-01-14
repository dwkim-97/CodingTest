import numpy as np
def solution(arr1, arr2):
    n_arr1 = np.array(arr1)
    n_arr2 = np.array(arr2)
    return (n_arr1+n_arr2).tolist()