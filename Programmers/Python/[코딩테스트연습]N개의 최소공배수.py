def solution(arr):
    arr.sort()
    for i in range(len(arr)):
        for j in range(i):
            if arr[j] != 0 and arr[i] % arr[j] == 0:
                arr[j] = 0

    candidate = max(arr)
    while True:
        for a in arr:
            if a != 0 and candidate % a != 0:
                break
            if a == arr[-1]:
                return candidate
        candidate += 1
