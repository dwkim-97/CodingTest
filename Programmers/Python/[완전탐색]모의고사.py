def solution(answers):
    answer = []
    scores = [[1,0],[2,0],[3,0]]
    p1 = [1,2,3,4,5] 
    p2 = [2,1,2,3,2,4,2,5]
    p3 = [3,3,1,1,2,2,4,4,5,5]
    
    p1 = p1 * (len(answers) // len(p1) +1)
    p2 = p2 * (len(answers) // len(p2) +1)
    p3 = p3 * (len(answers) // len(p3) +1)
    
    for i in range(len(answers)):
        if answers[i] == p1[i]:
            scores[0][1] += 1
        if answers[i] == p2[i]:
            scores[1][1] += 1
        if answers[i] == p3[i]:
            scores[2][1] += 1
            
    max_score = max(scores, key = lambda x:x[1])[1]
    for index, score in scores:
        if score == max_score:
            answer.append(index)
            
    return sorted(answer)

    