from collections import Counter

def solution(str1, str2):
    arr1 = [str1[i:i + 2].upper() for i in range(len(str1) - 1) if str1[i:i + 2].isalpha()]
    arr2 = [str2[i:i + 2].upper() for i in range(len(str2) - 1) if str2[i:i + 2].isalpha()]

    if len(arr1) == 0 and len(arr2) == 0:
        return 65536

    c1 = Counter(arr1)
    c2 = Counter(arr2)

    sum_set = sum((c1 | c2).values())
    inter_set = sum((c1 & c2).values())

    return int(inter_set / sum_set * 65536)