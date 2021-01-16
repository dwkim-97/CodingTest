
def solution(A,B):

    return sum(list(map(lambda x:x[0]*x[1], zip(sorted(A),sorted(B, reverse=True)))))

print(solution([1,4,2],[5,4,4]))