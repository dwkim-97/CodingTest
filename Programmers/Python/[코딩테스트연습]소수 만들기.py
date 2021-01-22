from itertools import combinations
def solution(nums):
    answer = 0
    combi = [sum(c) for c in sorted(combinations(nums, 3))]
    print(combi)
    check = [False, False] + [True for i in range(max(combi)-1)]
    for i in range(2, len(check)):
        print("i", i)
        if check[i]:
            print((len(check)/i))
            for n in range(2, int((len(check)-1)/i+1)):
                print(n * i)
                check[n*i] = False
                print(check)

    for c in combi:
        if check[c]:
            print("c", c, check[c-1])
            answer += 1

    return answer

print(solution([1,2,7,6,4]))