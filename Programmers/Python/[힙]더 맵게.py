import heapq

def solution(scoville, K) :
    answer = 0 
    heapq.heapify(scoville)
    while len(scoville) > 1:
        m = heapq.heappop(scoville)
        if m >= K:
            return answer
        m2 = heapq.heappop(scoville)
        heapq.heappush(scoville, m+(m2*2))
        answer += 1   
    if scoville[0] >=K:
        return answer   
    return -1
    

# def solution(scoville, K) :
#     answer = 0
#     while len(scoville) > 1 :
#         m = min(scoville)
#         if m >= K :
#             return answer
#         del scoville[scoville.index(m)]
#         m2 = min(scoville)
#         del scoville[scoville.index(m2)]
#         scoville.append(m+(m2*2))
#         answer+=1
#     if scoville[0] >=K:
#         return answer
#     else: return -1