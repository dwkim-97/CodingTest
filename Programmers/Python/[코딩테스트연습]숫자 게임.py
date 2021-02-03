def solution(A, B):
    answer = 0
    A.sort()
    B.sort()
    ai, bi = 0, 0
    while ai != len(A) and bi != len(B):
        if B[bi] > A[ai]:
            answer += 1
            ai += 1
            bi += 1
        else:
            bi += 1

    return answer