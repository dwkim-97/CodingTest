def solution(citations):
    answer = len(citations)
    citations.sort()

    while 1:
        cnt =0
        for value in citations:
            if value >= answer:
                cnt+=1
            if answer <= cnt:
                return answer
        answer-=1

    return answer