import collections
from functools import reduce

def solution(clothes):
    answer = 1
    #print(clothes)
    #print(collections.Counter(clothes))
    
    clothes = dict(clothes) # clothes dictionary화
    val = list(clothes.values()) # 옷 종류만 꺼내오고
    counter = collections.Counter(val) # 옷 종류별 갯수 계산
    #print(kind in clothes)
    
    answer = reduce(lambda x,y : x*(y+1), counter.values(),1) -1
    
  
    return answer

    #lambda가 계산 역할, reduce가 처음부터 끝까지, 1이 초기값
    
    #valCount = list(counter.values()) # 갯수만 리스트로 꺼내오고
    #print(valCount)
    #for i in valCount:
    #    answer *= i+1 # i가 인덱스니까 +1해야 갯수가 된다.
    #    print(answer, i)
    
    #return answer-1