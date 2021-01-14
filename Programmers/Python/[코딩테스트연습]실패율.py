from collections import Counter

def solution(N, stages):
    failure_p = [] # 실패율을 담는 배열
    counter = Counter(stages) # 각 스테이지 별 도전중인 사람 수(딕셔너리)
    keys = sorted(list(counter.keys())) # 정렬된 counter의 키 목록
    items = sorted(counter.items()) # 정렬된 counter의 아이템 목록

    for n in range(N): # 반복문을 통해서: 모든 스테이지 숫자는 n+1로 접근(0->1번 스테이지, 1->2번 스테이지...)
        if n+1 not in keys: # 스테이지에 도달한 유저가 없을 경우
            failure_p.append((n+1, 0)) # 해당 스테이지 실패율 0 넣기
        else:
            # 해당 스테이지에 도달한 사람이 있다면, items와 keys를 이용해 수식 계산하여 실패율 넣기
            failure_p.append((n+1, items[keys.index(n+1)][1] / sum(p for s, p in items[keys.index(n+1):])))

    failure_p.sort(key=lambda x:x[1], reverse=True) # 실패율 배열을 실패율 값을 기준으로 정렬
    return [s for s,p in failure_p] # 정렬된 실패율 배열에서 스테이지 값만 뽑아온다.
