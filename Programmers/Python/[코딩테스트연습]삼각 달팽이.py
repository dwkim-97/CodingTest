from functools import reduce
def solution(n):
    answer = []
    total_count = int(n * (n + 1) / 2)

    for i in range(1,n+1):
        block =[]
        for j in range(i):
            block.append(0)
        answer.append(block)

    t = 1
    s = n
    b = 0
    d = 0
    while True:
        for i in range(s):

            answer[i+d][0+b] = t
            t += 1
            if t == total_count+1:
                return list(reduce(lambda x,y:x+y, answer))
        for i in range(1, s):
            answer[-1-b][i+b] = t
            t += 1
            if t == total_count+1:
                return list(reduce(lambda x,y:x+y, answer))
        for i in range(s-2, 0, -1):
            answer[i+d][-1-b] = t
            t += 1
            if t == total_count+1:
                return list(reduce(lambda x,y:x+y, answer))
        s -= 3
        b += 1
        d += 2

    return list(reduce(lambda x,y:x+y, answer))

#print(solution(4))
#print(solution(5))
print("answer",solution(6))
#print(solution(7))