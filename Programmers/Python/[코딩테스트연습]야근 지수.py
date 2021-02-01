import heapq

def solution(n, works):
    if sum(works) <= n:
        return 0

    answer = 0
    works = [-w for w in works]
    heapq.heapify(works)
    while n > 0:
        max_val = heapq.heappop(works)
        heapq.heappush(works, max_val+1)
        n -= 1

    for w in works:
        answer += w ** 2
    return answer

#print(solution(4, [4,3,3]))
#print(solution(1, [2,1,2]))
#print(solution(3, [1,1]))
#print(solution(10,[10,9000,9997,9998,9999]))
#print(solution(10, [9,8,7,1]))
print(solution(20, [10, 10, 10, 10, 1]))

#def solution(n, works):
#     if sum(works) <= n:
#         return 0
#
#     answer = 0
#     works.sort(reverse=True)
#     next = 1
#     while n > 0:
#         index = 0
#
#         while works[index] > works[next] and index != len(works)-1 and n != 0:
#             print('loop!')
#             print(index)
#             works[index] -= 1
#             n -= 1
#             index += 1
#             print(n)
#             print(works)
#         if n != 0 and next == len(works) - 1:
#             print('end!')
#             next = -1
#             while works[next] < 2:
#                 next -= 1
#             works[next] -= 1
#             n -= 1
#             print(n)
#             print(works)
#         else:
#             next += 1
#     print(works)
#     for w in works:
#         answer += w ** 2
#     return answer