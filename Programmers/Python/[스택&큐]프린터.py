def solution(priorities, location):
    answer = 0 
    p = list(zip(priorities,range(len(priorities))))
    target = p[location]
    
    while target in p:
        temp = p.pop(0)
        if not p: return answer+1
        if max(p)[0] > temp[0]:
            p.append(temp)
        else:
            if temp == target:
                answer += 1
                break
            else:
                answer += 1
    
    return answer